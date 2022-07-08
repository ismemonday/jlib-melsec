package org.mgd.net;

import org.mgd.data.McConnectParams;

/**
 * @author mgd [maoguidong@standard-robots.com]
 * @data 2022/7/6 下午4:43
 */
public class McConnectFactory {

    public static McConnect createTcpConnect(McConnectParams params) {
        return new McConnectTcp(params);
    }
}
