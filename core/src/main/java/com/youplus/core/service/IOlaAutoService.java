package com.youplus.core.service;

import com.youplus.core.model.CustomerRideRequest;
import com.youplus.core.model.DashboardResponse;
import com.youplus.core.model.DriverSelectRequest;
import java.util.List;


/**
 * Created by siva on 11/10/17.
 */
public interface IOlaAutoService {

  public Integer customerRideRequest(CustomerRideRequest request);

  public List<DashboardResponse> getDashboardInfo();

  public void driverSelected(DriverSelectRequest request);


}
