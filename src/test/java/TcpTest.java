import org.mgd.data.McConnectParams;
import org.mgd.data.McRequest;
import org.mgd.data.McResponse;
import org.mgd.master.McMaster;
import org.mgd.master.McMasterFactory;
import org.mgd.utils.DataUtils;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @author mgd [maoguidong@standard-robots.com]
 * @data 2022/6/29 上午11:36
 */
public class TcpTest {
    public static void main(String[] args) throws IOException {
        McMaster mcMaster = McMasterFactory.createMcMasterTcp(McConnectParams.build("10.10.68.72", 5002,true));
        //字单位批量写入
        McResponse response=mcMaster.processRequest(McRequest.writeWord(7000,10,TimeUnit.SECONDS,new byte[]{6,7}));
        System.out.println("写入结果:"+response.getRespResult());
        //字单位批量读取
        McResponse resp2=mcMaster.processRequest(McRequest.readWord(7000,3, TimeUnit.SECONDS,2));
        System.out.println("读取结果:"+resp2.getRespResult());
        byte[] resultData = resp2.getResultData();
        System.out.print("读取的值是:"+ DataUtils.byteToStr(resultData));
    }
}
