package com.scheduler.app.smartshift.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Alexander Shakhov.
 * <p>
 * User: alexandershakhov
 * <p>
 * Date: 16 Сентябрь 2018
 * <p>
 * Time: 21:18
 */
@Controller
@RequestMapping("/")
public class AuthController {

    @GetMapping("/home")
    public String home(Model model) {

        return "home";

    }

}
