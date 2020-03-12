import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * @author Gergö Dusza
 * @version 1.0
 * @since 2020-März-09
 */

public class LoginRequestListener implements ActionListener {

    private JButton login;
    private JTextField field;
    private JFrame parent;

    public LoginRequestListener(JButton login, JTextField field, JFrame parent) {
        this.login = login;
        this.field = field;
        this.parent = parent;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (field.getText().length()>40){
            new LogInPopUp(parent);
        } else if (e.getSource() == login){
            new Window();
        }
    }
}
