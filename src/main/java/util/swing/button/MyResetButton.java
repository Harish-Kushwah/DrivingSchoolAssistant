
package util.swing.button;

import java.awt.Color;
import javaswingdev.system.SystemColor;

/**
 *
 * @author haris
 */
public class MyResetButton extends MyButton {
    public MyResetButton(String text)
    {
        super(text);
        setBackground(SystemColor.RESET_BTN_BG_COLOR);
        setForeground(SystemColor.RESET_BTN_FG_COLOR);
    }

}
