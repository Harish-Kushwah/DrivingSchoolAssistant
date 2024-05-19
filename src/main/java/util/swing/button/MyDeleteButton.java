package util.swing.button;

import javaswingdev.system.SystemColor;

/**
 *
 * @author haris
 */

public class MyDeleteButton extends MyButton {
    public MyDeleteButton(String text)
    {
        super(text);
        setBackground(SystemColor.DELETE_BTN_BG_COLOR);
        setForeground(SystemColor.DELETE_BTN_FG_COLOR);
    }

}