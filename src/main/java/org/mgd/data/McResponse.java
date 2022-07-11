package org.mgd.data;

import java.net.DatagramPacket;

/**
 * @author mgd [maoguidong@standard-robots.com]
 * @data 2022/6/29 下午4:45
 */
final public  class McResponse extends McMessage {

    private boolean respResult=false;

    private int code;

    private String errorMsg;

    private byte[] resultData;

    public static DatagramPacket responseData() {
        return new DatagramPacket(new byte[]{}, 11);
    }

    public boolean getRespResult() {
        return respResult;
    }

    public void setRespResult(boolean respResult) {
        this.respResult = respResult;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public byte[] getResultData() {
        return resultData;
    }

    public void setResultData(byte[] resultData) {
        this.resultData = resultData;
    }

}
