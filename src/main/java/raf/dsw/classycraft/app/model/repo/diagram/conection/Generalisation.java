package main.java.raf.dsw.classycraft.app.model.repo.diagram.conection;

import main.java.raf.dsw.classycraft.app.model.repo.abs.ClassyNode;
import main.java.raf.dsw.classycraft.app.model.repo.diagram.Concection;
import main.java.raf.dsw.classycraft.app.model.repo.diagram.InterClass;

public class Generalisation extends Concection {
    public Generalisation(ClassyNode parent, String ime, InterClass from, InterClass to) {
        super(parent, ime, from, to);
    }
}