package controller;

import view.UMLCanvas;

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
}
