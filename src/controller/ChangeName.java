package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import geometry.ObjectFrame;
import view.UMLCanvas;

public class ChangeName implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        UMLCanvas canvas = UMLCanvas.getInstance();
        String s = JOptionPane.showInputDialog("Change object name");
        // type vulnerable
        if (canvas.getCurrentShape() != null && !s.isEmpty()) {
            ObjectFrame of = (ObjectFrame) canvas.getCurrentShape();
            of.setName(s);
            canvas.repaint();
        }

    }

}
