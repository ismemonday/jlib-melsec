package org.mgd.data.enums;

/**
 * 软元件代码
 * @author mgd [maoguidong@standard-robots.com]
 * @data 2022/7/6 下午6:05
 */
public enum SoftUnitCodeEnum implements RegisterDesc{
    REGISTER_DATA(new byte[]{(byte) 0xA8},"数据寄存器")
    ;
    private byte[] code;

    private final String des;

    SoftUnitCodeEnum(byte[] code,String des){
        this.code=code;
        this.des=des;
    }

    @Override
    public String getDesc() {
        return des;
    }

    @Override
    public byte[] getCode(){
        return code;
    }
}
