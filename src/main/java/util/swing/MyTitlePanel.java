package util.swing;

import java.awt.Color;
import java.awt.Dimension;
import javaswingdev.card.Card;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author haris
 */
public class MyTitlePanel extends Card{
    public MyTitlePanel(String title)
    {
        removeAllComponent();
        setBackground(new Color(242, 242, 242));
        setColor1(new Color(242,242,242));      
        setLayout(new MigLayout());
        add(new MyTitle(title) , "spanx,growx , al center");
        setPreferredSize(new Dimension(1,40));
    }
}
