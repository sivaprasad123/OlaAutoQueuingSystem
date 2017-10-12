package com.youplus.core.service;

import com.youplus.core.dao.RidesRepository;
import com.youplus.core.entity.Ride;
import com.youplus.core.model.CustomerRideRequest;
import com.youplus.core.model.DashboardResponse;
import com.youplus.core.model.DriverAppResponse;
import com.youplus.core.model.DriverSelectRequest;
import com.youplus.core.model.RideResponse;
import com.youplus.core.type.RideStatus;
import com.youplus.core.utils.DateUtils;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by siva on 12/10/17.
 */
@Service
public class OlaAutoService implements IOlaAutoService {

  @Autowired
  private RidesRepository ridesRepository;

  @Override
  public Integer bookRide(CustomerRideRequest request) {
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
    List<Ride> rides = ridesRepository.findAll();
    if (null != rides && rides.size() > 0) {
      for (Ride ride : rides) {
        DashboardResponse dashboardResponse = new DashboardResponse();
        dashboardResponse.setDriverId(ride.getDriverId());
        dashboardResponse.setCustomerId(ride.getCustomerId());
        dashboardResponse.setRequestId(ride.getId());
        dashboardResponse.setStatus(RideStatus.getDisplayName(ride.getStatus()));
        dashboardResponse
            .setTimeElapsed(DateUtils.getElapsedDate(ride.getRequestedAt(), new Date()));
        dashboardResponseList.add(dashboardResponse);
      }
    }
    return dashboardResponseList;
  }

  @Override
  @Transactional(value = "olaTransactionManager")
  public String selectRide(DriverSelectRequest request) {
    Ride ride = ridesRepository.getOne(request.getRequestId());
    if (null != ride.getDriverId()) {
      return "request no longer available";
    }
    synchronized (OlaAutoService.class) {
      ride.setDriverId(request.getDriverId());
      ride.setPickedupAt(new Date());
    }
    return null;
  }

  @Override
  public DriverAppResponse getDriverAppInfo(Integer driverId) {
    DriverAppResponse driverAppResponse = new DriverAppResponse();
    List<Ride> rides = ridesRepository.findAll();
    if (null != rides && rides.size() > 0) {
      for (Ride ride : rides) {
        RideResponse rideResponse = new RideResponse();
        rideResponse.setCustomerId(ride.getCustomerId());
        rideResponse.setRequestId(ride.getId());
        rideResponse
            .setRequestedAt(DateUtils.getDateInString(ride.getRequestedAt(), new Date()));
        if (RideStatus.WAITING.getId().intValue() == ride.getStatus().intValue()) {
          driverAppResponse.getWaiting().add(rideResponse);
        } else if (RideStatus.ONGOING.getId().intValue() == ride.getStatus().intValue()) {
          rideResponse.setPickedUpAt(DateUtils.getDateInString(ride.getPickedupAt(), new Date()));
          driverAppResponse.getOnGoing().add(rideResponse);
        } else { //Completed Rides
          rideResponse.setPickedUpAt(DateUtils.getDateInString(ride.getPickedupAt(), new Date()));
          rideResponse.setCompletedAt(DateUtils.getDateInString(ride.getCompletedAt(), new Date()));
          driverAppResponse.getCompleted().add(rideResponse);
        }
      }
    }

    return driverAppResponse;
  }
}
