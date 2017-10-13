package com.youplus.core.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by siva on 12/10/17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DriverSelectRequest {
  private Integer requestId;
  private Integer driverId;

  public DriverSelectRequest() {
  }

  public DriverSelectRequest(Integer requestId, Integer driverId) {
    this.requestId = requestId;
    this.driverId = driverId;
  }

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
