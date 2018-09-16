package com.scheduler.app.smartshift.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Alexander Shakhov.
 *
 * <p>User: alexandershakhov
 *
 * <p>Date: 15 Сентябрь 2018
 *
 * <p>Time: 20:32
 */
@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Employee {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  @Column(name = "id", updatable = false, nullable = false)
  private Long id;

  @JsonProperty("employee_code")
  private String employeeCode;

  @JsonProperty("first_name")
  private String firstName;

  @JsonProperty("middle_name")
  private String middleName;

  @JsonProperty("last_name")
  private String lastName;

  @JsonProperty("hours_preferred")
  private Long hoursPreferred;

  @JsonProperty("hours_max")
  private Long hoursMax;

  @JsonProperty("hourly_rate")
  private Long hourlyRate;

  @ManyToMany
  @JoinTable(
      name = "employee_position",
      joinColumns = @JoinColumn(name = "employee_id"),
      inverseJoinColumns = @JoinColumn(name = "position_id"))
  @JsonProperty("positions")
  private Set<Position> positions;

  @ManyToOne(
      cascade = {CascadeType.REFRESH, CascadeType.DETACH, CascadeType.PERSIST, CascadeType.MERGE})
  @JsonProperty("location")
  private Location location;

  @JsonProperty("created_at")
  private String createdAt;

  @JsonProperty("updated_at")
  private String updatedAt;
}
