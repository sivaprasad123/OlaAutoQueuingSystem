package com.youplus.core.service;

import static java.util.concurrent.TimeUnit.SECONDS;

import com.youplus.core.dao.RidesRepository;
import com.youplus.core.entity.Ride;
import com.youplus.core.type.RideStatus;
import java.util.Date;
import java.util.concurrent.Executors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by siva on 13/10/17.
 */
@Service
public class ScheduleService {

  @Autowired
  private RidesRepository ridesRepository;

  public void scheduleRideComplete(final Integer requestId) {
    Executors.newSingleThreadScheduledExecutor().schedule(new Runnable() {
      public void run() {
        try {
          Ride ride = ridesRepository.findById(requestId);
          if (null != ride) {
            System.out.println(ride.getId());
            ride.setStatus(RideStatus.COMPLETED.getId());
            ride.setCompletedAt(new Date());
            ridesRepository.save(ride);
            System.out.println("Ride marked as completed for request Id " + requestId);
          }
        } catch (Exception e) {
          System.err.println("Error while marking ride complete " + e.getMessage());
        }
      }
    }, 2, SECONDS);
  }
}
