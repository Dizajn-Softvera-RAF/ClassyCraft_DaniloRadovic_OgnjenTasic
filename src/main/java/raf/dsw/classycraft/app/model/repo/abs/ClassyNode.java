package main.java.raf.dsw.classycraft.app.model.repo.abs;

import main.java.raf.dsw.classycraft.app.model.repo.implementation.NodeType;

public abstract class ClassyNode {
    private ClassyNode parent;
    private String name;
    private final NodeType type;

    public ClassyNode(ClassyNode parent, String name, NodeType type) {
        this.parent = parent;
        this.name = name;
        this.type = type;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof  ClassyNode)) return false;
        ClassyNode node = (ClassyNode) obj;
        return this.name.equals(node.name) && this.type.equals(node.type)&& this.parent.equals(node.parent);
    }

    @Override
    public String toString() {
        return name;
    }

    public ClassyNode getParent() {
        return parent;
    }

    public void setParent(ClassyNode parent) {
        this.parent = parent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public NodeType getType() {
        return type;
    }
}
