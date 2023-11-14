package org.example.essence.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Appointment {
    private Integer id;
    private Integer iduser;
    private Date date;
    private Date time;
    private String location;
    private String subject;
}
