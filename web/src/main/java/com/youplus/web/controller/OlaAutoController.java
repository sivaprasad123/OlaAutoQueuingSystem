package com.youplus.web.controller;

import com.youplus.core.model.DashboardResponse;
import com.youplus.core.model.OlaRideRequest;
import com.youplus.core.model.PickRideRequest;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by siva on 11/10/17.
 */
@Controller
@RequestMapping("/v1")
public class OlaAutoController {

  @RequestMapping(value = "/driverapp", method = RequestMethod.POST)
  public String getDriverAppInfo(HttpServletRequest req,
      @RequestParam(value = "id", required = true) Integer driverId) {
    System.out.println(driverId);
    return null;
  }

  @RequestMapping(value = "/pick/ride", method = RequestMethod.POST)
  public String pickRide(HttpServletRequest req,
      @RequestBody PickRideRequest pickRideRequest) {
    System.out.println(pickRideRequest.getDriverId());
    return null;
  }

  @RequestMapping(value = "/customerapp", method = RequestMethod.GET)
  public ModelAndView getCustomerAppInfo(HttpServletRequest req) {
    return new ModelAndView("customer_app", "rideRequest", new OlaRideRequest());
  }

  @RequestMapping(value = "/customer/book/ride", method = RequestMethod.POST)
  public ModelAndView getCustomerAppInfo2(HttpServletRequest req,
      @ModelAttribute("rideRequest") OlaRideRequest rideRequest) {
    System.out.println(rideRequest.getCustomerId());
    ModelAndView mv = new ModelAndView("customer_app", "rideRequest", new OlaRideRequest());
    mv.addObject("sucessMsg", "Sucessfully inserted");
    return mv;
  }

  @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
  public ModelAndView getDashboardInfo(HttpServletRequest req) {
    DashboardResponse dashboardResponse = new DashboardResponse();
    dashboardResponse.setCustomerId(123);
    dashboardResponse.setRequestId(01);
    dashboardResponse.setStatus("Waiting");
    dashboardResponse.setTimeElapsed("45 sec");

    DashboardResponse dashboardResponse2 = new DashboardResponse();
    dashboardResponse2.setCustomerId(200);
    dashboardResponse2.setRequestId(02);
    dashboardResponse2.setDriverId(234);
    dashboardResponse2.setStatus("Ongoing");
    dashboardResponse2.setTimeElapsed("1 min45 sec");

    DashboardResponse dashboardResponse3 = new DashboardResponse();
    dashboardResponse3.setCustomerId(1203);
    dashboardResponse3.setDriverId(203);
    dashboardResponse3.setRequestId(03);
    dashboardResponse3.setStatus("Completed");
    dashboardResponse3.setTimeElapsed("4 min 45 sec");

    List<DashboardResponse> list = new ArrayList<>();
    list.add(dashboardResponse);
    list.add(dashboardResponse2);
    list.add(dashboardResponse3);
    ModelAndView mv = new ModelAndView("dashboard");
    mv.addObject("dashboardList", list);
    return mv;
  }

}
