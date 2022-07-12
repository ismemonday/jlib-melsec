package org.mgd.master;

import org.mgd.Mc;
import org.mgd.data.enums.DataFrame;
import org.mgd.data.McConnectParams;
import org.mgd.data.enums.WordLengthEnum;
import org.mgd.data.request.McRequest;
import org.mgd.data.response.McResponse;
import org.mgd.data.enums.FrameErrorCodeEnum;
import org.mgd.exception.McException;
import org.mgd.net.McConnectFactory;
import org.mgd.utils.DataUtils;
import org.mgd.utils.McAssert;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;


/**
 * @author mgd [maoguidong@standard-robots.com]
 * @data 2022/6/29 上午11:38
 */
public class McMasterTcp extends McMaster{

    protected McMasterTcp( McConnectParams params,DataFrame frame) {
        super(frame);
        connect=McConnectFactory.createTcpConnect(params);
    }

    @Override
    protected McResponse doResponseImpl(McRequest mcRequest) throws IOException {
        McResponse response = mcRequest.getResponse();
        try {
            McAssert.noNull(response,"response data is null");
            writeNormalData(mcRequest);
        }catch (Exception e){
            e.printStackTrace();
            connect.close();
        }
        return response;
    }

    /**
     * 填充常规数据
     */
    private <T> void writeNormalData(McRequest request) throws IOException {
        McResponse response = request.getResponse();
        is.read(new byte[7]);
        is.read(response.getFRAME_REQUEST_DATA_LENGTH());
        is.read(response.getFRAME_OVER_CODE());
        is.read(response.getFRAME_RESP_DATA());
        byte[] frame_over_code = response.getFRAME_OVER_CODE();
        byte[] errorCode = DataUtils.byteResolve(frame_over_code);
        if (Arrays.equals(errorCode, FrameErrorCodeEnum.RESP_SUCCESS.getCode())) {
            response.setCode(0);
        }else {
            response.setCode((0xffff&errorCode[0]<<8)&errorCode[1]);
            wrapRespMsg(response);
        }
        response.wrapRespData(request.getWordLength(),request.getQuantity());
    }

    private void wrapRespMsg(McResponse response) {
        response.setMsg("响应失败");
    }


    @Override
    protected void doRequestImpl(McRequest mcRequest) throws IOException {
        os=new ByteArrayOutputStream();
        writeFrameHeader(os,mcRequest);
    }

    @Override
    protected void doConnect() throws IOException {
        connect.connectImpl();
    }

    /**
     * 写入副帧头
     * @param os
     * @param mcRequest
     * @throws IOException
     */
    private void writeFrameHeader(ByteArrayOutputStream os, McRequest mcRequest) throws IOException {
        byte[] frame_header = mcRequest.getFRAME_HEADER();
        mcRequest.getResponse().setFRAME_HEADER(Mc.FRAME_HEADER_3E_RESP);
        McAssert.noNull(frame_header,"request data header is empty");
        os.write(frame_header);
        writePostAddress(os,mcRequest);
    }

    /**
     * 写访问路径
     * @param os
     * @param mcRequest
     */
    private void writePostAddress(ByteArrayOutputStream os, McRequest mcRequest) throws IOException {
        McResponse response = mcRequest.getResponse();
        byte[] frame_address_network_no = mcRequest.getFRAME_ADDRESS_NETWORK_NO();
        McAssert.noNull(frame_address_network_no,"request data frame_address_network_no is empty");
        response.setFRAME_ADDRESS_NETWORK_NO(frame_address_network_no);
        os.write(frame_address_network_no);
        byte[] frame_address_controller_no = mcRequest.getFRAME_ADDRESS_CONTROLLER_NO();
        McAssert.noNull(frame_address_controller_no,"request data frame_address_controller_no is empty");
        response.setFRAME_ADDRESS_CONTROLLER_NO(frame_address_controller_no);
        os.write(frame_address_controller_no);
        byte[] frame_address_dest_module_no = mcRequest.getFRAME_ADDRESS_DEST_MODULE_NO();
        McAssert.noNull(frame_address_dest_module_no,"request data frame_address_dest_module_no is empty");
        response.setFRAME_ADDRESS_DEST_MODULE_NO(frame_address_dest_module_no);
        os.write(frame_address_dest_module_no);
        byte[] frame_address_dest_module_station = mcRequest.getFRAME_ADDRESS_DEST_MODULE_STATION();
        McAssert.noNull(frame_address_dest_module_station,"request data frame_address_dest_module_station is empty");
        response.setFRAME_ADDRESS_DEST_MODULE_STATION(frame_address_dest_module_station);
        os.write(frame_address_dest_module_station);
        writeDataLength(os, mcRequest);
    }

