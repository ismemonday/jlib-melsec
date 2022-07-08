package org.mgd.data.enums;

/**
 * 寄存器描述
 * @author mgd [maoguidong@standard-robots.com]
 * @data 2022/7/8 下午5:36
 */
public interface RegisterDesc {
    /**
     * 获取描述
     * @return
     */
    String getDesc();

    /**
     * 获取字节
     * @return
     */
    byte[] getCode();
}
