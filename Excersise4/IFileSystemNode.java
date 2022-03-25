package Excersise4;

public interface IFileSystemNode{

    IFileSystemNode GetParent();
    String GetName();
    String GetPath();
    void ChangeParent(IFileSystemNode f);
}