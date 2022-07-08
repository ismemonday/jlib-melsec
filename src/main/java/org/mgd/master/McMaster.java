package org.mgd.master;

import org.mgd.net.McConnectFactory;
import org.mgd.data.DataFrame;
import org.mgd.data.McConnectParams;
import org.mgd.data.McRequest;
import org.mgd.data.McResponse;
import org.mgd.net.McConnect;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @author mgd [maoguidong@standard-robots.com]
 * @data 2022/7/5 下午3:23
 */
public abstract class McMaster {
     final DataFrame frame;
     McConnect connect;
     volatile boolean isConnected=false;
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
    public McResponse processRequest(McRequest mcRequest) throws IOException {
        if(!isConnected){
            doConnect();
        }
        return doRequest(mcRequest);
    }

    protected McResponse doRequest(McRequest mcRequest) throws IOException {
           doRequestImpl(mcRequest);
           connect.doRequest(os);
           is = connect.waitResp(1, TimeUnit.SECONDS);
           return doResponseImpl(mcRequest);
    }

    /**
     * 请求后的数据处理
     * @param mcRequest
     * @return
     */
    protected abstract McResponse doResponseImpl(McRequest mcRequest);


    /**
     * 发送请求具体的步骤
     * @param mcRequest
     * @throws IOException
     */
    protected abstract void doRequestImpl(McRequest mcRequest) throws IOException;

    /**
     * 链接
     */
    protected abstract void doConnect() throws IOException;
}