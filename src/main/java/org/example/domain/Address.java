package org.example.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Embeddable
@Data
@EqualsAndHashCode
public class Address implements Serializable {
  private static final long serialVersionUID = 3708754098108455848L;

  @Column
  private String zipcode;

  @Embedded
  private Geo geo = new Geo();

  @Column
  private String suite;

  @Column
  private String city;

  @Column
  private String street;
}
