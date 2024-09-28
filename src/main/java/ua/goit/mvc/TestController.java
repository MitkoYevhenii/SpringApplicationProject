package ua.goit.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalTime;

@Controller
public class TestController {

    @GetMapping(value = "/test")
    public ModelAndView testMethod() {
        ModelAndView result = new ModelAndView("test");

        // Passing the current time as a model attribute for testing purposes
        result.addObject("time", LocalTime.now().toString());
        return result;
    }
}

