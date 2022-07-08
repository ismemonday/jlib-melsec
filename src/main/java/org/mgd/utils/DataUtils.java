package org.mgd.utils;


/**
 * @author mgd [maoguidong@standard-robots.com]
 * @data 2022/7/6 下午4:05
 */
public class DataUtils {

    /**
     * 字节逆转如00 01->01 00
     * @param bytes
     * @return
     */
    public static byte[] byteResolve(byte[] bytes){
        if(bytes!=null&&bytes.length>0){
            byte[] newByte = bytes.clone();
            for (int i = 0; i < bytes.length; i++) {
             newByte[i]=bytes[bytes.length-i-1];
            }
            return newByte;
        }
        return null;
    }

    /**
     * 将int值转为字节如
     * @param value
     * @param byteLength
     * @return
     */
    public static byte[] byteResolve(int value,int byteLength){

        return null;
    }



}
