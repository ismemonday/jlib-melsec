package org.mgd.data;
import org.mgd.data.enums.RequestCommandEnum;
import org.mgd.data.enums.SoftUnitCodeEnum;

import java.util.concurrent.TimeUnit;

/**
 * 请求MC的数据
 * @author mgd [maoguidong@standard-robots.com]
 * @data 2022/6/29 下午4:46
 */
final public class McRequest extends McMessage{
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
     * 软元件代码
     */
    private SoftUnitCodeEnum softUnitCode;
    /**
     * 软元件点数
     */
    private short softUnitPoint;
    /**
     * 软元件点数据
     */
    private short softUnitPointData;



    public static McRequest build() {
       //build(1, 1, 1, 1, 1, 1, 1);
        return null;
    }
    public static McRequest build(int startAddress,int waitRespTimeOut,TimeUnit waitTimeOutUnit,RequestCommandEnum requestCommand,SoftUnitCodeEnum softUnitCode,short softUnitPoint,short softUnitPointData) {
        return new McRequest();
    }

    McRequest(){
        //super(new byte[]{1});
    }

    /**
     * 参数合法性校验
     */
    private void dataValid(){

    }
}
