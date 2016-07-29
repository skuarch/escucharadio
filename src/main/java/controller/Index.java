package controller;

import java.util.Locale;
import model.logic.RestClientGetAdapter;
import org.json.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * this is the first controller in the application.
 *
 * @author skuarch
 */
@Controller
public class Index {

    private static final ModelAndView MAV = new ModelAndView("index");

    //==========================================================================
    /**
     * index method.
     *
     * @return ModelAndView
     */
    @RequestMapping(value = "/")
    public ModelAndView index(Locale locale) {
        
        String stationsString;
        JSONArray jsonArrayStations;
        
        try {
            
            jsonArrayStations = RestClientGetAdapter.receive("http://localhost:8000/v1/station/getActiveStations/"+locale);            
            MAV.addObject("jsonArrayStations", jsonArrayStations);            
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        return MAV;
    }

}
