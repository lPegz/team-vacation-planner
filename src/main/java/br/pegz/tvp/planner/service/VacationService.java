package br.pegz.tvp.planner.service;

import br.pegz.tvp.planner.model.MemberValue;
import br.pegz.tvp.planner.model.VacationRequest;
import br.pegz.tvp.planner.model.VacationValue;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Page;

import java.time.LocalDate;

public interface VacationService {
    VacationValue addNewVacation(MemberValue member, VacationRequest vacationRequest) throws ChangeSetPersister.NotFoundException;
    VacationValue updateVacation(MemberValue member, VacationRequest vacationRequest);
    void removeVacation(VacationValue vacation);
    Page<VacationValue> listVacationPerPeriod(LocalDate startPeriod, LocalDate endPeriod, int pageSize, int currentPage);
}
