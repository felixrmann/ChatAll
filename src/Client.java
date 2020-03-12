import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    private Window window;
    private PrintWriter out;
    private String name;
    private String serverAddress;


    private Client() {
        window = new Window();

        name = window.getName();
        serverAddress = window.getIp();

        window.textFieldInput.setEditable(false);
        window.textOutArea.setEditable(false);

        window.textFieldInput.addActionListener(e -> {
            out.println(window.textFieldInput.getText());
            window.textFieldInput.setText("");
        });
    }

    private void run() throws IOException {
        window.frame.setVisible(true);
        try {

            Socket socket = new Socket(serverAddress, 59001);
            Scanner in = new Scanner(socket.getInputStream());
            out = new PrintWriter(socket.getOutputStream(), true);

            while (in.hasNextLine()) {
                String line = in.nextLine();
                if (line.startsWith("SUBMITNAME")) {
                    out.println(name);
                } else if (line.startsWith("NAMEACCEPTED")) {
                    window.textFieldInput.setEditable(true);
                } else if (line.startsWith("MESSAGE")) {
                    window.textOutArea.append(line.substring(8) + "\n");
                }
            }
        } finally {
            window.frame.setVisible(false);
            window.frame.dispose();
        }
    }

    public static void main(String[] args) throws Exception {
        Client client = new Client();
        client.run();
    }


}