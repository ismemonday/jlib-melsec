package org.mgd.exception;

/**
 * @author mgd [maoguidong@standard-robots.com]
 * @data 2022/7/11 上午11:50
 */
public class McException extends RuntimeException{

    private final String msg;

    public McException(String s) {
        super(s);
        this.msg=s;
    }
}
