package org.mgd;

/**
 * @author mgd [maoguidong@standard-robots.com]
 * @data 2022/6/29 上午11:24
 */
public class Mc {
    public final static byte[] FRAME_HEADER_3E_REQUEST={0x50,0x00};
    public final static byte[] FRAME_HEADER_3E_RESP={(byte) 0XD0,0x00};
    /**
     * 默认访问路径-网络编号
     */
    public final static byte[] FRAME_ADDRESS_3E_4E_NETWORK_NO={0};
    /**
     * 默认访问路径-可编程控制器编号
     */
    public final static byte[] FRAME_ADDRESS_3E_4E_CONTROLLER_NO={(byte) 0XFF};
    /**
     * 默认访问路径-请求目标模块I/O编号
     */
    public final static byte[] FRAME_ADDRESS_3E_4E_DEST_MODULE_NO={(byte)0XFF,03};
    /**
     * 默认访问路径-请求目标模块站号
     */
    public final static byte[] FRAME_ADDRESS_3E_4E_DEST_MODULE_STATION={0};
    /**
     * 监视定时器0000~00F0,0000永久
     */
    public final static byte[] FRAME_WATCHER_TIMER={00,00};
    /**
     * 字符串读写及长度
     */
    public final static byte[] FRAME_DATA_WRITE_READ_SHORT={01,00};
    public final static byte FRAME_DATA_WRITE_READ_SHORT_LENGTH=2;
    /**
     * int读写及长度
     */
    public final static byte[] FRAME_DATA_WRITE_READ_INT={02,00};
    public final static byte FRAME_DATA_WRITE_READ_INT_LENGTH=4;
    /**
     * float读写及长度
     */
    public final static byte[] FRAME_DATA_WRITE_READ_FLOAT={02,00};
    public final static byte FRAME_DATA_WRITE_READ_FLOAT_LENGTH=4;
    /**
     * long读写及长度
     */
    public final static byte[] FRAME_DATA_WRITE_READ_LONG={04,00};
    public final static byte FRAME_DATA_WRITE_READ_LONG_LENGTH=8;
    /**
     * 字符串读写及长度
     */
    public final static byte[] FRAME_DATA_WRITE_READ_STRING={0X0A,00};
    public final static byte FRAME_DATA_WRITE_READ_STRING_LENGTH=20;



}
