package main.java.raf.dsw.classycraft.app.model.repo.implementation.diagram.interclass.content;

import main.java.raf.dsw.classycraft.app.model.repo.implementation.diagram.Visibility;

public class Field extends ClassContent {
    private String type;

    public Field(String name, Visibility visibility, String type) {
        super(name, visibility);
        this.type = type;
    }

    public Field() {
    }

    @Override
    public String toString() {
        return getVisibility().toString() + " " + getName() + ": " + type;
    }

    @Override
    public int hashCode() {
        String buffer = this.getType() + this.getName();
        return buffer.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Field) {
            return ((Field) obj).type.equals(this.type) && ((Field) obj).getName().equals(this.getName());
        }
        return false;
    }

    public String toCode() {
        return "\t" + getVisibility().toCode() + " " + getType() + " " + getName() + ";";
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
