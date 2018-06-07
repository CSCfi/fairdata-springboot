/**
 * 
 */
package fi.csc.fairdata.springboot;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.ServletOutputStream;

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

	public void copy(ServletOutputStream outputStream) {

		HttpURLConnection con = null;
		BufferedOutputStream bof = new BufferedOutputStream(outputStream);
		try {
			URL url = new URL("http://www.nic.funet.fi/index/geodata/ilmatiede/wind_speed/Wind_10y_return_level.tif");
			con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			BufferedInputStream in = new BufferedInputStream(con.getInputStream());
			in.transferTo(bof);
			bof.flush();
			in.close();
			con.disconnect(); // ??
			bof.close();
		} catch (IOException e2) {
			try {
				int respCode = ((HttpURLConnection) con).getResponseCode();
				InputStream es = ((HttpURLConnection) con).getErrorStream();
				int ret = 0;
				byte[] buf = new byte[8192];
				System.err.print("Ida virhetilanne " + respCode + ": ");
				while ((ret = es.read(buf)) > 0) {
					bof.write(buf);
					System.err.write(buf);
					System.err.println();
				}
				es.close();
				// return new MetaxResponse(respCode, buf.toString());
			} catch (IOException e3) {
				System.err.println(e3.getMessage());
			}
			System.err.println(e2.getMessage());
		}
	}
}
