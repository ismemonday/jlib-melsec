import org.mgd.data.McConnectParams;
import org.mgd.data.McRequest;
import org.mgd.data.McResponse;
import org.mgd.master.McMaster;
import org.mgd.master.McMasterFactory;

import java.io.IOException;

/**
 * @author mgd [maoguidong@standard-robots.com]
 * @data 2022/6/29 上午11:36
 */
public class TcpTest {
    public static void main(String[] args) throws IOException {
        McMaster mcMaster = McMasterFactory.createMcMasterTcp(McConnectParams.build("10.10.68.72", 5002));
        McResponse response=mcMaster.processRequest(McRequest.build());
    }
}
