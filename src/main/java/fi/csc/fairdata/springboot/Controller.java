/**
 * 
 */
package fi.csc.fairdata.springboot;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
/**
 * @author pj
 *
 */

@RestController //should be@Controller
@RequestMapping("/api/v1/dataset")
public class Controller {

	
	    @RequestMapping(value = "/{id}")
	    public Dataset dataset(@PathVariable("id") String id,
	    		@RequestParam(value="file", required = false) String file,
	    		@RequestParam(value="dir", required = false) String dir) {
	        return new Dataset(id, file, dir);
	    }
	

}
