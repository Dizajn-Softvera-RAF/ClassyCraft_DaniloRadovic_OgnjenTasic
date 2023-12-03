package main.java.raf.dsw.classycraft.app.gui.swing.controller.sidebar.dic.dcc;

import main.java.raf.dsw.classycraft.app.gui.swing.controller.AbstractClassyAction;
import main.java.raf.dsw.classycraft.app.gui.swing.view.frame.MainFrame;

import java.awt.event.ActionEvent;

public class DrawMethodAction extends AbstractClassyAction {
	public DrawMethodAction() {
		putValue(SMALL_ICON, loadIcon("/images/icons/m.png"));
		putValue(NAME, "draw method");
		putValue(SHORT_DESCRIPTION, "draw method");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		MainFrame.getInstance().getPackageView().getStateManager().setDrawMethodState();
		
	}
}
