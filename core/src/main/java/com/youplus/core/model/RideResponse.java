package com.youplus.core.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by siva on 12/10/17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class RideResponse {

  public RideResponse() {}

  private Integer requestId;
  private Integer customerId;
  private String requestedAt;
  private String pickedUpAt;
  private String completedAt;

  public Integer getRequestId() {
    return requestId;
  }

  public void setRequestId(Integer requestId) {
    this.requestId = requestId;
  }

  public Integer getCustomerId() {
    return customerId;
  }

  public void setCustomerId(Integer customerId) {
    this.customerId = customerId;
  }

  public String getRequestedAt() {
    return requestedAt;
  }

  public void setRequestedAt(String requestedAt) {
    this.requestedAt = requestedAt;
  }

  public String getPickedUpAt() {
    return pickedUpAt;
  }

  public void setPickedUpAt(String pickedUpAt) {
    this.pickedUpAt = pickedUpAt;
  }

  public String getCompletedAt() {
    return completedAt;
  }

  public void setCompletedAt(String completedAt) {
    this.completedAt = completedAt;
  }
}
