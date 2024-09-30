package ua.goit.user.info;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ua.goit.user.info.time.TimezoneService;


@Controller
@RequestMapping(value = "/userInfo")
public class UserInfoController {

//    @GetMapping(value = "/time")
//    public ModelAndView getTimezone(@RequestParam(required = false, defaultValue = "UTC") String timezone) {
//        ModelAndView result = new ModelAndView("time");
//        result.addObject("time", TimezoneService.getTimeByUTCOffset(timezone));
//        return result;
//    }
//
//    @GetMapping(value = "/geolocation")
//    public ModelAndView getGeolocation(@RequestParam ) {
//
//    }
}

