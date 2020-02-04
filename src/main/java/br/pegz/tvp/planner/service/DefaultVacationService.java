package br.pegz.tvp.planner.service;

import br.pegz.tvp.planner.model.MemberValue;
import br.pegz.tvp.planner.model.Vacation;
import br.pegz.tvp.planner.model.VacationRequest;
import br.pegz.tvp.planner.model.VacationValue;
import br.pegz.tvp.planner.model.enums.Status;
import br.pegz.tvp.planner.repository.VacationRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Year;
import java.util.UUID;

@Component
public class DefaultVacationService implements VacationService {

    private final VacationRepository vacationRepository;

    public DefaultVacationService(VacationRepository vacationRepository) {
        this.vacationRepository = vacationRepository;
    }

    @Override
    public VacationValue addNewVacation(MemberValue member, VacationRequest vacationRequest) {
        Vacation vacation = new Vacation(UUID.randomUUID().toString(), Year.from(vacationRequest.getStartDate()),
                "0", Status.WAITING_APPROVAL, vacationRequest.getStartDate(), vacationRequest.getEndDate());
        vacationRepository.save(vacation);
        return new VacationValue(member.getName(), member.getTeamId(), vacationRequest.getStartDate(), vacationRequest.getEndDate());
    }

    @Override
    public VacationValue updateVacation(MemberValue member, VacationRequest vacationRequest) {
        return null;
    }

    @Override
    public void removeVacation(VacationValue vacation) {

    }

    @Override
    public Page<VacationValue> listVacationPerPeriod(LocalDate startPeriod, LocalDate endPeriod, int pageSize, int currentPage) {
        return null;
    }
}
