package org.mgd.master;
import org.mgd.data.DataFrame;
import org.mgd.data.McConnectParams;

/**
 * @author mgd [maoguidong@standard-robots.com]
 * @data 2022/6/29 上午11:29
 */
final public class McMasterFactory {

    public static McMaster createMcMasterTcp(McConnectParams params, DataFrame frame) {
        return new McMasterTcp(params,frame);
    }

    public static McMaster createMcMasterTcp(McConnectParams params) {
        return new McMasterTcp(params,DataFrame.FRAME_3E);
    }


}