    /**
     * 写入数据长
     * @param os
     * @param mcRequest
     */
    private void writeDataLength(ByteArrayOutputStream os, McRequest mcRequest) throws IOException {
        byte[] frame_request_data_length = mcRequest.getFRAME_REQUEST_DATA_LENGTH();
        McAssert.noNull(frame_request_data_length,"request data data_length is empty");
        mcRequest.getResponse().setFRAME_REQUEST_DATA_LENGTH(DataUtils.byteResolve(mcRequest.getQuantity()*mcRequest.getWordLength().getLength()+2, 2));
        mcRequest.getResponse().setFRAME_OVER_CODE(FrameErrorCodeEnum.RESP_SUCCESS.getCode());
        os.write(frame_request_data_length);
        writeWatchTimer(os,mcRequest);
    }

    /**
     * 写入监视定时器
     * @param os
     * @param mcRequest
     */
    private void writeWatchTimer(ByteArrayOutputStream os, McRequest mcRequest) throws IOException {
        byte[] frame_watch_timer = mcRequest.getFRAME_WATCH_TIMER();
        McAssert.noNull(frame_watch_timer,"request data frame_watch_timer is empty");
        os.write(frame_watch_timer);
        writeRequestData(os,mcRequest);
    }

    /**
     * 写入请求数据
     * @param os
     * @param mcRequest
     */
    private void writeRequestData(ByteArrayOutputStream os, McRequest mcRequest) throws IOException {
        byte[] frame_request_command = mcRequest.getFRAME_REQUEST_COMMAND();
        McAssert.noNull(frame_request_command,"request data frame_request_command is empty");
        os.write(frame_request_command);
        byte[] frame_request_command_son = mcRequest.getFRAME_REQUEST_COMMAND_SON();
        if(frame_request_command_son!=null){
            os.write(frame_request_command_son);
        }
        byte[] frame_request_start_soft_address = mcRequest.getFRAME_REQUEST_START_SOFT_ADDRESS();
        McAssert.noNull(frame_request_start_soft_address,"request data frame_request_start_soft_address is empty");
        os.write(frame_request_start_soft_address);
        byte[] frame_request_soft_unit_code = mcRequest.getFRAME_REQUEST_SOFT_UNIT_CODE();
        McAssert.noNull(frame_request_soft_unit_code,"request data frame_request_soft_unit_code is empty");
        os.write(frame_request_soft_unit_code);
        byte[] frame_request_soft_unit_point = mcRequest.getFRAME_REQUEST_SOFT_UNIT_POINT();
        McAssert.noNull(frame_request_soft_unit_point,"request data frame_request_soft_unit_point is empty");
        os.write(frame_request_soft_unit_point);
        byte[] frame_request_soft_unit_point_data = mcRequest.getFRAME_REQUEST_SOFT_UNIT_POINT_DATA();
        if(frame_request_soft_unit_point_data!=null){
            os.write(frame_request_soft_unit_point_data);
        }
        mcRequest.getResponse().setFRAME_RESP_DATA(new byte[mcRequest.getQuantity()*mcRequest.getWordLength().getLength()]);
    }
}
