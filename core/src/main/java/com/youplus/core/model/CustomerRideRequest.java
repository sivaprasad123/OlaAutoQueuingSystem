package com.youplus.core.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by siva on 11/10/17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomerRideRequest {

  private Integer customerId;

  public CustomerRideRequest(){
  }
  public Integer getCustomerId() {
    return customerId;
  }

  public void setCustomerId(Integer customerId) {
    this.customerId = customerId;
  }
}
