import javax.swing.*;
import java.awt.*;

/**
 * @author Gergö Dusza
 * @version 1.0
 * @since 2020-März-09
 */

public class LogInGUI extends JFrame {

    private JPanel allContentPanel;
    private JPanel headPannel;
    private JPanel dataPanel;
    private JPanel bottomButtonPanel;
    private JPanel buttonPanel;

    private JButton exit;
    private JButton logIn;

    private JPanel nameIpPanel;
    private JPanel nameIpContentPanel;

    private JLabel headLogIn;
    private JLabel name;
    private JTextField nameFeld;
    private JLabel ip;
    private JLabel ipFeld;


    public LogInGUI() throws HeadlessException {

        super("Log-In");

        allContentPanel = new JPanel();
        headPannel = new JPanel();
        dataPanel = new JPanel();
        bottomButtonPanel= new JPanel();
        buttonPanel= new JPanel();

        exit = new JButton("Brexit");
        exit.addActionListener(new ExitRequestListener(exit));
        nameFeld = new JTextField();
        logIn = new JButton("Log-In");
        logIn.setEnabled(false);
        nameFeld.addKeyListener(new TextFieldValidListener(logIn,nameFeld));
        logIn.addActionListener(new LoginRequestListener(logIn, nameFeld, this));

        nameIpPanel = new JPanel();
        nameIpContentPanel = new JPanel();
        name = new JLabel("Name: ");

        ip = new JLabel("IP: ");
        ipFeld = new JLabel(new MyIP().toString());
        headLogIn = new JLabel("Log-In:");

        getContentPane().add(allContentPanel);
        allContentPanel.setLayout(new BorderLayout());
        allContentPanel.add(headPannel, BorderLayout.NORTH);
        allContentPanel.add(dataPanel, BorderLayout.CENTER);
        allContentPanel.add(bottomButtonPanel, BorderLayout.SOUTH);

        headPannel.setLayout(new BorderLayout());
        headPannel.add(headLogIn, BorderLayout.WEST);
        bottomButtonPanel.setLayout(new BorderLayout());
        bottomButtonPanel.add(buttonPanel, BorderLayout.EAST);
        buttonPanel.setLayout(new BorderLayout());
        buttonPanel.add(exit, BorderLayout.WEST);
        buttonPanel.add(logIn, BorderLayout.EAST);

        dataPanel.setLayout(new GridLayout(1,2));
        dataPanel.add(nameIpPanel);
        dataPanel.add(nameIpContentPanel);

        nameIpPanel.setLayout(new GridLayout(2,1));
        nameIpPanel.add(name);
        nameIpPanel.add(ip);

        dataPanel.add(nameIpContentPanel);
        nameIpContentPanel.setLayout(new GridLayout(2,1));
        nameIpContentPanel.add(nameFeld);
        nameIpContentPanel.add(ipFeld);

        setSize(400,220);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public String getName() {
        return name.getText();
    }
}
