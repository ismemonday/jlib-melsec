package org.mgd.data.enums;

/**
 * 数据帧头
 * @author mgd [maoguidong@standard-robots.com]
 * @data 2022/7/11 上午11:20
 */
public enum FrameHeaderEnum implements RegisterDesc{
    FRAME_HEADER_3E_REQ(new byte[]{(byte) 0x50,00},"3E帧请求头"),
    FRAME_HEADER_3E_RESP(new byte[]{(byte) 0xD0,00},"3E帧响应头")
    ;

    private byte[] code;

    private final String des;

    FrameHeaderEnum(byte[] code,String des){
        this.code=code;
        this.des=des;
    }


    @Override
    public String getDesc() {
        return des;
    }

    @Override
    public byte[] getCode() {
        return code;
    }
}
