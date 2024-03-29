package main.java.raf.dsw.classycraft.app.model.repo.implementation;

import com.fasterxml.jackson.annotation.JsonIgnore;
import main.java.raf.dsw.classycraft.app.model.repo.abs.ClassyNode;
import main.java.raf.dsw.classycraft.app.model.repo.abs.ClassyNodeComposite;
import main.java.raf.dsw.classycraft.app.observer.IPublisher;
import main.java.raf.dsw.classycraft.app.observer.ISubscriber;

import java.util.ArrayList;
import java.util.List;

public class Diagram extends ClassyNodeComposite implements IPublisher {
    @JsonIgnore
    private final List<ISubscriber> subscribers = new ArrayList<>();

    public Diagram(ClassyNodeComposite parent, String name) {
        super(parent, name);
    }

    public Diagram() {
        super();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Diagram))
            return false;
        ClassyNode node = (ClassyNode) obj;
        return super.getParent() == node.getParent() && super.getName().equals(node.getName());
    }

    @Override
    public void addSubscriber(ISubscriber sub) {
        this.subscribers.add(sub);
    }

    @Override
    public void removeSubscriber(ISubscriber sub) {
        this.subscribers.remove(sub);
    }

    @Override
    public void notifySubscribers(Object notification) {
        for (ISubscriber sub : this.subscribers)
            sub.update(notification);
    }

    public List<ISubscriber> getSubscribers() {
        return subscribers;
    }


}
