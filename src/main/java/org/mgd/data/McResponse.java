package org.mgd.data;

import java.net.DatagramPacket;

/**
 * @author mgd [maoguidong@standard-robots.com]
 * @data 2022/6/29 下午4:45
 */
public  class McResponse {
    private int code;

    private String errorMsg;

    private byte[] resultData;

    public static DatagramPacket responseData() {
        return new DatagramPacket(new byte[]{}, 11);
    }
}
