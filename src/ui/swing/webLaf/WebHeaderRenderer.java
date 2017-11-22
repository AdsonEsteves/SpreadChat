/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.swing.webLaf;


import com.alee.laf.table.renderers.WebTableHeaderCellRenderer;
import java.awt.Color;
import java.awt.Component;
import java.awt.Insets;
import javax.swing.JTable;
import ui.utils.ColorController;

/**
 *
 * @author Adson Estevesa
 */
public class WebHeaderRenderer extends WebTableHeaderCellRenderer
{
    public WebHeaderRenderer ()
    {
        super();
        setDrawShade(false);
        setBackground(Color.red);
        setForeground(ColorController.COR_LETRA);
        setMargin(new Insets(0,0,0,0));
        setBorder(null);
    }

    @Override
    public Component getTableCellRendererComponent ( final JTable table, final Object value, final boolean isSelected,
                                                     final boolean hasFocus, final int row, final int column )
    {
        super.getTableCellRendererComponent ( table, value, isSelected, hasFocus, row, column );
        setText ( ( value == null ) ? "" : ( " " + value.toString () ) );
        return this;
    }
}
