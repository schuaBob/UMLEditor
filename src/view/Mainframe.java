package view;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
public class Mainframe extends JFrame{
    private static final long serialVersionUID = -7593233136853774602L;

    public Mainframe() {
        this.setTitle("Bob's UML editor");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(420, 420);
        this.setLayout(new BorderLayout());
    }
    public void composeAndRun() {
        JPanel pnlRoot = new JPanel();
        pnlRoot.setName("pnlRoot");
        pnlRoot.setLayout(new BorderLayout());
        UMLMenubar menubar = new UMLMenubar();
        UMLModebar modebar = new UMLModebar();
        UMLCanvas canvas = new UMLCanvas();
        this.setJMenuBar(menubar);
        pnlRoot.add(modebar, BorderLayout.WEST);
        pnlRoot.add(canvas, BorderLayout.CENTER);
        this.add(pnlRoot, BorderLayout.CENTER);
        // this.pack();
        this.setVisible(true);
    }
}