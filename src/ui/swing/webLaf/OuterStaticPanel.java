/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.swing.webLaf;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import ui.utils.ColorController;

/**
 *
 * @author lite
 */
public class OuterStaticPanel extends JPanel
{

    public OuterStaticPanel(JPanel jPanel, JPanel border){
        setLayout(new BorderLayout());
        add(jPanel, BorderLayout.CENTER);
        add(border, BorderLayout.PAGE_START);
        setBorder(new CompoundBorder(new LineBorder(ColorController.COR_PRINCIPAL, 1),new LineBorder(ColorController.FUNDO_ESCURO, 5)));
    }
    
}
