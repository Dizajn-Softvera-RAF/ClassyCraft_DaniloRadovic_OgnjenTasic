package main.java.raf.dsw.classycraft.app.gui.swing.view.bar;


import main.java.raf.dsw.classycraft.app.gui.swing.view.frame.MainFrame;

import javax.swing.*;

public class MyToolBar extends JToolBar {

    public MyToolBar() {
        super(HORIZONTAL);
        setFloatable(false);
        add(MainFrame.getInstance().getActionManager().getOpenAction());
        add(MainFrame.getInstance().getActionManager().getSaveAction());
        add(MainFrame.getInstance().getActionManager().getSaveAsAction());
        add(MainFrame.getInstance().getActionManager().getNewProjectAction());
        add(MainFrame.getInstance().getActionManager().getNewPackageAction());
        add(MainFrame.getInstance().getActionManager().getNewDiagramAction());
        add(MainFrame.getInstance().getActionManager().getDeleteNodeAction());
        add(MainFrame.getInstance().getActionManager().getChangeAuthorShowViewAction());
        add(MainFrame.getInstance().getActionManager().getSaveDiagramAsScreenshotAction());
        add(MainFrame.getInstance().getActionManager().getSaveDiagramAsTemplateAction());
        add(MainFrame.getInstance().getActionManager().getExportProjectAsJavaCodeAction());
        add(MainFrame.getInstance().getActionManager().getUndoAction());
        add(MainFrame.getInstance().getActionManager().getRedoAction());
        add(MainFrame.getInstance().getActionManager().getAboutUsAction());
        add(MainFrame.getInstance().getActionManager().getExitAction());
    }

}
