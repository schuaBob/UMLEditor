package controller;
import geometry.Association;
import view.UMLCanvas;
public class AssociationMode extends DragDrop{
    AssociationMode(UMLCanvas canvas){
        super(Association.class.getName());
        this.canvas = canvas;
    }
}
