import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Gergö Dusza
 * @version 1.0
 * @since 2020-März-09
 */

public class  ExitRequestListener implements ActionListener {

    JButton exit2;

    public ExitRequestListener(JButton exit) {
        this.exit2 = exit;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == exit2) {
            System.exit(0);
        }
    }
}
