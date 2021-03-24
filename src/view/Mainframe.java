package view;
import javax.swing.JFrame;
import java.awt.BorderLayout;
public class Mainframe extends JFrame{
    private static final long serialVersionUID = -7593233136853774602L;

    public Mainframe() {
        this.setTitle("Bob's UML editor");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(420, 420);
        this.setLayout(new BorderLayout());
        UMLMenubar menubar = new UMLMenubar();
        UMLModebar modebar = new UMLModebar();
        UMLCanvas canvas = new UMLCanvas();
        this.setJMenuBar(menubar);
        this.add(modebar, BorderLayout.WEST);
        this.add(canvas, BorderLayout.CENTER);
        // this.pack();
        this.setVisible(true);
    }
}