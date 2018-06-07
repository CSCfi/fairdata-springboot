/**
 * 
 */
package fi.csc.fairdata.springboot;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
/**
 * @author pj
 *
 */

@RestController
@RequestMapping("/api/v1/dataset")
public class Controller {

	
	    @RequestMapping(value = "/{id}")
	    public void dataset(@PathVariable("id") String id,
	    		@RequestParam(value="file", required = false) String file,
	    		@RequestParam(value="dir", required = false) String dir,
	    		HttpServletResponse response) {
	    	Dataset ds = new Dataset(id, file, dir);
	    	response.setContentType("application/octet-stream; charset=UTF-8");
	    	try {
	    	response.addHeader("Content-Disposition", "attachment; filename="+ds.getFile()
	    	+ "\"; filename*=UTF-8''" +URLEncoder.encode(ds.getFile(), "UTF-8"));
			} catch (UnsupportedEncodingException e) {
				System.err.println("UTF-8 ei muka löydy!");
				e.printStackTrace();
			}
	    	try {
				ds.copy(response.getOutputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
	    }
	

}
