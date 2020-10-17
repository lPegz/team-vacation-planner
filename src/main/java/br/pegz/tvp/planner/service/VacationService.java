package br.pegz.tvp.planner.service;

import br.pegz.tvp.planner.model.MemberValue;
import br.pegz.tvp.planner.model.VacationRequest;
import br.pegz.tvp.planner.model.VacationValue;

import java.time.LocalDate;
import java.util.Collection;

public interface VacationService {
    VacationValue addNewVacation(MemberValue member, VacationRequest vacationRequest);
    VacationValue updateVacation(MemberValue member, VacationRequest vacationRequest);
    void removeVacation(VacationValue vacation);
    Collection<VacationValue> listVacationPerPeriod(LocalDate startPeriod, LocalDate endPeriod, int pageSize, int currentPage);
}
