import org.mgd.data.McMessage;

import java.io.IOException;
import java.net.Socket;
/**
 * @author mgd [maoguidong@standard-robots.com]
 * @data 2022/7/5 下午5:41
 */

public class McTest {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("10.10.68.72", 5002);
        McMessage mcMessage = new McMessage(){};
        mcMessage.setFRAME_HEADER(new byte[]{0x50,00})
                .setFRAME_ADDRESS_NETWORK_NO(new byte[]{00})
                .setFRAME_ADDRESS_CONTROLLER_NO(new byte[]{(byte) 0XFF})
                .setFRAME_ADDRESS_DEST_MODULE_NO(new byte[]{(byte) 0xFF,0X03})
                .setFRAME_ADDRESS_DEST_MODULE_STATION(new byte[]{0x00})
                .setFRAME_REQUEST_DATA_LENGTH(new byte[]{0x10,00})
                .setFRAME_WATCH_TIMER(new byte[]{0x10,00})
                .setFRAME_REQUEST_COMMAND(new byte[]{0x01,0x14,00,00})
                .setFRAME_REQUEST_START_SOFT_ADDRESS(new byte[]{0x58,0x1B,00})
                .setFRAME_REQUEST_SOFT_UNIT_CODE(new byte[]{(byte) 0xA8})
                .setFRAME_REQUEST_SOFT_UNIT_POINT(new byte[]{0x02,00})
                .setFRAME_REQUEST_SOFT_UNIT_POINT_DATA(new byte[]{0x06,0X00,0X07,00});
        socket.getOutputStream().write(mcMessage.toByteArray());
        byte[] bytes = new byte[256];
        socket.getInputStream().read(bytes);
        System.out.println(new String(bytes));

    }
}
