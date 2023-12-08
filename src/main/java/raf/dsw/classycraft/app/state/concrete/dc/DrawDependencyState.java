package main.java.raf.dsw.classycraft.app.state.concrete.dc;

import main.java.raf.dsw.classycraft.app.gui.swing.painter.ElementPainter;
import main.java.raf.dsw.classycraft.app.gui.swing.painter.cp.DependencyPainter;
import main.java.raf.dsw.classycraft.app.gui.swing.painter.icp.InterClassPainter;
import main.java.raf.dsw.classycraft.app.gui.swing.view.view.DiagramView;
import main.java.raf.dsw.classycraft.app.model.repo.factory.abstract_element_factory.ElementFactory;
import main.java.raf.dsw.classycraft.app.model.repo.factory.abstract_element_factory.enumeration.ConnectionType;
import main.java.raf.dsw.classycraft.app.model.repo.implementation.diagram.InterClass;
import main.java.raf.dsw.classycraft.app.model.repo.implementation.diagram.conection.Dependency;

import java.awt.event.MouseEvent;

public class DrawDependencyState extends DrawConnectionState {
	@Override
	public void mousePressed(MouseEvent e, DiagramView diagramView) {
		super.mousePressed(e, diagramView);
	}
	
	@Override
	public void mouseDragged(MouseEvent e, DiagramView diagramView) {
		super.mouseDragged(e, diagramView);
		
	}
	
	@Override
	public void mouseRelease(MouseEvent e, DiagramView diagramView) {
		diagramView.setConnectionTo(null);
		diagramView.setConnectionFrom(null);
		for(ElementPainter ep : diagramView.getElementPainters()) {
			if(ep instanceof InterClassPainter && ((InterClassPainter) ep).getRectangle().contains(e.getPoint())) {
				ElementFactory elementFactory = new ElementFactory();
				Dependency composition = (Dependency) elementFactory.createConnection(ConnectionType.DEPENDENCY, diagramView.getDiagram(), (InterClass) getFrom().getDiagramElement(), (InterClass) ep.getDiagramElement());
				DependencyPainter ap = new DependencyPainter(composition);
				ap.addElement(composition);
				diagramView.getElementPainters().add(ap);
				
				break;
			}
		}
	}
}
