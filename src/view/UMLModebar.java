package view;

import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.Dimension;

public class UMLModebar extends JPanel {
    private static final long serialVersionUID = -4975382869930285284L;

    UMLModebar() {
        this.setPreferredSize(new Dimension(100,0));
        this.setLayout(new FlowLayout());
        ModeBtn selectBtn = new ModeBtn("Select", new ImageIcon("img/select.png"));
        this.add(selectBtn);

        ModeBtn associationBtn = new ModeBtn("Association", new ImageIcon("img/association.png"));
        this.add(associationBtn);
        ModeBtn generalizationBtn = new ModeBtn("Generalization", new ImageIcon("img/generalization.png"));
        this.add(generalizationBtn);
        ModeBtn compositionBtn = new ModeBtn("Composition", new ImageIcon("img/composition.png"));
        this.add(compositionBtn);
        ModeBtn classBtn = new ModeBtn("Class", new ImageIcon("img/class.png"));
        this.add(classBtn);
        ModeBtn usecaseBtn = new ModeBtn("Use Case", new ImageIcon("img/use_case.png"));
        this.add(usecaseBtn);
    }

    private class ModeBtn extends JButton {
        private static final long serialVersionUID = -4311585356430114868L;
        private static final int height = 64;
        private static final int width = 64;
        ModeBtn(String tooltip, ImageIcon icon) {
            this.setToolTipText(tooltip);
            icon = resizeIIcon(icon, height, width);
            this.setIcon(icon);
        }
        private ImageIcon resizeIIcon(ImageIcon icon, int height, int width){
            return new ImageIcon(icon.getImage().getScaledInstance(height, width, Image.SCALE_SMOOTH));
        }
    }
}
