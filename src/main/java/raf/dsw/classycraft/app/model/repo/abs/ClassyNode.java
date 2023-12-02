package main.java.raf.dsw.classycraft.app.model.repo.abs;

import main.java.raf.dsw.classycraft.app.core.ApplicationFramework;
import main.java.raf.dsw.classycraft.app.model.observer.notifications.PackageViewEvent;
import main.java.raf.dsw.classycraft.app.model.observer.notifications.SystemEvent;
import main.java.raf.dsw.classycraft.app.model.repo.implementation.Diagram;
import main.java.raf.dsw.classycraft.app.model.repo.implementation.Package;
import main.java.raf.dsw.classycraft.app.model.repo.implementation.Project;

import java.util.ArrayList;

public abstract class ClassyNode {
	private final ClassyNodeComposite parent;
	private String name;
	
	public ClassyNode(ClassyNodeComposite parent, String name) {
		this.parent = parent;
		this.name = name;
	}
	
	@Override
	public String toString() {
		return name;
	}
	
	public ClassyNode getParent() {
		return parent;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		for(ClassyNode c : this.parent.getChildren()) {
			if(c.getName().equals(name)) {
				ApplicationFramework.getInstance().getMessageGenerator().GenerateMessage(SystemEvent.NODE_CANNOT_BE_DUPLICATE);
				return;
			}
		}
		this.name = name;
		if(this instanceof Diagram) {
			((Package) this.getParent()).notifySubscribers(PackageViewEvent.RENAME_DIAGRAM);
		}else if(this instanceof Project) {
			changeProjectNameUpdate((ArrayList<ClassyNode>) ((Project) this).getChildren());
		}
	}
	
	public void changeProjectNameUpdate(ArrayList<ClassyNode> children) {
		for(ClassyNode classyNode : children) {
			if(classyNode instanceof Package) {
				((Package) classyNode).notifySubscribers(PackageViewEvent.RENAME_PROJECT);
				changeProjectNameUpdate((ArrayList<ClassyNode>) ((Package) classyNode).getChildren());
			}
		}
	}
}
