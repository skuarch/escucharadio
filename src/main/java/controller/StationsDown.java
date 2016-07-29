package controller;

import java.util.Locale;
import model.logic.RestClientGetAdapter;
import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author skuarch
 */
@Controller
public class StationsDown {

    private static final Logger LOGGER = Logger.getLogger(StationsDown.class);
    
    //==========================================================================
    @RequestMapping(value = { "/stationsDown" })
    public ModelAndView stationsDown(@RequestParam("page") int page, @RequestParam("size") int size, Locale locale) {

        ModelAndView mav = new ModelAndView("stationsDown");
        JSONArray jsonArrayStations;

        try {
            jsonArrayStations = RestClientGetAdapter.receive("http://localhost:8000/v1/station/get/pageable?page="+page+"&size="+size+"&locale="+locale);
            mav.addObject("jsonArrayStations", jsonArrayStations);
        } catch (Exception e) {
            LOGGER.error("StationDown.stationsDown()", e);
        }

        return mav;

    }

}
