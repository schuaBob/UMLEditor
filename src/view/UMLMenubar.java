package view;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import controller.ModeMenu;
import java.awt.event.ActionListener;

public class UMLMenubar extends JMenuBar {
    private static final long serialVersionUID = -8317121859167637494L;
    private ModeMenu menu = new ModeMenu();
    UMLMenubar() {
        JMenu editSubMenu = new JMenu("Edit");
        JMenu fileSubMenu = new JMenu("File");
        CusJMItem cName = new CusJMItem("Change object name", menu.getMenuMode("cname"));
        CusJMItem group = new CusJMItem("Group", menu.getMenuMode("group"));
        CusJMItem ungroup = new CusJMItem("UnGroup", menu.getMenuMode("ungroup"));
        fileSubMenu.add(cName);
        editSubMenu.add(group);
        editSubMenu.add(ungroup);
        this.add(fileSubMenu);
        this.add(editSubMenu);
    }

    private class CusJMItem extends JMenuItem {
        private static final long serialVersionUID = 4051621492687309692L;

        CusJMItem(String title, ActionListener aListener) {
            super(title);
            this.addActionListener(aListener);
        }
    }
}
