package main.java.raf.dsw.classycraft.app.state.concrete.dc;

import main.java.raf.dsw.classycraft.app.gui.swing.painter.ElementPainter;
import main.java.raf.dsw.classycraft.app.gui.swing.painter.cp.GeneralisationPainter;
import main.java.raf.dsw.classycraft.app.gui.swing.painter.icp.InterClassPainter;
import main.java.raf.dsw.classycraft.app.gui.swing.view.view.DiagramView;
import main.java.raf.dsw.classycraft.app.model.repo.factory.abstract_element_factory.ElementFactory;
import main.java.raf.dsw.classycraft.app.model.repo.factory.abstract_element_factory.enumeration.ConnectionType;
import main.java.raf.dsw.classycraft.app.model.repo.implementation.diagram.InterClass;
import main.java.raf.dsw.classycraft.app.model.repo.implementation.diagram.conection.Generalisation;

import java.awt.event.MouseEvent;

public class DrawGeneralisationState extends DrawConnectionState {
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
			if(ep instanceof InterClassPainter && ((InterClassPainter) ep).getRectangle().contains(diagramView.adjustPoint(e.getPoint()))) {
				ElementFactory elementFactory = new ElementFactory();
				Generalisation composition = (Generalisation) elementFactory.createConnection(ConnectionType.GENERALISATION, diagramView.getDiagram(), getFrom().getDiagramElement(), (InterClass) ep.getDiagramElement());
				GeneralisationPainter ap = new GeneralisationPainter(composition);
				for(ElementPainter elementPainter: diagramView.getElementPainters()){
					if(ap.equals(elementPainter)){
						//TODO SYSTEM EVENT
						break;
					}
					
				}
				ap.addElement(composition);
				diagramView.getElementPainters().add(ap);
				
				break;
			}
		}
		
	}
}
