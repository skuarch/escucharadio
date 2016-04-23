package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author skuarch
 */
@Controller
public class Error404 {
    
    private static final ModelAndView MAV = new ModelAndView("404");
    
    //==========================================================================
    @RequestMapping(value = {"/404", "/error404"})
    public ModelAndView error404(){
    
        return MAV;
        
    }
    
}
