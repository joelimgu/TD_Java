import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;

public class Directory extends Node {

    protected ArrayList<Node> elements = new ArrayList<>();
    public long size = 0;

    public Directory(String path) {
        super(path); // todo size
        try {
            for (Iterator<String> it = FileInfo.getElements(path); it.hasNext(); ) {
                String el = it.next();

                if ( FileInfo.isFile(el) ) {
                    FileNode f = new FileNode(el);
                    elements.add(f);
                    this.size += f.size;
                } else {
                    Directory d = new Directory(el);
                    elements.add(d);
                    this.size += d.size;
                }
            }
        } catch (IOException e) {
            System.out.println("Err while: ");
            e.printStackTrace();
        }
    }

    @Override
    public void print(String marge) {
        String res = marge;
        System.out.println(marge + "+ (DIR) " + FileInfo.getName(this.absPath) + " [" + this.size + " bytes]");
        for ( Node el: this.elements ) {
            el.print(marge + "    ");
        }
    }

    public void print() {
        this.print("");
    }
}
