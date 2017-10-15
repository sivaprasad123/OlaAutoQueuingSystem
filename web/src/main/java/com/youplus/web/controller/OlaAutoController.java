package com.youplus.web.controller;

import com.youplus.core.model.CustomerRideRequest;
import com.youplus.core.model.DashboardResponse;
import com.youplus.core.model.DriverAppResponse;
import com.youplus.core.model.DriverSelectRequest;
import com.youplus.core.service.IOlaAutoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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

  @Autowired
  private IOlaAutoService olaAutoService;

  @RequestMapping(value = "/driverapp", method = RequestMethod.GET)
  public ModelAndView getDriverAppInfo(
      @RequestParam(value = "id", required = true) Integer driverId) {
    ModelAndView mv = new ModelAndView("driver_app");
    try {
      DriverAppResponse driverAppInfo = olaAutoService.getDriverAppInfo(driverId);
      mv.addObject("driverAppInfo", driverAppInfo);
      mv.addObject("driverId", driverId);
    } catch (Exception e) {
      e.printStackTrace();//TODO this should be removed
      mv.setViewName("error");
    }
    return mv;
  }

  @RequestMapping(value = "/driverapp/select/ride/{driverId}/{requestId}", method = RequestMethod.GET)
  public ModelAndView pickRide(@PathVariable(value = "driverId") Integer driverId,
      @PathVariable(value = "requestId") Integer requestId) {
    ModelAndView mv = new ModelAndView("driver_app");
    try {
      String message = olaAutoService.selectRide(new DriverSelectRequest(requestId, driverId));
      DriverAppResponse driverAppInfo = olaAutoService
          .getDriverAppInfo(driverId);
      mv.addObject("driverAppInfo", driverAppInfo);
      mv.addObject("driverId", driverId);
      mv.addObject("selectRideResponse", message);
    } catch (Exception e) {
      e.printStackTrace();//TODO this should be removed
      mv.setViewName("error");
    }
    return mv;
  }

  @RequestMapping(value = "/customerapp", method = RequestMethod.GET)
  public ModelAndView getCustomerAppInfo() {
    return new ModelAndView("customer_app", "customerRideRequest", new CustomerRideRequest());
  }

  @RequestMapping(value = "/customerapp/book/ride", method = RequestMethod.POST)
  public ModelAndView getCustomerAppInfo2(
      @ModelAttribute("customerRideRequest") CustomerRideRequest rideRequest) {
    ModelAndView mv = new ModelAndView("customer_app", "customerRideRequest",
        new CustomerRideRequest());
    try {
      Integer rideRequestId = olaAutoService.bookRide(rideRequest);
      mv.addObject("sucessMsg",
          "Your request has been accepted and generated request id " + rideRequestId);
    } catch (Exception e) {
      e.printStackTrace();//TODO this should be removed
      mv.setViewName("error");
    }
    return mv;
  }

  @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
  public ModelAndView getDashboardInfo() {
    ModelAndView mv = new ModelAndView("dashboard");
    try {
      List<DashboardResponse> dashboardList = olaAutoService.getDashboardInfo();
      mv.addObject("dashboardList", dashboardList);
    } catch (Exception e) {
      e.printStackTrace();//TODO this should be removed
      mv.setViewName("error");
    }
    return mv;
  }

}
