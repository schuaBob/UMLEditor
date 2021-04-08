package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.UMLCanvas;
import geometry.Group;
public class GroupMode implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        UMLCanvas canvas = UMLCanvas.getInstance();
        Group g = (Group) canvas.getCurrentShape();
        canvas.addShape(g);
        canvas.repaint();
    }
}
