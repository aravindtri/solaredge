package com.automate.solarevcharging.solar.dto;

import java.time.ZonedDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Entity
@Table(name = "solar_state")
public class SolarStateDTO {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  @Column
  private double power;
  @Column
  private ZonedDateTime updatedTime;
  @Column
  private double cumulativePowerForToday;

  public double getPower() {
    return power;
  }

  public void setPower(double power) {
    this.power = power;
  }

  public ZonedDateTime getUpdatedTime() {
    return updatedTime;
  }

  public void setUpdatedTime(ZonedDateTime updatedTime) {
    this.updatedTime = updatedTime;
  }

  public double getCumulativePowerForToday() {
    return cumulativePowerForToday;
  }

  public void setCumulativePowerForToday(double cumulativePowerForToday) {
    this.cumulativePowerForToday = cumulativePowerForToday;
  }

  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this);
  }
}
