package main.java.raf.dsw.classycraft.app.controller.sidebar;

import main.java.raf.dsw.classycraft.app.controller.AbstractClassyAction;
import main.java.raf.dsw.classycraft.app.gui.swing.view.frame.MainFrame;

import java.awt.event.ActionEvent;

public class ZoomToFitAction extends AbstractClassyAction {
    public ZoomToFitAction() {
        putValue(SMALL_ICON, loadIcon("/images/icons/zoom_fit.png"));
        putValue(NAME, "zoom to fit");
        putValue(SHORT_DESCRIPTION, "zoom to fit");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().getPackageView().startZoomToFitState();

    }
}
