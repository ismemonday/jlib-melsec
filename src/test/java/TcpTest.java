import org.mgd.data.McConnectParams;
import org.mgd.data.response.McResponse;
import org.mgd.data.request.McWordRequest;
import org.mgd.data.response.McWordResponse;
import org.mgd.master.McMaster;
import org.mgd.master.McMasterFactory;
import org.mgd.utils.DataUtils;

import java.io.IOException;

/**
 * @author mgd [maoguidong@standard-robots.com]
 * @data 2022/6/29 上午11:36
 */
public class TcpTest {
    public static void main(String[] args) throws IOException {
        McMaster mcMaster = McMasterFactory.createMcMasterTcp(McConnectParams.build("10.10.68.72", 5002,true));
        //字单位short批量操作
        McResponse<Short> shortMcResponse1 = mcMaster.processRequest(McWordRequest.shortWrite(7000, new short[]{4, 5,6}));
        System.out.println("写入结果:"+shortMcResponse1.getCode());
        McResponse<Short> shortMcResponse = mcMaster.processRequest(McWordRequest.shortRead(7000, 3));
        System.out.println("读取结果" + DataUtils.arrayToStr(shortMcResponse.getData()));
        //字单位int批量操作
        McResponse response12 = mcMaster.processRequest(McWordRequest.intWrite(7000, new int[]{6, 7}));
        System.out.println("写入结果:"+response12.getCode());
        McResponse<Integer> integerMcResponse = mcMaster.processRequest(McWordRequest.intRead(7000, 3));
        System.out.println("读取结果" + DataUtils.arrayToStr(integerMcResponse.getData()));
        //字单位float批量操作
        McResponse response13 = mcMaster.processRequest(McWordRequest.floatWrite(7000, new float[]{8, 9}));
        System.out.println("写入结果:"+response13.getCode());
        McResponse<Float> floatMcResponse = mcMaster.processRequest(McWordRequest.floatRead(7000, 3));
        System.out.println("读取结果" + DataUtils.arrayToStr(floatMcResponse.getData()));
        //字单位long批量操作
        McResponse response14 = mcMaster.processRequest(McWordRequest.longWrite(7000, new long[]{10,11}));
        System.out.println("写入结果:" + response14.getCode());
       McWordResponse<Long> longMcResponse = (McWordResponse<Long>) mcMaster.processRequest(McWordRequest.longRead(7000, 3));
        System.out.println("读取结果" + DataUtils.arrayToStr(longMcResponse.getData()));
    }
}
