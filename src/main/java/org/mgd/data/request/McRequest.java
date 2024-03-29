package org.mgd.data.request;

import org.mgd.Mc;
import org.mgd.data.McMessage;
import org.mgd.data.response.McResponse;
import org.mgd.data.enums.*;
import org.mgd.utils.DataUtils;

import java.util.concurrent.TimeUnit;

/**
 * 请求MC的数据
 *
 * @author mgd [maoguidong@standard-robots.com]
 * @data 2022/6/29 下午4:46
 */
public abstract class McRequest<T> extends McMessage{
    private McResponse response;
    /**
     * 起始软元件地址
     */
    private int startAddress;
    /**
     * 等待响应时间
     */
    private int waitRespTimeOut;
    private TimeUnit waitTimeOutUnit;
    /**
     * 请求指令
     */
    private RequestCommandEnum requestCommand;
    /**
     * 读取的位数
     */
    private int quantity;

    McRequest(McResponse response, int startAddress, int waitRespTimeOut, TimeUnit waitTimeOutUnit, RequestCommandEnum requestCommand,int quantity,byte[] softPoint,byte[] value) {
        super(Mc.FRAME_HEADER_3E_REQUEST,
                Mc.FRAME_ADDRESS_3E_4E_NETWORK_NO,
                Mc.FRAME_ADDRESS_3E_4E_CONTROLLER_NO,
                Mc.FRAME_ADDRESS_3E_4E_DEST_MODULE_NO,
                Mc.FRAME_ADDRESS_3E_4E_DEST_MODULE_STATION,
                Mc.FRAME_WATCHER_TIMER,
                requestCommand.getCode(),
                null,
                DataUtils.byteResolve(startAddress, 3),
                SoftUnitCodeEnum.REGISTER_DATA.getCode(),
                softPoint
                , value, null, null, null
        );
        this.response = response;
        this.startAddress = startAddress;
        this.waitRespTimeOut = waitRespTimeOut;
        this.waitTimeOutUnit = waitTimeOutUnit;
        this.requestCommand = requestCommand;
        this.quantity = quantity;
    }



    public McResponse getResponse() {
        return response;
    }

    public void setResponse(McResponse response) {
        this.response = response;
    }

    public int getStartAddress() {
        return startAddress;
    }

    public void setStartAddress(int startAddress) {
        this.startAddress = startAddress;
    }

    public int getWaitRespTimeOut() {
        return waitRespTimeOut;
    }

    public void setWaitRespTimeOut(int waitRespTimeOut) {
        this.waitRespTimeOut = waitRespTimeOut;
    }

    public TimeUnit getWaitTimeOutUnit() {
        return waitTimeOutUnit;
    }

    public void setWaitTimeOutUnit(TimeUnit waitTimeOutUnit) {
        this.waitTimeOutUnit = waitTimeOutUnit;
    }

    public RequestCommandEnum getRequestCommand() {
        return requestCommand;
    }

    public void setRequestCommand(RequestCommandEnum requestCommand) {
        this.requestCommand = requestCommand;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
