package org.mgd.utils;


import org.mgd.exception.McException;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

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
     * 将整数值转为字节如
     * @param value
     * @param byteLength
     * @return
     */
    public static byte[] byteResolve(long value,int byteLength){
        if(byteLength>8){throw new McException("byteResolve error,byteLength not allow");}
        byte[] bytes = new byte[byteLength];
        for (int i = 0; i < bytes.length; i++) {
            bytes[i]=(byte) ((value>>(8*(byteLength-1-i)))&0xff);
        }
        return byteResolve(bytes);
    }


    public static String byteToStr(byte[] writeData) {
        if(writeData==null){
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder("[");
        for (byte writeDatum : writeData) {
            stringBuilder.append(Integer.toHexString(writeDatum&0xff));
            stringBuilder.append(",");
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }


    public static byte[] byteResolveEvery(byte[] respData, int length) {
        McAssert.noNull(respData, "respData is NULL");
        McAssert.isTrue(respData.length%length==0,"respData not valid");
        int quantity = respData.length / length;
        byte[] tmpWord=new byte[length];
        ByteArrayOutputStream temStream = new ByteArrayOutputStream();
        for (int i = 0; i < quantity; i++) {
            tmpWord= Arrays.copyOfRange(respData, i*length, (i+1)*length);
            byte[] norWord = byteResolve(tmpWord);
            try {
                temStream.write(norWord);
            } catch (IOException e) {
                System.out.println("byteResolveEvery error");
                return null;
            }
        }
       return temStream.toByteArray();
    }

    public static String arrayToStr(Object[] data) {
        if(data==null){
            return "null";
        }
        StringBuilder stringBuilder = new StringBuilder("[");
        for (int i = 0; i < data.length; i++) {
            stringBuilder.append(data[i]);
            if(i!= data.length-1){
                stringBuilder.append(",");
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
