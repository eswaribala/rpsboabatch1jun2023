package com.boa.customerapi.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name="Individual")
public class Individual extends  Customer{
    @Enumerated(EnumType.STRING)
    @Column(name="Gender")
    private Gender gender;
    @Column(name="DOB")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dob;
}
