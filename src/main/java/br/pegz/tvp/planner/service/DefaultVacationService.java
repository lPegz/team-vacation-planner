package br.pegz.tvp.planner.service;

import br.pegz.tvp.planner.model.Member;
import br.pegz.tvp.planner.model.MemberValue;
import br.pegz.tvp.planner.model.Vacation;
import br.pegz.tvp.planner.model.VacationRequest;
import br.pegz.tvp.planner.model.VacationValue;
import br.pegz.tvp.planner.model.enums.Status;
import br.pegz.tvp.planner.repository.MemberRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Year;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
    public void nullVacation(VacationValue vacationValue) {
        Member member = memberRepository.findByNameAndTeamId(vacationValue.getMemberName(), vacationValue.getTeam())
                .orElseThrow(IllegalArgumentException::new);
        member.getVacations()
                .removeIf(vacation -> vacation.getStartDate().equals(vacationValue.getStartDate()));
    }

    @Override
    public Page<VacationValue> listVacationPerPeriod(String teamId, LocalDate startPeriod, LocalDate endPeriod, int pageSize, int currentPage) {
        Set<Member> team = memberRepository.findAllByTeamId(teamId, Pageable.unpaged()).toSet();
        Stream<VacationValue> vacationValueStream = team.stream()
                .flatMap(member -> member.getVacations().stream()
                        .map(vacation -> new VacationValue(member.getName(), teamId, vacation.getStartDate(), vacation.getEndDate()))
                );
        long total = vacationValueStream.count();
        return new PageImpl<VacationValue>(vacationValueStream
                .filter(vacation -> vacation.getStartDate().isAfter(startPeriod) && vacation.getEndDate().isBefore(endPeriod))
                .collect(Collectors.toList()), PageRequest.of(currentPage, pageSize, Sort.by("startDate")), total);
    }
}
