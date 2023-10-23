package main.java.raf.dsw.classycraft.app.gui.swing.controller;

import main.java.raf.dsw.classycraft.app.gui.swing.view.AboutUsFrame;
import main.java.raf.dsw.classycraft.app.gui.swing.view.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class AboutUsAction extends AbstractClassyAction {

    public AboutUsAction() {
        putValue(SMALL_ICON, null); //TODO dodaj ikonu za about us
        putValue(NAME, "About us");
        putValue(SHORT_DESCRIPTION, "About us");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //TODO pop up meni sa licnim podacima i slikom.

        AboutUsFrame.getInstance().setVisible(true);
    }
}
