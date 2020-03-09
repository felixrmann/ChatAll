import java.io.IOException;
import java.net.InetAddress;

/**
 * @author Gergö Dusza
 * @version 1.0
 * @since 2020-März-09
 */

public class PrintIPs {

    public static void main(String args[]) throws IOException {

        String ipSub="172.16.9";
        int timeout=1500;

        for (int i=1;i<255;i++){
            String hostIP=ipSub + "." + i;

            if (InetAddress.getByName(hostIP).isReachable(timeout)){
                System.out.println(hostIP);
            }
        }
    }
}
