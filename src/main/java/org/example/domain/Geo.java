package org.example.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Embeddable
@Data
@EqualsAndHashCode
public class Geo implements Serializable {
  private static final long serialVersionUID = 3800754098778455878L;

  @Column
  private String lng;

  @Column
  private String lat;
}
