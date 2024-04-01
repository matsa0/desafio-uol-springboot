package matsa.dev.desafiouolhost.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class FrontController {
    
    @RequestMapping("/")
    public ModelAndView home() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("index.html");

        return mav;
    }
}
