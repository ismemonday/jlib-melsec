package org.mgd.net;

import org.mgd.data.McConnectParams;
import org.mgd.exception.McException;
import org.mgd.exception.McTimeOutException;
import org.mgd.utils.DataUtils;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author mgd [maoguidong@standard-robots.com]
 * @data 2022/7/6 下午4:45
 */
public class McConnectTcp extends McConnect{
    private Socket socket;
    private byte[] writeData;

    public McConnectTcp(McConnectParams params) {
        super(params);
    }

    @Override
    public void doRequest(ByteArrayOutputStream os) throws IOException {
        if(!socket.isConnected()){
            socket.connect(new InetSocketAddress(params.getUrl(), params.getPort()));
        }
        writeData=os.toByteArray();
        OutputStream soos = socket.getOutputStream();
        soos.write(writeData);
        soos.flush();
        os.close();
    }

    @Override
    public void connectImpl() throws IOException {
        socket=new Socket();
        socket.setKeepAlive(params.isKeepAlive());
        socket.setTcpNoDelay(true);
        socket.connect(new InetSocketAddress(params.getUrl(), params.getPort()));
        isConnected=true;
    }

    @Override
    public synchronized ByteArrayInputStream waitResp(int timeout, TimeUnit timeUnit) throws IOException {
        byte[] bytes=new byte[256];
        if(!socket.isConnected()){
            connectImpl();
        }
        InputStream inputStream = socket.getInputStream();
        FutureTask<Boolean> task = new FutureTask<Boolean>(() -> {
            inputStream.read(bytes);
            return true;
        });
        new Thread(task,"wait-resp-" + new Random().nextInt(100)).start();
        try {
            Boolean result = task.get(timeout, timeUnit);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            System.out.println(e);
            throw new McException("请求数据异常:"+ DataUtils.byteToStr(writeData));
        } catch (TimeoutException e) {
            close();
           throw new McTimeOutException("wait resp timeOut");
        }
        ByteArrayInputStream bains = new ByteArrayInputStream(bytes);
        if (!params.isKeepAlive()) {
           close();
        }
        return bains;
    }

    @Override
    public void close() throws IOException {
        socket.close();
        isConnected=false;
    }
}
