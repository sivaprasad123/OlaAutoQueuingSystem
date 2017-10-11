package com.youplus.web.controller;

import com.sun.istack.internal.NotNull;
import com.youplus.core.model.OlaRideRequest;
import com.youplus.core.model.PickRideRequest;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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

  @RequestMapping(value = "/customerapp", method = RequestMethod.POST)
  public String getCustomerAppInfo(HttpServletRequest req,
      @RequestBody OlaRideRequest rideRequest) {
    System.out.println(rideRequest.getCustomerId());
    return null;
  }

  @RequestMapping(value = "/dashboard", method = RequestMethod.POST)
  public String getDashboardInfo(HttpServletRequest req) {
    System.out.println("dashboard request");
    return null;
  }

}
