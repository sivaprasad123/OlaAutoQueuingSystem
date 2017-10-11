package com.youplus.core.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by siva on 11/10/17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DashboardResponse {

  public DashboardResponse() {
  }

  private Integer requestId;
  private Integer CustomerId;
  private String timeElapsed;
  private String status;
  private Integer driverId;

  public Integer getRequestId() {
    return requestId;
  }

  public void setRequestId(Integer requestId) {
    this.requestId = requestId;
  }

  public Integer getCustomerId() {
    return CustomerId;
  }

  public void setCustomerId(Integer customerId) {
    CustomerId = customerId;
  }

  public String getTimeElapsed() {
    return timeElapsed;
  }

  public void setTimeElapsed(String timeElapsed) {
    this.timeElapsed = timeElapsed;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public Integer getDriverId() {
    return driverId;
  }

  public void setDriverId(Integer driverId) {
    this.driverId = driverId;
  }
}
