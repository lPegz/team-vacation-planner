package br.pegz.tvp.entity;

import br.pegz.tvp.entity.enums.Status;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;
import java.time.Year;

@Value
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class Vacation {
    @Id
    private final String uid;
    private final Year yearReference;
    private final Status vacationStatus;
    private final LocalDate startDate;
    private final LocalDate endDate;
}
