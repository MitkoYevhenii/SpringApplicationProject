package ua.goit.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class testController {

    @GetMapping(value = "/test")
    public String getTest() {
        return "test";
    }
}
