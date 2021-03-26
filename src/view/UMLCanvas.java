package view;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class UMLCanvas extends JPanel{
    /**
     *
     */
    private static final long serialVersionUID = 6555233771629347251L;

    UMLCanvas() {
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
    }
}
