package org.mgd.data;

import org.mgd.Mc;
import org.mgd.utils.DataUtils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * @author mgd [maoguidong@standard-robots.com]
 * @data 2022/7/6 下午4:19
 */
public abstract class McMessage implements Message {
    /**
     * 副帧头
     */
    protected byte[] FRAME_HEADER;
    /**
     * 访问路径-网络编号
     */
    protected byte[] FRAME_ADDRESS_NETWORK_NO;
    /**
     * 访问路径-可编程控制器网络编号
     */
    protected byte[] FRAME_ADDRESS_CONTROLLER_NO;
    /**
     * 访问路径-请求目标模块IO编号
     */
    protected byte[] FRAME_ADDRESS_DEST_MODULE_NO;
    /**
     * 请求目标模块站号
     */
    protected byte[] FRAME_ADDRESS_DEST_MODULE_STATION;
    /**
     * 请求数据长
     */
    protected byte[] FRAME_REQUEST_DATA_LENGTH;
    /**
     * 监视定时器
     */
    protected byte[] FRAME_WATCH_TIMER;
    /**
     * 请求数据-指令
     */
    protected byte[] FRAME_REQUEST_COMMAND;
    /**
     * 请求数据-子指令
     */
    protected byte[] FRAME_REQUEST_COMMAND_SON;
    /**
     * 请求数据-起始软元件
     */
    protected byte[] FRAME_REQUEST_START_SOFT_ADDRESS;
    /**
     * 请求数据-软元件代码
     */
    protected byte[] FRAME_REQUEST_SOFT_UNIT_CODE;
    /**
     * 请求数据-软元件点数
     */
    protected byte[] FRAME_REQUEST_SOFT_UNIT_POINT;
    /**
     * 请求数据-软元件点数据
     */
    protected byte[] FRAME_REQUEST_SOFT_UNIT_POINT_DATA;
    /**
     * 结束代码
     */
    protected byte[] FRAME_OVER_CODE;
    /**
     * 响应数据
     */
    protected byte[] FRAME_RESP_DATA;
    /**
     * 出错信息
     */
    protected byte[] FRAME_ERROR_DATA;

    public byte[] getFRAME_HEADER() {
        return FRAME_HEADER;
    }

    public McMessage setFRAME_HEADER(byte[] FRAME_HEADER) {
        this.FRAME_HEADER = FRAME_HEADER;
        return this;
    }

    public byte[] getFRAME_ADDRESS_NETWORK_NO() {
        return FRAME_ADDRESS_NETWORK_NO;
    }

    public McMessage setFRAME_ADDRESS_NETWORK_NO(byte[] FRAME_ADDRESS_NETWORK_NO) {
        this.FRAME_ADDRESS_NETWORK_NO = FRAME_ADDRESS_NETWORK_NO;
        return this;
    }

    public byte[] getFRAME_ADDRESS_CONTROLLER_NO() {
        return FRAME_ADDRESS_CONTROLLER_NO;
    }

    public McMessage setFRAME_ADDRESS_CONTROLLER_NO(byte[] FRAME_ADDRESS_CONTROLLER_NO) {
        this.FRAME_ADDRESS_CONTROLLER_NO = FRAME_ADDRESS_CONTROLLER_NO;
        return this;
    }

    public byte[] getFRAME_ADDRESS_DEST_MODULE_NO() {
        return FRAME_ADDRESS_DEST_MODULE_NO;
    }

    public McMessage setFRAME_ADDRESS_DEST_MODULE_NO(byte[] FRAME_ADDRESS_DEST_MODULE_NO) {
        this.FRAME_ADDRESS_DEST_MODULE_NO = FRAME_ADDRESS_DEST_MODULE_NO;
        return this;
    }

    public byte[] getFRAME_ADDRESS_DEST_MODULE_STATION() {
        return FRAME_ADDRESS_DEST_MODULE_STATION;
    }

    public McMessage setFRAME_ADDRESS_DEST_MODULE_STATION(byte[] FRAME_ADDRESS_DEST_MODULE_STATION) {
        this.FRAME_ADDRESS_DEST_MODULE_STATION = FRAME_ADDRESS_DEST_MODULE_STATION;
        return this;
    }

    public byte[] getFRAME_REQUEST_DATA_LENGTH() {
        return FRAME_REQUEST_DATA_LENGTH;
    }

