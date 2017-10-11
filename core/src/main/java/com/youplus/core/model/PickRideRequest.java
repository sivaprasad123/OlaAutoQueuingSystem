package com.youplus.core.model;

/**
 * Created by siva on 11/10/17.
 */
public class PickRideRequest {

  public PickRideRequest() {
  }

  private Integer requestId;

  private Integer driverId;

  public Integer getRequestId() {
    return requestId;
  }

  public void setRequestId(Integer requestId) {
    this.requestId = requestId;
  }

  public Integer getDriverId() {
    return driverId;
  }

  public void setDriverId(Integer driverId) {
    this.driverId = driverId;
  }
}
