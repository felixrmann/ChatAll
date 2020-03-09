import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.font.TextAttribute;
import java.util.Map;
import java.util.Vector;

/**
 * @author Felix Mann
 * @version 1.0
 * @since 2020-März-05
 */

public class Window extends JFrame {

    private JPanel mainPanel;
    private JSplitPane splitPane;

    private JPanel leftPanel;
    private JLabel leftTitelLabel;
    private JPanel leftContentPanel;

    private JButton chatbutton;
    private JButton chatbutton2;

    private JPanel textPanel, sendPanel;
    private JScrollPane scrollPane;
    private JTextArea textAreaInput;
    private Border border;
    private JButton sendButton;
    private JTextArea textOutArea;

    private Vector<User> users;


    public Window(User user) {
        users = new Vector<>();

        users.add(user);

        mainPanel = new JPanel();

        leftPanel = new JPanel();
        leftTitelLabel = new JLabel();
        leftContentPanel = new JPanel();

        chatbutton = new JButton();
        chatbutton2 = new JButton();

        textPanel = new JPanel();
        textAreaInput = new JTextArea(5, 30);
        border = BorderFactory.createLineBorder(Color.BLACK, 2);
        textAreaInput.setBorder(border);
        sendButton = new JButton("Send");
        sendPanel = new JPanel();
        textOutArea = new JTextArea(20, 20);
        textOutArea.setEditable(false);
        scrollPane = new JScrollPane(textOutArea);


        textAreaInput.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    textOutArea.setText(textOutArea.getText() + textAreaInput.getText() + "\n");
                    textAreaInput.setText(null);
                }
            }
        });

        sendButton.addActionListener(e -> {
            textOutArea.setText(textOutArea.getText() + textAreaInput.getText()+ "\n");
            textAreaInput.setText(null);
            textAreaInput.grabFocus();
        });

        splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftPanel, textPanel);

        makeLeftPanel();
        makeMainPanel();
        makeTextPanel();
        makeLeftContentPanel();

        getContentPane().add(mainPanel);
        setResizable(false);
        setTitle("Messanger");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void makeTextPanel() {
        textPanel.setLayout(new BorderLayout());
        textPanel.add(sendPanel, BorderLayout.SOUTH);
        textPanel.add(scrollPane, BorderLayout.NORTH);

        sendPanel.setLayout(new BorderLayout());
        sendPanel.add(textAreaInput, BorderLayout.CENTER);
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
        leftContentPanel.setLayout(new BoxLayout(leftContentPanel, BoxLayout.Y_AXIS));

        leftContentPanel.add(chatbutton);
        leftContentPanel.add(chatbutton2);

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
        user.getName();
        user.setName(newName);
    }

    public User getUser(String name){
        return null;
    }
}