    public McMessage setFRAME_REQUEST_DATA_LENGTH(byte[] FRAME_REQUEST_DATA_LENGTH) {
        this.FRAME_REQUEST_DATA_LENGTH = FRAME_REQUEST_DATA_LENGTH;
        return this;
    }

    public byte[] getFRAME_WATCH_TIMER() {
        return FRAME_WATCH_TIMER;
    }

    public McMessage setFRAME_WATCH_TIMER(byte[] FRAME_WATCH_TIMER) {
        this.FRAME_WATCH_TIMER = FRAME_WATCH_TIMER;
        return this;
    }

    public byte[] getFRAME_REQUEST_COMMAND() {
        return FRAME_REQUEST_COMMAND;
    }

    public McMessage setFRAME_REQUEST_COMMAND(byte[] FRAME_REQUEST_COMMAND) {
        this.FRAME_REQUEST_COMMAND = FRAME_REQUEST_COMMAND;
        return this;
    }

    public byte[] getFRAME_REQUEST_COMMAND_SON() {
        return FRAME_REQUEST_COMMAND_SON;
    }

    public McMessage setFRAME_REQUEST_COMMAND_SON(byte[] FRAME_REQUEST_COMMAND_SON) {
        this.FRAME_REQUEST_COMMAND_SON = FRAME_REQUEST_COMMAND_SON;
        return this;
    }

    public byte[] getFRAME_REQUEST_START_SOFT_ADDRESS() {
        return FRAME_REQUEST_START_SOFT_ADDRESS;
    }

    public McMessage setFRAME_REQUEST_START_SOFT_ADDRESS(byte[] FRAME_REQUEST_START_SOFT_ADDRESS) {
        this.FRAME_REQUEST_START_SOFT_ADDRESS = FRAME_REQUEST_START_SOFT_ADDRESS;
        return this;
    }

    public byte[] getFRAME_REQUEST_SOFT_UNIT_CODE() {
        return FRAME_REQUEST_SOFT_UNIT_CODE;
    }

    public McMessage setFRAME_REQUEST_SOFT_UNIT_CODE(byte[] FRAME_REQUEST_SOFT_UNIT_CODE) {
        this.FRAME_REQUEST_SOFT_UNIT_CODE = FRAME_REQUEST_SOFT_UNIT_CODE;
        return this;
    }

    public byte[] getFRAME_REQUEST_SOFT_UNIT_POINT() {
        return FRAME_REQUEST_SOFT_UNIT_POINT;
    }

    public McMessage setFRAME_REQUEST_SOFT_UNIT_POINT(byte[] FRAME_REQUEST_SOFT_UNIT_POINT) {
        this.FRAME_REQUEST_SOFT_UNIT_POINT = FRAME_REQUEST_SOFT_UNIT_POINT;
        return this;
    }

    public byte[] getFRAME_REQUEST_SOFT_UNIT_POINT_DATA() {
        return FRAME_REQUEST_SOFT_UNIT_POINT_DATA;
    }

    public McMessage setFRAME_REQUEST_SOFT_UNIT_POINT_DATA(byte[] FRAME_REQUEST_SOFT_UNIT_POINT_DATA) {
        this.FRAME_REQUEST_SOFT_UNIT_POINT_DATA = FRAME_REQUEST_SOFT_UNIT_POINT_DATA;
        return this;
    }

    public byte[] getFRAME_OVER_CODE() {
        return FRAME_OVER_CODE;
    }

    public McMessage setFRAME_OVER_CODE(byte[] FRAME_OVER_CODE) {
        this.FRAME_OVER_CODE = FRAME_OVER_CODE;
        return this;
    }

    public byte[] getFRAME_RESP_DATA() {
        return FRAME_RESP_DATA;
    }

    public McMessage setFRAME_RESP_DATA(byte[] FRAME_RESP_DATA) {
        this.FRAME_RESP_DATA = FRAME_RESP_DATA;
        return this;
    }

    public byte[] getFRAME_ERROR_DATA() {
        return FRAME_ERROR_DATA;
    }

    public McMessage setFRAME_ERROR_DATA(byte[] FRAME_ERROR_DATA) {
        this.FRAME_ERROR_DATA = FRAME_ERROR_DATA;
        return this;
    }


    public McMessage(){

    }

