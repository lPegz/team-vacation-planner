package br.pegz.tvp.entity;

import br.pegz.tvp.entity.enums.Status;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;
import java.time.Year;

@Data
public class Vacation {
    @Id
    private final String uid;
    private final Year yearReference;
    private final Status vacationStatus;
    private final LocalDate startDate;
    private final LocalDate endDate;
}
