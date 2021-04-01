package controller;

import geometry.Generalization;
import view.UMLCanvas;

public class GeneralizationMode extends DragDrop{
    GeneralizationMode(UMLCanvas canvas) {
        super(Generalization.class.getName());
        this.canvas = canvas;
    }
}
