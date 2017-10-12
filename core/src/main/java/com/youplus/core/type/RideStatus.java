package com.youplus.core.type;

/**
 * Created by siva on 11/10/17.
 */
public enum RideStatus {

  WAITING((byte) 1, "Waiting"), ONGOING((byte) 2, "Ongoing"), COMPLETED((byte) 3, "Completed");

  private Byte id;
  private String displayName;

  private RideStatus(Byte id, String displayName) {
    this.id = id;
    this.displayName = displayName;
  }

  public String getDisplayName() {
    return displayName;
  }

  public Byte getId() {
    return id;
  }

  public static String getDisplayName(Byte id) {
    for (RideStatus rideStatus : RideStatus.values()) {
      if (rideStatus.getId().intValue() == id.intValue()) {
        return rideStatus.getDisplayName();
      }
    }

    return null;
  }
}
