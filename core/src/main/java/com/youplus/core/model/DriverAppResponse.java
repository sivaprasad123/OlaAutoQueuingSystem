package com.youplus.core.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by siva on 12/10/17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DriverAppResponse {

  public DriverAppResponse() {}

  private List<RideResponse> waiting = new ArrayList<>();
  private List<RideResponse> onGoing = new ArrayList<>();
  private List<RideResponse> completed = new ArrayList<>();

  public List<RideResponse> getWaiting() {
    return waiting;
  }

  public void setWaiting(List<RideResponse> waiting) {
    this.waiting = waiting;
  }

  public List<RideResponse> getOnGoing() {
    return onGoing;
  }

  public void setOnGoing(List<RideResponse> onGoing) {
    this.onGoing = onGoing;
  }

  public List<RideResponse> getCompleted() {
    return completed;
  }

  public void setCompleted(List<RideResponse> completed) {
    this.completed = completed;
  }
}
