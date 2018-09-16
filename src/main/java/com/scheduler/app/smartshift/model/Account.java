package com.scheduler.app.smartshift.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Alexander Shakhov.
 *
 * <p>User: alexandershakhov
 *
 * <p>Date: 09 Сентябрь 2018
 *
 * <p>Time: 12:38
 */
@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Account implements UserDetails {

  @Id
  @JsonProperty("account_id")
  @Column(name = "id", updatable = false, nullable = false)
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long id;

  @JsonProperty("type")
  private Long type;

  /**
   * Returns the authorities granted to the user. Cannot return <code>null</code>.
   *
   * @return the authorities, sorted by natural key (never <code>null</code>)
   */
  @ManyToMany
  @JoinTable(
      name = "account_role",
      joinColumns = @JoinColumn(name = "account_id"),
      inverseJoinColumns = @JoinColumn(name = "role_id"))
  @JsonProperty("authorities")
  private List<Role> authorities;

  @OneToOne(cascade = {CascadeType.ALL})
  @JsonProperty("employee")
  private Employee employee;

  /**
   * Indicates when the account has been logged in last time.
   *
   * @return {@link String}
   */
  @JsonProperty("last_login")
  private String lastLogin;

  /**
   * Returns the password used to authenticate the user.
   *
   * @return the password
   */
  @JsonProperty("password")
  private String password;

  /**
   * Returns the username used to authenticate the user. Cannot return <code>null</code>.
   *
   * @return the username (never <code>null</code>)
   */
  @JsonProperty("username")
  private String username;

  /**
   * Indicates whether the user's account has expired. An expired account cannot be authenticated.
   *
   * @return <code>true</code> if the user's account is valid (ie non-expired), <code>false</code>
   *     if no longer valid (ie expired)
   */
  @JsonProperty("account_not_expired")
  private boolean accountNonExpired;

  /**
   * Indicates whether the user is locked or unlocked. A locked user cannot be authenticated.
   *
   * @return <code>true</code> if the user is not locked, <code>false</code> otherwise
   */
  @JsonProperty("account_not_locked")
  private boolean accountNonLocked;

  /**
   * Indicates whether the user's account has expired. An expired account cannot be authenticated.
   *
   * @return <code>true</code> if the user's account is valid (ie non-expired), <code>false</code>
   *     if no longer valid (ie expired)
   */
  @JsonProperty("credentials_not_expired")
  private boolean credentialsNonExpired;

  /**
   * Indicates whether the user is enabled or disabled. A disabled user cannot be authenticated.
   *
   * @return <code>true</code> if the user is enabled, <code>false</code> otherwise
   */
  @JsonProperty("enabled")
  private boolean enabled;

  /**
   * Indicates when the account has been created.
   *
   * @return {@link String}
   */
  @JsonProperty("created_at")
  private String createdAt;

  /**
   * Indicates when the account has been updated last time.
   *
   * @return {@link String}
   */
  @JsonProperty("updated_at")
  private String updatedAt;
}
