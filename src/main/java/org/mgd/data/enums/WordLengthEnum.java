package org.mgd.data.enums;

/**
 * @author mgd [maoguidong@standard-robots.com]
 * @data 2022/7/12 下午3:24
 */
public enum WordLengthEnum {
    WORD_SHORT(1,2,"字单位short"),
    WORD_INT(2,4,"字单位short"),
    WORD_FLOAT(3,4,"字单位short"),
    WORD_LONG(4,8,"字单位short");
    private final int code;
    private final int length;
    private final String des;

    public int getLength() {
        return length;
    }

    public String getDes() {
        return des;
    }

    WordLengthEnum(int code,int length, String des){
        this.code=code;
        this.length=length;
        this.des=des;
    }

    public static WordLengthEnum codeOf(int code){
        for (WordLengthEnum anEnum : WordLengthEnum.values()) {
            if (anEnum.code==code) {
                return anEnum;
            }
        }
        return null;
    }
}
