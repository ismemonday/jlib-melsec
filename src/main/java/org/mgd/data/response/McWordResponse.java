package org.mgd.data.response;

import org.mgd.data.McWord;
import org.mgd.data.enums.WordLengthEnum;
import org.mgd.exception.McException;
import org.mgd.utils.DataUtils;
import java.io.IOException;
import java.nio.ByteBuffer;

/**
 * @author mgd [maoguidong@standard-robots.com]
 * @data 2022/7/12 下午7:16
 */
final public class McWordResponse<T> extends McResponse implements McWord {
    private T[] data;

    @Override
    public T[] getData() {
        return data;
    }

    @Override
    public void wrapRespData(WordLengthEnum wordLength, int quantity) throws IOException {
        switch (wordLength){
            case WORD_FLOAT:
                respFlot(quantity);
                break;
            case WORD_INT:
                 respInt(quantity);
                 break;
            case WORD_LONG:
                 respLong(quantity);
                 break;
            case WORD_SHORT:
                 respShort(quantity);
                 break;
            default:
                throw new McException("wrapRespData error,cur wordLength not allow");
        }
    }


    @Override
    public void respFlot(int quantity) {
        byte[] bytes=DataUtils.byteResolveEvery(FRAME_RESP_DATA,WordLengthEnum.WORD_FLOAT.getLength());
        ByteBuffer buff = ByteBuffer.wrap(bytes);
        Float[] floats = new Float[quantity];
        for (int i = 0; i < floats.length; i++) {
            floats[i]=buff.getFloat();
        }
        data= (T[]) floats;
    }

    @Override
    public void respInt(int quantity) {
        byte[] bytes=DataUtils.byteResolveEvery(FRAME_RESP_DATA,WordLengthEnum.WORD_INT.getLength());
        ByteBuffer buff = ByteBuffer.wrap(bytes);
        Integer[] ints = new Integer[quantity];
        for (int i = 0; i < ints.length; i++) {
            ints[i]=buff.getInt();
        }
        data= (T[]) ints;
    }

    @Override
    public void respShort(int quantity) {
        byte[] bytes=DataUtils.byteResolveEvery(FRAME_RESP_DATA,WordLengthEnum.WORD_SHORT.getLength());
        ByteBuffer buff = ByteBuffer.wrap(bytes);
        Short[] shorts = new Short[quantity];
        for (int i = 0; i < shorts.length; i++) {
            shorts[i]=buff.getShort();
        }
        data= (T[]) shorts;
    }

    @Override
    public void respLong(int quantity){
        byte[] bytes=DataUtils.byteResolveEvery(FRAME_RESP_DATA,WordLengthEnum.WORD_LONG.getLength());
        ByteBuffer buff = ByteBuffer.wrap(bytes);
        Long[] longs = new Long[quantity];
        for (int i = 0; i < longs.length; i++) {
            longs[i]=buff.getLong();
        }
        data= (T[]) longs;
    }
}
