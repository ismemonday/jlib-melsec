package org.mgd.net;

import org.mgd.data.McConnectParams;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @author mgd [maoguidong@standard-robots.com]
 * @data 2022/7/5 下午3:59
 */
public abstract class McConnect {

    protected McConnectParams params;

    public McConnect(McConnectParams params) {
        this.params=params;
    }

    /**
     * 发送请求
     * @param os
     * @throws IOException
     */
    public abstract void doRequest(ByteArrayOutputStream os) throws IOException;

    /**
     * 创建链接
     * 创建链接
     * @throws IOException
     */
    public abstract void connectImpl() throws IOException;


    /**
     * 等待响应
     * @param i
     * @param seconds
     * @throws IOException
     * @return
     */
    public abstract ByteArrayInputStream waitResp(int i, TimeUnit seconds) throws IOException;

    /**
     * 关闭链接
     * @throws IOException
     */
    public abstract void close() throws  IOException;
}
