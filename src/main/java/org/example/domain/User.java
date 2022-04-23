package org.example.domain;

import java.io.Serializable;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "users")
@Data
@EqualsAndHashCode
public class User implements Serializable {
  private static final long serialVersionUID = 3800654098708455848L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column
  private String website;

  @Embedded
  @AttributeOverrides({
      @AttributeOverride(name = "zipcode",
          column = @Column(name = "address_zipcode")),
      @AttributeOverride(name = "suite",
          column = @Column(name = "address_suite")),
      @AttributeOverride(name = "city",
          column = @Column(name = "address_city")),
      @AttributeOverride(name = "street",
          column = @Column(name = "address_street")),
      @AttributeOverride(name = "geo.lng",
          column = @Column(name = "address_geo_lng")),
      @AttributeOverride(name = "geo.lat",
          column = @Column(name = "address_geo_lat"))
  })
  private Address address = new Address();

  @Column
  private String phone;

  @Column
  private String name;

  @Embedded
  @AttributeOverrides({
      @AttributeOverride(name = "name",
          column = @Column(name = "company_name")),
      @AttributeOverride(name = "catchPhrase",
          column = @Column(name = "company_catch_phrase")),
      @AttributeOverride(name = "bs",
          column = @Column(name = "company_bs"))
  })
  private Company company = new Company();

  @Column
  private String email;

  @Column
  private String username;
}

