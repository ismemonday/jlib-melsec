package org.mgd.utils;

import org.mgd.exception.McException;

/**
 * @author mgd [maoguidong@standard-robots.com]
 * @data 2022/7/11 下午6:48
 */
public class McAssert {

    public static void noNull(Object obj, String msg) {
        if(obj==null){
            throw new McException(msg);
        }
    }

    public static void isNull(Object obj, String msg) {
        if(obj!=null){
            throw new McException(msg);
        }
    }
}
