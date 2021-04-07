package controller;

import view.UMLCanvas;
import java.awt.event.ActionListener;

public class ModeMenu {
    private UMLCanvas canvas;

    public ModeMenu() {
        this.canvas = UMLCanvas.getInstance();
    }

    public ModeCore getMode(String s) {
        ModeCore mode = null;
        switch (s) {
        case "class":
            mode = new ClassMode(canvas);
            break;
        case "use-case":
            mode = new UseCaseMode(canvas);
            break;
        case "select":
            mode = new SelectMode(canvas);
            break;
        case "association":
            mode = new AssociationMode(canvas);
            break;
        case "generalization":
            mode = new GeneralizationMode(canvas);
            break;
        case "composition":
            mode = new CompositionMode(canvas);
            break;
        default:
            break;
        }
        return mode;
    }

    public ActionListener getMenuMode(String s) {
        ActionListener mode = null;
        switch (s) {
            case "cname":
                mode = new ChangeName();
                break;
            case "group":
                mode = new GroupMode();
                break;
            case "ungroup":
                mode = new UnGroupMode();
                break;
            default:
                break;
        }
        return mode;
    }
}
