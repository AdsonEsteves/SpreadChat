/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.window;


import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import ui.MainPanel;
import ui.utils.ColorController;

/**
 *
 * @author lite
 */
public class OutsidePanel extends JPanel {

    public OutsidePanel() {
        setLayout(new BorderLayout());
        add(new MainPanel(), BorderLayout.CENTER);
        add(new BorderPanel(), BorderLayout.PAGE_START);
        setBorder(new LineBorder(ColorController.FUNDO_ESCURO, 5));
    }
}
