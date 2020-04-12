package br.pegz.tvp.planner.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.time.LocalDate;

@Value
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class VacationRequest {
    String memberName;
    String memberEmail;
    LocalDate startDate;
    LocalDate endDate;
}
