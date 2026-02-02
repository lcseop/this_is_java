package com.mjc813;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class PatientOfAnimal {
    private String name;
    private String id;
    private Date dayOfHospitalize;
    private Date dayOfDischarge;
    private int countOfVisitation;
}
