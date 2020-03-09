import javax.swing.*;
import java.awt.*;

/**
 * @author Gergö Dusza
 * @version 1.0
 * @since 2020-März-09
 */

public class LogInPopUp extends JDialog {

    private JPanel all;
    private JPanel bottom;
    private JPanel bottomCorner;

    private JLabel error;
    private JButton ok;

    public LogInPopUp(JFrame parent) {
        all = new JPanel();
        all.setLayout(new BorderLayout());

        bottom = new JPanel();
        bottom.setLayout(new BorderLayout());

        bottomCorner = new JPanel();
        bottomCorner.setLayout(new BorderLayout());

        error = new JLabel("Du hurensohn dein Name darf maximal 40 Buchstaben lang sein, Missgeburt");
        ok = new JButton("OK");
        ok.addActionListener(e -> System.exit(0));

        getContentPane().add(all);
        all.add(error, BorderLayout.CENTER);
        all.add(bottom,BorderLayout.SOUTH);
        bottom.add(bottomCorner, BorderLayout.EAST);
        bottom.add(ok);

        pack();
        setVisible(true);
    }
}
