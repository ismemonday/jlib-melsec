package org.mgd.data.request;
import org.mgd.data.response.McResponse;
import org.mgd.data.enums.RequestCommandEnum;
import org.mgd.data.enums.WordLengthEnum;
import org.mgd.data.response.McWordResponse;
import org.mgd.utils.DataUtils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * 字单位的操作
 * @author mgd [maoguidong@standard-robots.com]
 * @data 2022/7/12 下午2:39
 */
final public class McWordRequest extends McRequest {
    private WordLengthEnum wordLength=WordLengthEnum.WORD_SHORT;

     McWordRequest(McResponse mcResponse, int startAddress, int timeOut, TimeUnit time, RequestCommandEnum batchReadByWord, int quantity,WordLengthEnum wordLengthEnum,byte[] data) {
        super(mcResponse, startAddress, timeOut, time,batchReadByWord,quantity,DataUtils.byteResolve(quantity*wordLengthEnum.getLength()/2,2),data);
        this.wordLength= wordLengthEnum;
    }


    /**
     * 字单位批量读取-short读
     * @param startAddress
     * @param quantity
     * @param timeOut
     * @param time
     * @return
     */
    public static McRequest<Short> shortRead(int startAddress,int quantity,int timeOut, TimeUnit time) {
        return new McWordRequest(new McWordResponse<Short>(), startAddress, timeOut, time, RequestCommandEnum.BATCH_READ_BY_WORD, quantity,WordLengthEnum.WORD_SHORT,null);
    }

    /**
     * 字单位批量读取-short读
     * @param startAddress
     * @param quantity
     * @return
     */
    public static McRequest<Short> shortRead(int startAddress,int quantity) {
        return new McWordRequest(new McWordResponse<Short>(), startAddress, 3, TimeUnit.SECONDS, RequestCommandEnum.BATCH_READ_BY_WORD, quantity,WordLengthEnum.WORD_SHORT,null);
    }

