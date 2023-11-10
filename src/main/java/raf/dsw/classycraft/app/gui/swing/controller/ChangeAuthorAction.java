package main.java.raf.dsw.classycraft.app.gui.swing.controller;

import main.java.raf.dsw.classycraft.app.gui.swing.view.ChangeAuthorView;
import main.java.raf.dsw.classycraft.app.gui.swing.view.MainFrame;
import main.java.raf.dsw.classycraft.app.model.repo.implementation.Project;

import java.awt.event.ActionEvent;


public class ChangeAuthorAction extends AbstractClassyAction{

    ChangeAuthorView changeAuthorView;

    public ChangeAuthorAction(ChangeAuthorView changeAuthorView) {
        this.changeAuthorView=changeAuthorView;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Project project = (Project) MainFrame.getInstance().getClassyTree().getSelectedNode().getClassyNode();
        System.out.println("Projekat "+project.getName()+" Prethodni autor: "+ project.getAuthor());
        project.setAuthor(changeAuthorView.getTfAuthor().getText());
        System.out.println("Projekat "+project.getName()+" Novi autor: "+ project.getAuthor());
        changeAuthorView.dispose();
    }
}
