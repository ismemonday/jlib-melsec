package org.mgd.data;

/**
 * 字单位的操作
 * @author mgd [maoguidong@standard-robots.com]
 * @data 2022/7/12 下午7:18
 */
public interface McWord {
    /**
     * 浮点型请求数据
     * @param quantity
     */
    void respFlot(int quantity);

    /**
     * 整型请求数据
     * @param quantity
     */
    void respInt(int quantity);

    /**
     * 短整型数据
     * @param quantity
     */
    void respShort(int quantity);

    /**
     * 长整型数据
     * @param quantity
     */
    void respLong(int quantity);


}
