package com.youplus.web.controller;

import com.youplus.web.dao.ola.DriversRepository;
import com.youplus.web.entity.ola.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by siva on 10/10/17.
 */
@Controller
public class HelloController {

  @Autowired
  private DriversRepository driversRepository;

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String printWelcome(ModelMap model) {
    Driver byId = driversRepository.findById(1);
    model.addAttribute("message", "Spring 3 MVC Hello World");
    return "hello";

  }

  @RequestMapping(value = "/hello/{name:.+}", method = RequestMethod.GET)
  public ModelAndView hello(@PathVariable("name") String name) {

    ModelAndView model = new ModelAndView();
    model.setViewName("hello");
    model.addObject("msg", name);

    return model;

  }

}
