/**
 * @author Felix Mann
 * @version 1.0
 * @since 2020-März-09
 */

import java.net.*;
import java.io.*;

public class Server {
    public static void main (String []args) {
        try {
            ServerSocket ss = new ServerSocket(1999);
            Socket s = ss.accept();
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
            DataInputStream dis = new DataInputStream(s.getInputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            while(!br.readLine().equals("quit")) {
                System.out.println("She says: " + dis.readUTF());
                dos.writeUTF(br.readLine());
            }
            ss.close();
        } catch (Exception ie) {
            ie.printStackTrace();
        }
    }
}

