package org.mgd.data.enums;
/**
 * 请求数据指令
 * @author mgd [maoguidong@standard-robots.com]
 * @data 2022/7/6 下午5:25
 */
public enum  RequestCommandEnum implements RegisterDesc{
    /**
     * 字单位批量读取
     */
    BATCH_READ_BY_WORD(new byte[]{01,04,00,00},"指令-字单位批量读取"),
    /**
     * 位单位批量读取
     */
    BATCH_READ_BY_BIT(new byte[]{01,04,01,00},"指令-位单位批量读取"),
    /**
     * 字单位批量写入
     */
    BATCH_WRITE_BY_WORD(new byte[]{01,0x14,00,00},"指令-字单位批量写入"),
    /**
     * 位单位批量写入
     */
    BATCH_WRITE_BY_BIT(new byte[]{01,0x14,01,00},"指令-位单位批量写入");
    /**
     * 字单位随即读取
     */
    /**
     * 字单位随机写入
     */
    /**
     * 位单位随机写入
     */





    private final byte[] code;

    private final String  des;

    RequestCommandEnum(byte[] code,String des){
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
