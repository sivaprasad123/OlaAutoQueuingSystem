package com.youplus.core.entity;

/**
 * Created by siva on 10/10/17.
 */

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "rides")
public class Ride {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "status")
  private Byte status;

  @Column(name = "customer_id")
  private Integer customerId;

  @Column(name = "driver_id")
  private Integer driverId;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "requested_at")
  private Date requestedAt;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "pickedup_at")
  private Date pickedupAt;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "completed_at")
  private Date completedAt;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Byte getStatus() {
    return status;
  }

  public void setStatus(Byte status) {
    this.status = status;
  }

  public Integer getCustomerId() {
    return customerId;
  }

  public void setCustomerId(Integer customerId) {
    this.customerId = customerId;
  }

  public Integer getDriverId() {
    return driverId;
  }

  public void setDriverId(Integer driverId) {
    this.driverId = driverId;
  }

  public Date getRequestedAt() {
    return requestedAt;
  }

  public void setRequestedAt(Date requestedAt) {
    this.requestedAt = requestedAt;
  }

  public Date getPickedupAt() {
    return pickedupAt;
  }

  public void setPickedupAt(Date pickedupAt) {
    this.pickedupAt = pickedupAt;
  }

  public Date getCompletedAt() {
    return completedAt;
  }

  public void setCompletedAt(Date completedAt) {
    this.completedAt = completedAt;
  }
}

