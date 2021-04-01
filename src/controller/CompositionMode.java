package controller;

import geometry.Composition;
import view.UMLCanvas;

public class CompositionMode extends DragDrop{
    CompositionMode(UMLCanvas canvas) {
        super(Composition.class.getName());
        this.canvas = canvas;
    }
}
