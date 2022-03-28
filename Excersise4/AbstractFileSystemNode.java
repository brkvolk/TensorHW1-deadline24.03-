package Excersise4;

public abstract class AbstractFileSystemNode implements IFileSystemNode {
    public IFileSystemNode parent;
    String name;
    String path;

    @Override
    final public IFileSystemNode GetParent() {
        return parent;
    }

    @Override
    public String GetName() {
        return name;
    }

    @Override
    final public String GetPath() {
        return path;
    }

    final public void ChangeParent(IFileSystemNode newParent) {
        this.parent = newParent;
        path = newParent.GetPath() + "/" + this.name;
    }
    

}
