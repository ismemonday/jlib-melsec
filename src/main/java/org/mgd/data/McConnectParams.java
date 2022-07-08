package org.mgd.data;


/**
 * @author mgd [maoguidong@standard-robots.com]
 * @data 2022/7/5 下午3:29
 */
public class McConnectParams {
    private String url;
    private int port;
    private boolean keepAlive;

    private McConnectParams(String url, int port, boolean keepAlive) {
        this.url = url;
        this.port = port;
        this.keepAlive = keepAlive;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public boolean isKeepAlive() {
        return keepAlive;
    }

    public void setKeepAlive(boolean keepAlive) {
        this.keepAlive = keepAlive;
    }

    public static McConnectParams build(String url, int port){
        return new McConnectParams(url,port,false);
    }

    public static McConnectParams build(String url, int port,boolean keepAlive){
        return new McConnectParams(url,port,keepAlive);
    }
}
