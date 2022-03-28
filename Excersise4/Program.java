package Excersise4;

public class Program {
    public static void main(String[] args) {

        Folder root = new Folder("root");
        File file1 = new File("file1", "txt");
        // System.out.println( file1.GetName() );
        Folder firstFolder = new Folder("firstFolder", file1);
        File file2 = new File("file2", "java");
        Folder secondFolder = new Folder("secondFolder", file1, file2);
        root.AddChild(firstFolder);
        root.AddChild(secondFolder);
        for (IFileSystemNode f : root.GetChildren())
            System.out.printf("root chlild:\t%s\n", f.GetName());
        Folder folder = (Folder) root.Children.get(1);
        for (IFileSystemNode f : folder.GetChildren())
            System.out.println( f.GetName());
    }
}
