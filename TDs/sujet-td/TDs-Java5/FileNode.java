import java.io.IOException;

public class FileNode extends Node {

    public FileNode(String path) {
        super(path);
        try {
            this.size = FileInfo.size(path);
        } catch (IOException e) {
            System.out.println("Can't get the size of " + path);
        }

    }

    @Override
    public void print(String marge) {
        System.out.println(marge + "| " + FileInfo.getName(this.absPath) + " [" + size + " bytes]");
    }
}
