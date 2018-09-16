package com.scheduler.app.smartshift.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Alexander Shakhov.
 *
 * <p>User: alexandershakhov
 *
 * <p>Date: 15 Сентябрь 2018
 *
 * <p>Time: 11:24
 */
@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Role implements GrantedAuthority {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  @Column(name = "id", updatable = false, nullable = false)
  private Long id;

  private String authority;

  @ManyToMany(mappedBy = "authorities")
  private List<Account> accounts;
}
