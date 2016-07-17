package com.seletivotechne;

import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;

/**
 *
 * @author andre ulisses
 */
@ApplicationPath("rest")
public class ApplicationTechne extends ResourceConfig {
    
    public ApplicationTechne(){
        packages("com.seletivotechne.controller");
    }
    
}
