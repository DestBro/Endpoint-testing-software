package org.example.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Embeddable
@Data
@EqualsAndHashCode
public class Company implements Serializable {
  private static final long serialVersionUID = 3800654098708457748L;

  @Column
  private String bs;

  @Column
  private String catchPhrase;

  @Column
  private String name;
}
