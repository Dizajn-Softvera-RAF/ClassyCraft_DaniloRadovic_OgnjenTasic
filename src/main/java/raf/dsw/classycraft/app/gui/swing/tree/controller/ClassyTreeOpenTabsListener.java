package main.java.raf.dsw.classycraft.app.gui.swing.tree.controller;

import main.java.raf.dsw.classycraft.app.gui.swing.tree.model.ClassyTreeItem;
import main.java.raf.dsw.classycraft.app.gui.swing.tree.view.ClassyTreeView;
import main.java.raf.dsw.classycraft.app.gui.swing.view.MainFrame;
import main.java.raf.dsw.classycraft.app.model.repo.abs.ClassyNode;
import main.java.raf.dsw.classycraft.app.model.repo.implementation.Diagram;
import main.java.raf.dsw.classycraft.app.model.repo.implementation.Package;

import javax.swing.tree.TreePath;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

public class ClassyTreeOpenTabsListener implements MouseListener {
    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getClickCount()!=2) return;
        ClassyTreeView tree = (ClassyTreeView) e.getSource();
        TreePath path = tree.getPathForLocation(e.getX(), e.getY());
        ClassyTreeItem treeItem = (ClassyTreeItem) path.getLastPathComponent();
        ClassyNode node = treeItem.getClassyNode();

        if(!(node instanceof Package)) return;
        List<Diagram> diagrams = new ArrayList<>();
        for(ClassyNode diagram: ((Package) node).getChildren()){
            if(diagram instanceof Diagram) diagrams.add((Diagram) diagram);
        }
        MainFrame.getInstance().openTabs(diagrams);
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}