/**
 * 
 */
package fi.csc.fairdata.springboot;

/**
 * @author pj
 *
 */
public class Dataset {
	private final String id;
	private final String file; //comma separeted list
	private final String dir;
	
	public Dataset(String id, String file, String dir) {
		this.id = id;
		this.file = file;
		this.dir = dir;
	}
	
	public String getId() {
        return id;
    }
	
	public String getFile() {
        return file;
    }

	public String getDir() {
		return dir;
	}
	
}
