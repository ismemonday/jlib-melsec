package org.mgd.data.enums;

/**
 * 数据帧头
 * @author mgd [maoguidong@standard-robots.com]
 * @data 2022/7/11 上午11:20
 */
public enum FrameErrorCodeEnum implements RegisterDesc{
    RESP_SUCCESS(new byte[]{(byte) 0x00,00},"响应成功"),
    RESP_ERROR(new byte[]{(byte) 0x00,01},"响应失败")
    ;

    private byte[] code;

    private final String des;

    FrameErrorCodeEnum(byte[] code, String des){
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
