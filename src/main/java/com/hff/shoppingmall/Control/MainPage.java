package com.hff.shoppingmall.Control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainPage {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String testUpload() {
        return "index.html";
    }
}
