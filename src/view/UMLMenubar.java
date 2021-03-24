package view;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
public class UMLMenubar extends JMenuBar{
    private static final long serialVersionUID = -8317121859167637494L;

    UMLMenubar() {
        this.add(new JMenu("File"));
        this.add(new JMenu("Edit"));
    }

}
