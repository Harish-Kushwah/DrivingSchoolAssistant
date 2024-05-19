package util.swing;

import javaswingdev.system.SystemColor;
import javaswingdev.system.SystemFonts;
import javax.swing.JLabel;

/**
 *
 * @author haris
 */
public class MySubtitle extends JLabel {
    
    public MySubtitle(String title)
    {
        super(title);
        setFont(SystemFonts.SUBTITLE_FONT);
        setForeground(SystemColor.MAIN_COLOR_2);        
    }
    
}
