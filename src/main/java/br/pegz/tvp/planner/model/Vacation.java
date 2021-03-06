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
    private final String uid;
    private final Year yearReference;
    private final String turnReference;
    private final Status vacationStatus;
    private final LocalDate startDate;
    private final LocalDate endDate;
}
