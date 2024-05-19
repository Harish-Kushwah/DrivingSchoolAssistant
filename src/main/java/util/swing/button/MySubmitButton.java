package util.swing.button;

import javaswingdev.system.SystemColor;

/**
 *
 * @author haris
 */

public class MySubmitButton extends MyButton {
    public MySubmitButton(String text)
    {
        super(text);
        setBackground(SystemColor.SUBMIT_BTN_BG_COLOR);
        setForeground(SystemColor.SUBMIT_BTN_FG_COLOR);
    }

}