package controller;

import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author skuarch
 */
@Controller
public class Robots {

    private static final ModelAndView MAV = new ModelAndView("robots");

    //==========================================================================
    @RequestMapping(value = {"/robots.txt", "/Robots.txt", "/robots"})
    public ModelAndView robots(HttpServletResponse response) {
        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
        return MAV;

    }

}
