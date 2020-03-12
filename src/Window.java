import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.font.TextAttribute;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Map;
import java.util.Scanner;
import java.util.Vector;

/**
 * @author Felix Mann
 * @version 1.0
 * @since 2020-März-05
 */

public class Window {

    public JFrame frame;

    public JPanel mainPanel;
    public JSplitPane splitPane;

    public JPanel leftPanel;
    public JLabel leftTitelLabel;
    public JPanel leftContentPanel;

    public JButton chatbutton;
    public JButton chatbutton2;

    public JPanel textPanel, sendPanel;
    public JScrollPane scrollPane;
    public JTextField textFieldInput;
    public Border border;
    public JButton sendButton;
    public JTextArea textOutArea;
    public JLabel yourName;
    private static String name;
    private static String ip;

    public Vector<User> users;
    public LogInGUI logInGUI;


    public Window() {
        frame = new JFrame();
        /*
        users = new Vector<>();

        users.add(user);

         */

        mainPanel = new JPanel();

        leftPanel = new JPanel();
        leftTitelLabel = new JLabel();
        leftContentPanel = new JPanel();

        chatbutton = new JButton("chat 1");
        chatbutton2 = new JButton("chat 2");

        textPanel = new JPanel();
        textFieldInput = new JTextField(30);
        border = BorderFactory.createLineBorder(Color.BLACK, 2);
        textFieldInput.setBorder(border);
        sendButton = new JButton("Send");
        sendPanel = new JPanel();
        textOutArea = new JTextArea(20, 20);
        textOutArea.setEditable(false);
        scrollPane = new JScrollPane(textOutArea);

        yourName = new JLabel();
        //yourName.setText(user.getName());

        //sichert File bei Chat wechsel
        chatbutton2.addActionListener(e -> {
            if(e.getSource() == chatbutton2){

            }
        });

        chatbutton.addActionListener(e -> {
            if(e.getSource() == chatbutton){

            }
        });

        //sichert File beim Schliessen den Fensters
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                generateFileChat1();
            }
        });

        splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftPanel, textPanel);

        makeLeftPanel();
        makeMainPanel();
        makeTextPanel();
        makeLeftContentPanel();

        frame.getContentPane().add(mainPanel);
        frame.setResizable(false);
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        logInGUI = new LogInGUI(frame);
        frame.setTitle(name);
        yourName.setText(name);
    }


    private void makeTextPanel() {
        textPanel.setLayout(new BorderLayout());
        textPanel.add(sendPanel, BorderLayout.SOUTH);
        textPanel.add(scrollPane, BorderLayout.NORTH);

        sendPanel.setLayout(new BorderLayout());
        sendPanel.add(textFieldInput, BorderLayout.CENTER);
        sendPanel.add(sendButton, BorderLayout.EAST);
    }

    private void makeLeftPanel() {
        leftPanel.setLayout(new BorderLayout());

        leftTitelLabel.setText("ChannelPanel");

        Font font = leftTitelLabel.getFont();
        Map<TextAttribute, Integer> attributes = (Map<TextAttribute, Integer>) font.getAttributes();
        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        leftTitelLabel.setFont(font.deriveFont(attributes));

        leftPanel.add(leftTitelLabel, BorderLayout.NORTH);
        leftPanel.add(leftContentPanel, BorderLayout.CENTER);
    }

    private void makeLeftContentPanel(){
        leftContentPanel.setLayout(new GridLayout(4,1));

        leftContentPanel.add(chatbutton);
        leftContentPanel.add(chatbutton2);
        leftContentPanel.add(yourName);

    }


    private void makeMainPanel() {
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(splitPane, BorderLayout.CENTER);
    }

    private void sendText(User user, String text) {

    }

    public void addUser(User user){
        users.add(user);
    }

    public void changeUserName(User user, String newName){
        user.setName(newName);
    }

    public User getUser(String name){
        return null;
    }

    public void generateFileChat2() {
        try (PrintWriter out = new PrintWriter("text"+chatbutton2.getText()+".txt")) {
            out.print(textOutArea.getText());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void generateFileChat1() {
        try (PrintWriter out1 = new PrintWriter("text"+chatbutton.getText()+".txt")) {
            out1.print(textOutArea.getText());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void setName(String name) {
        Window.name = name;
    }

    public static void setIp(String ip) {
        Window.ip = ip;
    }

    public String getName() {
        return name;
    }

    public String getIp() {
        return ip;
    }
}
