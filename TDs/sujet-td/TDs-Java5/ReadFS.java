public class ReadFS {
    public static void main(String[] args) {
        String path = "";
        try {
            path = args[0];
            try {
                Directory d = new Directory(path);
                d.print();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            System.out.println("You must define a path to be explored: example: ReadFS /home" );
        }
    }
}
