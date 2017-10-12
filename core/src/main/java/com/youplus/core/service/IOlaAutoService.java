package com.youplus.core.service;

import com.youplus.core.model.CustomerRideRequest;
import com.youplus.core.model.DashboardResponse;
import com.youplus.core.model.DriverAppResponse;
import com.youplus.core.model.DriverSelectRequest;
import java.util.List;


/**
 * Created by siva on 11/10/17.
 */
public interface IOlaAutoService {

  public Integer bookRide(CustomerRideRequest request);

  public List<DashboardResponse> getDashboardInfo();

  public String selectRide(DriverSelectRequest request);

  public DriverAppResponse getDriverAppInfo(Integer driverId);


}
