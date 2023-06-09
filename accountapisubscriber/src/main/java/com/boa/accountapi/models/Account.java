package com.boa.accountapi.models;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name="Account")
@Inheritance(strategy = InheritanceType.JOINED)
@SuperBuilder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Account_No")
    @ApiModelProperty(hidden = true)
	private long accountNo;
    @Column(name="Running_Total")
    private long runningTotal;
    @Column(name="Opening_Date")
    private LocalDate openingDate;
}
