package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.service.CarService;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/cars")
public class CarController {
    @Autowired
    CarService service;

    @GetMapping("")
    public String getCount(HttpServletRequest request, ModelMap model) {
        int count;
        if (request.getParameter("count") == null) {
            count = 5;
        } else {

            count = Integer.parseInt(request.getParameter("count"));
            if (count == 0 || count > 5) {
                count = 5;
            }
        }
        model.addAttribute("cars", service.getCars(count));
        return "showcars";
    }
}
