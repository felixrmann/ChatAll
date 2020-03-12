/**
 * @author Gergö Dusza
 * @version 1.0
 * @since 2020-März-09
 */

import java.net.InetAddress;
import java.net.UnknownHostException;

class MyIP {
    public String getIp() {
        try {
            InetAddress myIP = InetAddress.getLocalHost();
            return myIP.getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return null;
    }
}

