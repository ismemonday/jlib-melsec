package org.mgd.net;

import org.mgd.data.McConnectParams;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.concurrent.TimeUnit;

/**
 * @author mgd [maoguidong@standard-robots.com]
 * @data 2022/7/6 下午4:45
 */
public class McConnectTcp extends McConnect{
    private Socket socket;

    public McConnectTcp(McConnectParams params) {
        super(params);
    }

    @Override
    public void doRequest(ByteArrayOutputStream os) throws IOException {
        if(!socket.isConnected()){
            socket.connect(new InetSocketAddress(params.getUrl(), params.getPort()));
        }
        socket.getOutputStream().write(os.toByteArray());
    }

    @Override
    public void connectImpl() throws IOException {
        socket=new Socket();
        socket.setKeepAlive(params.isKeepAlive());
        socket.setTcpNoDelay(true);
        socket.connect(new InetSocketAddress(params.getUrl(), params.getPort()));
    }

    @Override
    public ByteArrayInputStream waitResp(int i, TimeUnit seconds) {
        return null;
    }
}
