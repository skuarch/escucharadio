package controller;

import model.logic.RestClientGetAdapter;
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

    //==========================================================================
    @RequestMapping(value = { "/stationsDown" })
    public ModelAndView stationsDown(@RequestParam("page") int page, @RequestParam("size") int size) {

        ModelAndView mav = new ModelAndView("stationsDown");
        JSONArray jsonArrayStations;

        try {
            jsonArrayStations = RestClientGetAdapter.receive("http://localhost:8000/v1/station/get/pageable?page="+page+"&size="+size);
            mav.addObject("jsonArrayStations", jsonArrayStations);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return mav;

    }

}
