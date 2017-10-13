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
    DriverAppResponse driverAppInfo = olaAutoService.getDriverAppInfo(driverId);
    ModelAndView mv = new ModelAndView("driver_app");
    mv.addObject("driverAppInfo", driverAppInfo);
    mv.addObject("driverId", driverId);
    return mv;
  }

  @RequestMapping(value = "/driverapp/select/ride/{driverId}/{requestId}", method = RequestMethod.GET)
  public ModelAndView pickRide(@PathVariable(value = "driverId") Integer driverId,
      @PathVariable(value = "requestId") Integer requestId) {
    String message = olaAutoService.selectRide(new DriverSelectRequest(requestId, driverId));
    DriverAppResponse driverAppInfo = olaAutoService
        .getDriverAppInfo(driverId);
    ModelAndView mv = new ModelAndView("driver_app");
    mv.addObject("driverAppInfo", driverAppInfo);
    mv.addObject("driverId", driverId);
    mv.addObject("selectRideResponse", message);
    return mv;
  }

  @RequestMapping(value = "/customerapp", method = RequestMethod.GET)
  public ModelAndView getCustomerAppInfo() {
    return new ModelAndView("customer_app", "customerRideRequest", new CustomerRideRequest());
  }

  @RequestMapping(value = "/customerapp/book/ride", method = RequestMethod.POST)
  public ModelAndView getCustomerAppInfo2(
      @ModelAttribute("customerRideRequest") CustomerRideRequest rideRequest) {
    Integer rideRequestId = olaAutoService.bookRide(rideRequest);
    ModelAndView mv = new ModelAndView("customer_app", "customerRideRequest",
        new CustomerRideRequest());
    mv.addObject("sucessMsg", "Your request has been accepted and generated request id " + rideRequestId);
    return mv;
  }

  @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
  public ModelAndView getDashboardInfo() {
    List<DashboardResponse> dashboardList = olaAutoService.getDashboardInfo();
    ModelAndView mv = new ModelAndView("dashboard");
    mv.addObject("dashboardList", dashboardList);
    return mv;
  }

}
