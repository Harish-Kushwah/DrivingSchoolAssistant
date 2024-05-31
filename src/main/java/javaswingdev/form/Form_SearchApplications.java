package javaswingdev.form;

/**
 *
 * @author haris
 */
public class Form_SearchApplications extends TemplatePage {

    public Form_SearchApplications() {
        super("Search Applications");
        infoOutputPanel.add(getInfoLabel("If Application Available"), "al left,wrap 61,growx");
        outputPanel.add(infoOutputPanel, "growx , wrap , top,pushy");  
        
        setInputesEditable(false);
       
    }
    
    
}
