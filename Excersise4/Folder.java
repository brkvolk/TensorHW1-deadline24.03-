package Excersise4;

import java.util.List;

public class Folder {
    IFileSystemNode parent;
    List<IFileSystemNode> Children;
    
    public Folder(IFileSystemNode[] args )
    {

    };
    public List<IFileSystemNode> GetChildren(){
        return Children;
    }
}
