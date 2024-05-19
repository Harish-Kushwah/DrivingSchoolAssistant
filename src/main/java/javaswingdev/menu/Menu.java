package javaswingdev.menu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import javaswingdev.GoogleMaterialDesignIcon;
import javaswingdev.swing.scroll.ScrollBar;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;

public class Menu extends JPanel {

    private int index = -1;
    private final List<EventMenuSelected> events = new ArrayList<>();

    public Menu() {
        init();
    }

    private void init() {
        setBackground(Color.WHITE);
        setLayout(new BorderLayout());
        JScrollPane scroll = createScroll();
        panelMenu = createPanelMenu();
        scroll.setViewportView(panelMenu);
        scroll.getViewport().setOpaque(false);
        scroll.setViewportBorder(null);
        add(scroll);
        addTitle("Matoshri Driving School");
        addMenuItem(new ModelMenuItem(GoogleMaterialDesignIcon.DASHBOARD, "Dashboard"));
        addTitle("Management");
        addMenuItem(new ModelMenuItem(GoogleMaterialDesignIcon.ADD_BOX, "New Application"));
        
//        "New Application","View Application", "Update", "Delete"));
        addMenuItem(new ModelMenuItem(GoogleMaterialDesignIcon.SEARCH, "Search"));
        addMenuItem(new ModelMenuItem(GoogleMaterialDesignIcon.UPDATE, "Update"));
        addMenuItem(new ModelMenuItem(GoogleMaterialDesignIcon.DELETE, "Delete"));
//        addMenuItem(new ModelMenuItem(GoogleMaterialDesignIcon.SEARCH, "Search" , "Application No." ,"Name" ,"Application Date"));
        addMenuItem(new ModelMenuItem(GoogleMaterialDesignIcon.FILTER_LIST, "Filter" ));
        addTitle("Financial");
        addMenuItem(new ModelMenuItem(GoogleMaterialDesignIcon.PAYMENT, "Payments", "New Transaction","View Payment History", "Generate Payment Reports"));
        addMenuItem(new ModelMenuItem(GoogleMaterialDesignIcon.RECEIPT, "Reports" , "Monthly Applications" ,"Pending Applications" ));

        addTitle("Settings");
        addMenuItem(new ModelMenuItem(GoogleMaterialDesignIcon.SETTINGS, "General Settings", "Language"));
        addMenuItem(new ModelMenuItem(GoogleMaterialDesignIcon.SETTINGS_REMOTE, "System Settings" , "Profile"));
        addTitle("Help");
        addMenuItem(new ModelMenuItem(GoogleMaterialDesignIcon.BOOK, "User Manual"));
        addMenuItem(new ModelMenuItem(GoogleMaterialDesignIcon.QUESTION_ANSWER, "FAQs"));
        addMenuItem(new ModelMenuItem(GoogleMaterialDesignIcon.CONTACT_MAIL, "Contact Support"));
    }

    private JScrollPane createScroll() {
        JScrollPane scroll = new JScrollPane();
        scroll.setBorder(null);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setVerticalScrollBar(new ScrollBar());
        return scroll;
    }

    private JPanel createPanelMenu() {
        JPanel panel = new JPanel();
        panel.setOpaque(false);
        menuLayout = new MigLayout("wrap,fillx,inset 0,gapy 0", "[fill]");
        panel.setLayout(menuLayout);

        return panel;
    }

    private JPanel createMenuItem(ModelMenuItem item) {
        MenuItem menuItem = new MenuItem(item, ++index, menuLayout);
        menuItem.addEvent(new EventMenuSelected() {
            @Override
            public void menuSelected(int index, int indexSubMenu) {
                if (!menuItem.isHasSubMenu() || indexSubMenu != 0) {
                    clearSelected();
                    setSelectedIndex(index, indexSubMenu);
                }
            }
        });
        return menuItem;
    }

    private void runEvent(int index, int indexSubMenu) {
        for (EventMenuSelected event : events) {
            event.menuSelected(index, indexSubMenu);
        }
    }

    //  Public Method
    public void addMenuItem(ModelMenuItem menu) {
        panelMenu.add(createMenuItem(menu), "h 35!");
    }

    public void addTitle(String title) {
        JLabel label = new JLabel(title);
        label.setBorder(new EmptyBorder(15, 20, 5, 5));
        label.setFont(label.getFont().deriveFont(Font.BOLD));
        label.setForeground(new Color(170, 170, 170));
        panelMenu.add(label);
    }

    public void addSpace(int size) {
        panelMenu.add(new JLabel(), "h " + size + "!");
    }

    public void setSelectedIndex(int index, int indexSubMenu) {
        for (Component com : panelMenu.getComponents()) {
            if (com instanceof MenuItem) {
                MenuItem item = (MenuItem) com;
                if (item.getIndex() == index) {
                    item.setSelectedIndex(indexSubMenu);
                    runEvent(index, indexSubMenu);
                    break;
                }
            }
        }
    }

    public void clearSelected() {
        for (Component com : panelMenu.getComponents()) {
            if (com instanceof MenuItem) {
                MenuItem item = (MenuItem) com;
                item.clearSelected();
            }
        }
    }

    public void addEvent(EventMenuSelected event) {
        events.add(event);
    }

    private MigLayout menuLayout;
    private JPanel panelMenu;
}
