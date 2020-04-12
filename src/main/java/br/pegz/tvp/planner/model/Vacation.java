package br.pegz.tvp.planner.model;

import br.pegz.tvp.planner.model.enums.Status;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.time.LocalDate;
import java.time.Year;

@Value
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class Vacation {
    String uid;
    Year yearReference;
    String turnReference;
    Status vacationStatus;
    LocalDate startDate;
    LocalDate endDate;
}