    /**
     * 字单位批量读取-short写
     * @param startAddress
     * @param data
     * @param timeOut
     * @param time
     * @return
     */
    public static McRequest<Short> shortWrite(int startAddress,short[] data,int timeOut, TimeUnit time) {
        ByteArrayOutputStream dataArr = new ByteArrayOutputStream();
        for (short b : data) {
            byte[] bytesa = DataUtils.byteResolve(b, WordLengthEnum.WORD_SHORT.getLength());
            try {
                dataArr.write(bytesa);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return new McWordRequest(new McWordResponse<Short>(), startAddress, timeOut, time, RequestCommandEnum.BATCH_WRITE_BY_WORD, data.length,WordLengthEnum.WORD_SHORT,dataArr.toByteArray());
    }

    /**
     * 字单位批量读取-short写
     * @param startAddress
     * @param data
     * @return
     */
    public static McRequest<Short> shortWrite(int startAddress,short[] data) {
        ByteArrayOutputStream dataArr = new ByteArrayOutputStream();
        for (short b : data) {
            byte[] bytesa = DataUtils.byteResolve(b, WordLengthEnum.WORD_SHORT.getLength());
            try {
                dataArr.write(bytesa);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return new McWordRequest(new McWordResponse<Short>(), startAddress, 3, TimeUnit.SECONDS, RequestCommandEnum.BATCH_WRITE_BY_WORD, data.length,WordLengthEnum.WORD_SHORT,dataArr.toByteArray());
    }

    /**
     * 字单位批量读取-int读
     * @param startAddress
     * @param quantity
     * @param timeOut
     * @param time
     * @return
     */
    public static McRequest<Integer> intRead(int startAddress,int quantity,int timeOut, TimeUnit time) {
        return new McWordRequest(new McWordResponse<Integer>(), startAddress, timeOut, time, RequestCommandEnum.BATCH_READ_BY_WORD, quantity,WordLengthEnum.WORD_INT,null);
    }

    /**
     * 字单位批量读取-int读
     * @param startAddress
     * @param quantity
     * @return
     */
    public static McRequest<Integer> intRead(int startAddress,int quantity) {
        return new McWordRequest(new McWordResponse<Integer>(), startAddress, 3, TimeUnit.SECONDS, RequestCommandEnum.BATCH_READ_BY_WORD, quantity,WordLengthEnum.WORD_INT,null);
    }

    /**
     * 字单位批量读取-int写
     * @param startAddress
     * @param data
     * @param timeOut
     * @param time
     * @return
     */
    public static McRequest<Integer> intWrite(int startAddress,int[] data,int timeOut, TimeUnit time) {
        ByteArrayOutputStream dataArr = new ByteArrayOutputStream();
        for (int b : data) {
            byte[] bytesa = DataUtils.byteResolve(b, WordLengthEnum.WORD_INT.getLength());
            try {
                dataArr.write(bytesa);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return new McWordRequest(new McWordResponse<Integer>(), startAddress, timeOut, time, RequestCommandEnum.BATCH_WRITE_BY_WORD, data.length,WordLengthEnum.WORD_INT,dataArr.toByteArray());
    }

    /**
     * 字单位批量读取-int写
     * @param startAddress
     * @param data
     * @return
     */
    public static McRequest<Integer> intWrite(int startAddress,int[] data) {
        ByteArrayOutputStream dataArr = new ByteArrayOutputStream();
        for (int b : data) {
            byte[] bytesa = DataUtils.byteResolve(b, WordLengthEnum.WORD_INT.getLength());
            try {
                dataArr.write(bytesa);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return new McWordRequest(new McWordResponse<Integer>(), startAddress, 3, TimeUnit.SECONDS, RequestCommandEnum.BATCH_WRITE_BY_WORD, data.length,WordLengthEnum.WORD_INT,dataArr.toByteArray());
    }

    /**
     * 字单位批量读取-float读
     * @param startAddress
     * @param quantity
     * @param timeOut
     * @param time
     * @return
     */
    public static McRequest<Float> floatRead(int startAddress,int quantity,int timeOut, TimeUnit time) {
        return new McWordRequest(new McWordResponse<Float>(), startAddress, timeOut, time, RequestCommandEnum.BATCH_READ_BY_WORD, quantity,WordLengthEnum.WORD_FLOAT,null);
    }

    /**
     * 字单位批量读取-float读
     * @param startAddress
     * @param quantity
     * @return
     */
    public static McRequest<Float> floatRead(int startAddress,int quantity) {
        return new McWordRequest(new McWordResponse<Float>(), startAddress, 3, TimeUnit.SECONDS, RequestCommandEnum.BATCH_READ_BY_WORD, quantity,WordLengthEnum.WORD_FLOAT,null);
    }

    /**
     * 字单位批量读取-float写
     * @param startAddress
     * @param data
     * @param timeOut
     * @param time
     * @return
     */
    public static McRequest<Float> floatWrite(int startAddress,float[] data,int timeOut, TimeUnit time) {
        ByteArrayOutputStream dataArr = new ByteArrayOutputStream();
        for (float b : data) {
            byte[] bytesa = DataUtils.byteResolve((long) b, WordLengthEnum.WORD_FLOAT.getLength());
            try {
                dataArr.write(bytesa);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return new McWordRequest(new McWordResponse<Float>(), startAddress, timeOut, time, RequestCommandEnum.BATCH_WRITE_BY_WORD, data.length,WordLengthEnum.WORD_FLOAT,dataArr.toByteArray());
    }

    /**
     * 字单位批量读取-float写
     * @param startAddress
     * @param data
     * @return
     */
    public static McRequest<Float> floatWrite(int startAddress,float[] data) {
        ByteArrayOutputStream dataArr = new ByteArrayOutputStream();
        for (float b : data) {
            byte[] bytesa = DataUtils.byteResolve((long) b, WordLengthEnum.WORD_FLOAT.getLength());
            try {
                dataArr.write(bytesa);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return new McWordRequest(new McWordResponse<Float>(), startAddress, 3, TimeUnit.SECONDS, RequestCommandEnum.BATCH_WRITE_BY_WORD, data.length,WordLengthEnum.WORD_FLOAT,dataArr.toByteArray());
    }

    /**
     * 字单位批量读取-long读
     * @param startAddress
     * @param quantity
     * @param timeOut
     * @param time
     * @return
     */
    public static McRequest<Long> longRead(int startAddress,int quantity,int timeOut, TimeUnit time) {
        return new McWordRequest(new McWordResponse<Long>(), startAddress, timeOut, time, RequestCommandEnum.BATCH_READ_BY_WORD, quantity,WordLengthEnum.WORD_LONG,null);
    }

    /**
     * 字单位批量读取-long读
     * @param startAddress
     * @param quantity
     * @return
     */
    public static McRequest<Long> longRead(int startAddress,int quantity) {
        return new McWordRequest(new McWordResponse<Long>(), startAddress, 3, TimeUnit.SECONDS, RequestCommandEnum.BATCH_READ_BY_WORD, quantity,WordLengthEnum.WORD_LONG,null);
    }

    /**
     * 字单位批量读取-long写
     * @param startAddress
     * @param data
     * @param timeOut
     * @param time
     * @return
     */
    public static McRequest<Long> longWrite(int startAddress,long[] data,int timeOut, TimeUnit time) {
        ByteArrayOutputStream dataArr = new ByteArrayOutputStream();
        for (long b : data) {
            byte[] bytesa = DataUtils.byteResolve(b, WordLengthEnum.WORD_LONG.getLength());
            try {
                dataArr.write(bytesa);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return new McWordRequest(new McWordResponse<Long>(), startAddress, timeOut, time, RequestCommandEnum.BATCH_WRITE_BY_WORD, data.length,WordLengthEnum.WORD_LONG,dataArr.toByteArray());
    }

    /**
     * 字单位批量读取-long写
     * @param startAddress
     * @param data
     * @return
     */
    public static McRequest<Long> longWrite(int startAddress,long[] data) {
        ByteArrayOutputStream dataArr = new ByteArrayOutputStream();
        for (long b : data) {
            byte[] bytesa = DataUtils.byteResolve(b, WordLengthEnum.WORD_LONG.getLength());
            try {
                dataArr.write(bytesa);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return new McWordRequest(new McWordResponse<Long>(), startAddress, 3, TimeUnit.SECONDS, RequestCommandEnum.BATCH_WRITE_BY_WORD, data.length,WordLengthEnum.WORD_LONG,dataArr.toByteArray());
    }

    @Override
    public WordLengthEnum getWordLength() {
        return wordLength;
    }

}
