package view;

import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import controller.ModeCore;
import controller.ModeMenu;

public class UMLModebar extends JPanel {
    private static final long serialVersionUID = -4975382869930285284L;
    private UMLCanvas canvas;
    private final int width = 80;
    private JButton pressedBtn = null;

    UMLModebar() {
        this.canvas = UMLCanvas.getInstance();
        this.setPreferredSize(new Dimension(this.width, 0));
        this.setLayout(new FlowLayout());
        ModeMenu menu = new ModeMenu();
        ModeBtn selectBtn = new ModeBtn("Select", new ImageIcon("img/select.png"), menu.getMode("select"));
        this.add(selectBtn);

        ModeBtn associationBtn = new ModeBtn("Association", new ImageIcon("img/association.png"),
                menu.getMode("association"));
        this.add(associationBtn);

        ModeBtn generalizationBtn = new ModeBtn("Generalization", new ImageIcon("img/generalization.png"),
                menu.getMode("generalization"));
        this.add(generalizationBtn);

        ModeBtn compositionBtn = new ModeBtn("Composition", new ImageIcon("img/composition.png"),
                menu.getMode("composition"));
        this.add(compositionBtn);

        ModeBtn classBtn = new ModeBtn("Class", new ImageIcon("img/class.png"), menu.getMode("class"));
        this.add(classBtn);

        ModeBtn usecaseBtn = new ModeBtn("Use Case", new ImageIcon("img/use_case.png"), menu.getMode("use-case"));
        this.add(usecaseBtn);
    }

    private class ModeBtn extends JButton {
        private static final long serialVersionUID = -4311585356430114868L;
        private final int height = 60;
        private final int width = 60;
        private ModeCore mode;
        private Color color = Color.LIGHT_GRAY;

        ModeBtn(String tooltip, ImageIcon icon, ModeCore mode) {
            this.setToolTipText(tooltip);
            icon = resizeIIcon(icon, height, width);
            this.setIcon(icon);
            this.mode = mode;
            this.setPreferredSize(new Dimension(height, width));
            this.setBackground(this.color);
            this.addActionListener(new BtnAction());
        }

        private ImageIcon resizeIIcon(ImageIcon icon, int height, int width) {
            return new ImageIcon(icon.getImage().getScaledInstance(height - 20, width - 20, Image.SCALE_SMOOTH));
        }

        private class BtnAction implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton currentBtn = ((JButton) e.getSource());
                canvas.setMode(mode);
                currentBtn.setBackground(Color.BLACK);
                canvas.setCurrentShape(null);
                if (pressedBtn != null&&pressedBtn!=currentBtn) {
                    pressedBtn.setBackground(color);
                }
                pressedBtn = currentBtn;
                canvas.repaint();
            }

        }
    }
}
