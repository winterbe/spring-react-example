package com.winterbe.react;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Benjamin Winterberg
 */
@Controller
public class MainController {

    @RequestMapping("/")
    public ModelAndView index() {
        return new ModelAndView("index.html");
    }

}
