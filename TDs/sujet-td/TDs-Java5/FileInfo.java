import java.io.* ;
import java.util.* ;

public class FileInfo {

    // No constructor
    private FileInfo() { }
    
    /**
     *  @param path an absolute path to a file or directory
     *  @return the name of the file or directory
     */
    public static String getName(String path) {
	return (new File(path)).getName() ;
    }

    /**
     *  @param path an absolute path to a file
     *  @return the size of the file
     *  @throws java.io.IOException if the file does not exist or if it is a directory.
     */
    public static long size(String path) throws IOException {
	File file = new File(path) ;
	if (file.exists() && file.isFile()) return file.length() ;
	else if (!file.exists ()) throw (new IOException("File " + path + " does not exist.")) ;
	else throw (new IOException(path + " is not a regular file.")) ;
    }

    /**
     *  @param path an absolute path to a file or a directory
     *  @return true if it is a directory
     */
    public static boolean isDirectory(String path) {
	return (new File(path)).isDirectory() ;
    }

    /**
     *  @param path an absolute path to a file or a directory
     *  @return true if it is a regular file
     */
    public static boolean isFile(String path) {
	return (new File(path)).isFile() ;
    }

    /**
     * @paral path an absolute path to a directory
     * @return an iterator over the paths of all elements in this directory.
     * @throws java.io.IOException if it is not a directory.
     */
    public static Iterator<String> getElements(String path) throws IOException {
	File file = new File(path) ;

	if (!file.exists ()) throw (new IOException("Directory " + path + " does not exist.")) ;
	if (!file.isDirectory()) throw (new IOException(path + " is not a directory.")) ;

	String[] elements = file.list() ;
	// If the directory could not be read, elements is null here.
	if (elements == null) {
	    elements = new String[0] ;
	}
	
	for (int i = 0 ; i < elements.length ; i++) {
	    elements[i] = path + File.separator + elements[i] ;
	}
        
	// if (elements == null) throw (new IOException("Cannot read directory " + path)) ;

	return Arrays.asList(elements).iterator() ;
    }
}
