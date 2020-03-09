import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * @author Gergö Dusza
 * @version 1.0
 * @since 2020-März-09
 */

public class TextFieldValidListener implements KeyListener{

    private JButton button;
    private JTextField inhalt;


    public TextFieldValidListener(JButton button, JTextField inhalt) {
        this.button = button;
        this.inhalt = inhalt;
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        button.setEnabled(true);


    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}
