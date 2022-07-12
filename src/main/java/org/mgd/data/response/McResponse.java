package org.mgd.data.response;

import org.mgd.data.McMessage;
import org.mgd.data.enums.WordLengthEnum;

import java.io.IOException;


/**
 * @author mgd [maoguidong@standard-robots.com]
 * @data 2022/6/29 下午4:45
 */
public abstract class McResponse<T> extends McMessage {

    protected int code=-1;

    protected String msg;

    public void setCode(int code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public WordLengthEnum getWordLength() {
        return null;
    }

    /**
     * 封装请求数据
     * @param wordLength
     * @param quantity
     */
    public abstract void wrapRespData(WordLengthEnum wordLength, int quantity) throws IOException;


    public abstract T[] getData();

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
