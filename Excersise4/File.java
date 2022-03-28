package Excersise4;

public class File extends AbstractFileSystemNode {
    String Extension;

    public File(String name, String exstention) {
        this.name = name;
        this.Extension = exstention;
    }

    public String GetExtensin() {
        return Extension;
    }

    public String GetFilePath() {
        return this.path;
    }
}
