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
	private final String file;
	
	public Dataset(String id, String file) {
		this.id = id;
		this.file = file;
	}
	
	public String getId() {
        return id;
    }
	
	public String getFile() {
        return file;
    }
}
