package com.youplus.core.service;

import com.youplus.core.dao.RidesRepository;
import com.youplus.core.entity.Ride;
import com.youplus.core.model.CustomerRideRequest;
import com.youplus.core.model.DashboardResponse;
import com.youplus.core.model.DriverSelectRequest;
import com.youplus.core.type.RideStatus;
import com.youplus.core.utils.DateUtils;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by siva on 12/10/17.
 */
@Service
public class OlaAutoService implements IOlaAutoService {

  @Autowired
  private RidesRepository ridesRepository;

  @Override
  public Integer customerRideRequest(CustomerRideRequest request) {
    Ride ride = new Ride();

    ride.setCustomerId(request.getCustomerId());
    ride.setRequestedAt(new Date());
    ride.setStatus(RideStatus.WAITING.getId());

    ridesRepository.save(ride);

    return ride.getId();
  }

  @Override
  public List<DashboardResponse> getDashboardInfo() {
    List<DashboardResponse> dashboardResponseList = new ArrayList<>();
    List<Ride> rides = ridesRepository.findAllOrderByStatus();
    if (null != rides && rides.size() > 0) {
      for (Ride ride : rides) {
        DashboardResponse dashboardResponse = new DashboardResponse();
        dashboardResponse.setDriverId(ride.getDriverId());
        dashboardResponse.setCustomerId(ride.getCustomerId());
        dashboardResponse.setRequestId(ride.getId());
        dashboardResponse.setStatus(RideStatus.getDisplayName(ride.getStatus()));
        dashboardResponse
            .setTimeElapsed(DateUtils.getDateInString(ride.getRequestedAt(), new Date()));
        dashboardResponseList.add(dashboardResponse);
      }
    }
    return dashboardResponseList;
  }

  @Override
  public void driverSelected(DriverSelectRequest request) {

  }
}
