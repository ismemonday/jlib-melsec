package org.mgd.master;

import org.mgd.Mc;
import org.mgd.data.DataFrame;
import org.mgd.data.McConnectParams;
import org.mgd.data.McRequest;
import org.mgd.data.McResponse;
import org.mgd.net.McConnectFactory;

import java.io.ByteArrayOutputStream;
import java.io.IOException;


/**
 * @author mgd [maoguidong@standard-robots.com]
 * @data 2022/6/29 上午11:38
 */
public class McMasterTcp extends McMaster{

    protected McMasterTcp( McConnectParams params,DataFrame frame) {
        super(frame);
        McConnectFactory.createTcpConnect(params);
    }

    @Override
    protected McResponse doResponseImpl(McRequest mcRequest) {
        return null;
    }

    @Override
    protected void doRequestImpl(McRequest mcRequest) throws IOException {
        os=new ByteArrayOutputStream();
        writeFrameHeader(os,mcRequest);
    }

    @Override
    protected void doConnect() throws IOException {
        connect.connectImpl();
        this.isConnected=true;
    }

    /**
     * 写入副帧头
     * @param os
     * @param mcRequest
     * @throws IOException
     */
    private void writeFrameHeader(ByteArrayOutputStream os, McRequest mcRequest) throws IOException {
        if(DataFrame.FRAME_3E.equals(frame)){
            os.write(Mc.FRAME_HEADER_3E_REQUEST);
        }
        writePostAddress(os,mcRequest);
    }

    /**
     * 写访问路径
     * @param os
     * @param mcRequest
     */
    private void writePostAddress(ByteArrayOutputStream os, McRequest mcRequest) throws IOException {
        if(DataFrame.FRAME_3E.equals(frame)||DataFrame.FRAME_4E.equals(frame)){
            //网络编号
            os.write(mcRequest.getFRAME_ADDRESS_NETWORK_NO()==null?Mc.FRAME_ADDRESS_3E_4E_NETWORK_NO:mcRequest.getFRAME_ADDRESS_NETWORK_NO());
            //可编程控制器编号
            os.write(mcRequest.getFRAME_ADDRESS_CONTROLLER_NO()==null?Mc.FRAME_ADDRESS_3E_4E_CONTROLLER_NO:mcRequest.getFRAME_ADDRESS_CONTROLLER_NO());
            //请求目标模块I/O编号
            os.write(mcRequest.getFRAME_ADDRESS_DEST_MODULE_NO()==null?Mc.FRAME_ADDRESS_3E_4E_DEST_MODULE_NO:mcRequest.getFRAME_ADDRESS_DEST_MODULE_NO());
            //请求目标模块站号
            os.write(mcRequest.getFRAME_ADDRESS_DEST_MODULE_STATION()==null?Mc.FRAME_ADDRESS_3E_4E_DEST_MODULE_STATION:mcRequest.getFRAME_ADDRESS_DEST_MODULE_STATION());
        }
        writeDataLength(os,mcRequest);
    }

    /**
     * 写入数据长
     * @param os
     * @param mcRequest
     */
    private void writeDataLength(ByteArrayOutputStream os, McRequest mcRequest) throws IOException {
        byte[] frame_request_data_length = mcRequest.getFRAME_REQUEST_DATA_LENGTH();
        if(frame_request_data_length==null){
            mcRequest.countDataLength();
        }
        os.write(frame_request_data_length);
        writeWatchTimer(os,mcRequest);
    }

    /**
     * 写入监视定时器
     * @param os
     * @param mcRequest
     */
    private void writeWatchTimer(ByteArrayOutputStream os, McRequest mcRequest) throws IOException {
        os.write(mcRequest.getFRAME_WATCH_TIMER()==null?Mc.FRAME_WATCHER_TIMER:mcRequest.getFRAME_WATCH_TIMER());
        writeRequestData(os,mcRequest);
    }

    /**
     * 写入请求数据
     * @param os
     * @param mcRequest
     */
    private void writeRequestData(ByteArrayOutputStream os, McRequest mcRequest) {

    }
}