    public McMessage(byte[] FRAME_HEADER, byte[] FRAME_ADDRESS_NETWORK_NO, byte[] FRAME_ADDRESS_CONTROLLER_NO, byte[] FRAME_ADDRESS_DEST_MODULE_NO, byte[] FRAME_ADDRESS_DEST_MODULE_STATION, byte[] FRAME_WATCH_TIMER, byte[] FRAME_REQUEST_COMMAND, byte[] FRAME_REQUEST_COMMAND_SON, byte[] FRAME_REQUEST_START_SOFT_ADDRESS, byte[] FRAME_REQUEST_SOFT_UNIT_CODE, byte[] FRAME_REQUEST_SOFT_UNIT_POINT, byte[] FRAME_REQUEST_SOFT_UNIT_POINT_DATA, byte[] FRAME_OVER_CODE, byte[] FRAME_RESP_DATA, byte[] FRAME_ERROR_DATA) {
        this.FRAME_HEADER = FRAME_HEADER;
        this.FRAME_ADDRESS_NETWORK_NO = FRAME_ADDRESS_NETWORK_NO;
        this.FRAME_ADDRESS_CONTROLLER_NO = FRAME_ADDRESS_CONTROLLER_NO;
        this.FRAME_ADDRESS_DEST_MODULE_NO = FRAME_ADDRESS_DEST_MODULE_NO;
        this.FRAME_ADDRESS_DEST_MODULE_STATION = FRAME_ADDRESS_DEST_MODULE_STATION;
        this.FRAME_WATCH_TIMER = FRAME_WATCH_TIMER;
        this.FRAME_REQUEST_COMMAND = FRAME_REQUEST_COMMAND;
        this.FRAME_REQUEST_COMMAND_SON = FRAME_REQUEST_COMMAND_SON;
        this.FRAME_REQUEST_START_SOFT_ADDRESS = FRAME_REQUEST_START_SOFT_ADDRESS;
        this.FRAME_REQUEST_SOFT_UNIT_CODE = FRAME_REQUEST_SOFT_UNIT_CODE;
        this.FRAME_REQUEST_SOFT_UNIT_POINT = FRAME_REQUEST_SOFT_UNIT_POINT;
        this.FRAME_REQUEST_SOFT_UNIT_POINT_DATA = FRAME_REQUEST_SOFT_UNIT_POINT_DATA;
        this.FRAME_OVER_CODE = FRAME_OVER_CODE;
        this.FRAME_RESP_DATA = FRAME_RESP_DATA;
        this.FRAME_ERROR_DATA = FRAME_ERROR_DATA;
        countDataLength();
    }

    @Override
    public byte[] toByteArray() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            baos.write(FRAME_HEADER);
            baos.write(FRAME_ADDRESS_NETWORK_NO);
            baos.write(FRAME_ADDRESS_CONTROLLER_NO);
            baos.write(FRAME_ADDRESS_DEST_MODULE_NO);
            baos.write(FRAME_ADDRESS_DEST_MODULE_STATION);
            baos.write(FRAME_REQUEST_DATA_LENGTH);
            baos.write(FRAME_WATCH_TIMER);
            baos.write(FRAME_REQUEST_COMMAND);
            if(FRAME_REQUEST_COMMAND_SON!=null){
                baos.write(FRAME_REQUEST_COMMAND_SON);
            }
            baos.write(FRAME_REQUEST_START_SOFT_ADDRESS);
            baos.write(FRAME_REQUEST_SOFT_UNIT_CODE);
            baos.write(FRAME_REQUEST_SOFT_UNIT_POINT);
            if(FRAME_REQUEST_SOFT_UNIT_POINT_DATA!=null){
                baos.write(FRAME_REQUEST_SOFT_UNIT_POINT_DATA);
            }
            return baos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 计算数据长
     */
    public void countDataLength() {
        if(FRAME_REQUEST_SOFT_UNIT_POINT_DATA==null){
            this.setFRAME_REQUEST_DATA_LENGTH(Mc.FRAME_DATA_LENGTH_3E_READ);
        }else{
            this.setFRAME_REQUEST_DATA_LENGTH(DataUtils.byteResolve(Mc.FRAME_DATA_LENGTH_3E_NO_DATA+FRAME_REQUEST_SOFT_UNIT_POINT_DATA.length,2));
        }
    }
}
