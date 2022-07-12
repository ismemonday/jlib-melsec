package org.mgd.master;

import org.mgd.data.enums.DataFrame;
import org.mgd.data.request.McRequest;
import org.mgd.data.response.McResponse;
import org.mgd.net.McConnect;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * @author mgd [maoguidong@standard-robots.com]
 * @data 2022/7/5 下午3:23
 */
public abstract class McMaster{
     final DataFrame frame;
     McConnect connect;
     ByteArrayOutputStream os;
     ByteArrayInputStream is;

    protected McMaster(DataFrame frame) {
        this.frame = frame;
    }

    /**
     * 创建请求
     * @param mcRequest
     * @return
     */
    public <T> McResponse<T> processRequest(McRequest<T> mcRequest) throws IOException {
        if(!connect.isConnected()){
            doConnect();
        }
        return doRequest(mcRequest);
    }

    protected McResponse doRequest(McRequest mcRequest) throws IOException {
           doRequestImpl(mcRequest);
           connect.doRequest(os);
           is = connect.waitResp(mcRequest.getWaitRespTimeOut(),mcRequest.getWaitTimeOutUnit());
           return doResponseImpl(mcRequest);
    }

    /**
     * 请求后的数据处理
     * @param mcRequest
     * @return
     * @throws IOException
     */
    protected abstract McResponse doResponseImpl(McRequest mcRequest) throws IOException;


    /**
     * 发送请求具体的步骤
     * @param mcRequest
     * @throws IOException
     */
    protected abstract void doRequestImpl(McRequest mcRequest) throws IOException;

    /**
     * 链接
     * @throws IOException
     */
    protected abstract void doConnect() throws IOException;
}
