package Excersise4;

import java.util.List;

public class Folder extends AbstractFileSystemNode
{
    List<IFileSystemNode> Children;
    
    public Folder(IFileSystemNode[] args )
    {
        for(IFileSystemNode a: args)
        {
            a.ChangeParent(this);
            this.Children.add(a);
        }
    }
    public List<IFileSystemNode> GetChildren(){
        return Children;
    }
    
}
