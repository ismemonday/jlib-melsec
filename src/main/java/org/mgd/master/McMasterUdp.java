package org.mgd.master;

import org.mgd.data.enums.DataFrame;
import org.mgd.data.McConnectParams;
import org.mgd.data.request.McRequest;
import org.mgd.data.response.McResponse;

import java.io.IOException;


/**
 * @author mgd [maoguidong@standard-robots.com]
 * @data 2022/6/29 上午11:38
 */
public class McMasterUdp extends McMaster{


    protected McMasterUdp(McConnectParams params, DataFrame frame) {
        super(frame);
    }

    @Override
    public McResponse processRequest(McRequest mcRequest) {
        return null;
    }

    @Override
    protected McResponse doResponseImpl(McRequest mcRequest) {
        return null;
    }

    @Override
    protected void doRequestImpl(McRequest mcRequest) throws IOException {

    }

    @Override
    protected void doConnect() throws IOException {

    }
}
