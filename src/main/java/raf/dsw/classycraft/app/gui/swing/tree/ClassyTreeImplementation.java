package main.java.raf.dsw.classycraft.app.gui.swing.tree;


import main.java.raf.dsw.classycraft.app.gui.swing.tree.model.ClassyTreeItem;
import main.java.raf.dsw.classycraft.app.gui.swing.tree.view.ClassyTree;
import main.java.raf.dsw.classycraft.app.gui.swing.tree.view.ClassyTreeView;
import main.java.raf.dsw.classycraft.app.model.repo.abs.ClassyNode;
import main.java.raf.dsw.classycraft.app.model.repo.implementation.ProjectExplorer;

import javax.swing.*;
import javax.swing.tree.DefaultTreeModel;

public class ClassyTreeImplementation implements ClassyTree {
	private ClassyTreeView treeView;
	private ClassyTreeItem root;
	
	@Override
	public ClassyTreeView generateTree(ProjectExplorer projectExplorer) {
		root = new ClassyTreeItem(projectExplorer);
		DefaultTreeModel treeModel = new DefaultTreeModel(root);
		treeView = new ClassyTreeView(treeModel);
		return treeView;
	}
	
	@Override
	public void addChild(ClassyTreeItem parent, ClassyNode classyNode) {
		parent.add(new ClassyTreeItem(classyNode));
		treeView.expandPath(treeView.getSelectionPath());
		SwingUtilities.updateComponentTreeUI(treeView);
	}
	
	public void removeNode(ClassyTreeItem classyTreeItem) {
		classyTreeItem.removeFromParent();
		treeView.expandPath(treeView.getSelectionPath());
		SwingUtilities.updateComponentTreeUI(treeView);
	}
	
	@Override
	public ClassyTreeItem getSelectedNode() {
		return (ClassyTreeItem) treeView.getLastSelectedPathComponent();
	}
	
	public ClassyTreeItem getRoot() {
		return root;
	}
	
}
