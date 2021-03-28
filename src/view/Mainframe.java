package view;
import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.awt.Container;
public class Mainframe extends JFrame{
    private static final long serialVersionUID = -7593233136853774602L;
    private UMLMenubar menubar;
    private UMLCanvas canvas;
    private UMLModebar modebar;
    public Mainframe() {
        this.setTitle("Bob's UML editor");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(420, 420);
    }
    public void composeAndRun() {
        Container pnlRoot = this.getContentPane();

        pnlRoot.setLayout(new BorderLayout());

        menubar = new UMLMenubar();
        canvas = UMLCanvas.getInstance();
        modebar = new UMLModebar();

        this.setJMenuBar(menubar);
        pnlRoot.add(modebar, BorderLayout.WEST);
        pnlRoot.add(canvas, BorderLayout.CENTER);
        // this.pack();
        this.setVisible(true);
    }
}