package com.scheduler.app.smartshift.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Alexander Shakhov.
 *
 * User: alexandershakhov
 *
 * Date: 15 Сентябрь 2018
 *
 * Time: 20:46
 * */
@Data
@Entity
public class Position {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  @Column(name = "id", updatable = false, nullable = false)
  @JsonProperty("position_id")
  private Long id;

  @ManyToMany(mappedBy = "positions")
  private List<Employee> employees;

  @JsonProperty("created_at")
  private String createdAt;

  @JsonProperty("updated_at")
  private String updatedAt;
}
