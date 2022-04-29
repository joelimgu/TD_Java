public abstract class Node {
    protected String absPath;
    protected long size = 0;

    public Node(String path) {
        this.absPath = path;
    }

    public abstract void print(String marge);

}
