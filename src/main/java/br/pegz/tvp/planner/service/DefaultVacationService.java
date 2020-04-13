package br.pegz.tvp.planner.service;

import br.pegz.tvp.planner.model.*;
import br.pegz.tvp.planner.model.enums.Status;
import br.pegz.tvp.planner.repository.MemberRepository;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Year;
import java.util.UUID;

@Component
public class DefaultVacationService implements VacationService {

    private final MemberRepository memberRepository;

    public DefaultVacationService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public VacationValue addNewVacation(MemberValue member, VacationRequest vacationRequest) {
        Vacation vacation = new Vacation(UUID.randomUUID().toString(), Year.from(vacationRequest.getStartDate()),
                "0", Status.WAITING_APPROVAL, vacationRequest.getStartDate(), vacationRequest.getEndDate());
        Member foundMember = memberRepository.findByNameAndTeamId(member.getName(), member.getTeamId())
                .orElseThrow(IllegalArgumentException::new);
        foundMember.getVacations().add(vacation);
        memberRepository.save(foundMember);
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
