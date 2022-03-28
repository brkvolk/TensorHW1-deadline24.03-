package Excersise4;

import java.util.ArrayList;
import java.util.List;

public class Folder extends AbstractFileSystemNode {
    List<IFileSystemNode> Children;

    public Folder(String name, IFileSystemNode... newChildren) {
        this(name);
        for (IFileSystemNode newChild : newChildren)
            this.AddChild(newChild);
    }

    public Folder(String name) {
        this.name = name;
        this.path = "/" + this.name;
        Children = new ArrayList<IFileSystemNode>();
    }

    public List<IFileSystemNode> GetChildren() {
        return Children;
    }

    public void AddChild(IFileSystemNode newChild) {
        newChild.ChangeParent(this);
        this.Children.add(newChild);
    }
}
