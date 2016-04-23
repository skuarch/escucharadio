package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author skuarch
 */
@Controller
public class AdBlocker {
    
    private static final ModelAndView MAV = new ModelAndView("adblocker");
    
    //==========================================================================
    @RequestMapping(value = {"/adblocker"})
    public ModelAndView adBlocker(){
    
        return MAV;
        
    }
    
}
