package br.pegz.tvp.planner.controller;

import br.pegz.tvp.planner.repository.MemberRepository;
import br.pegz.tvp.planner.service.VacationService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VacationController {

    private VacationService vacationService;

    public VacationController(VacationService vacationService) {
        this.vacationService = vacationService;
    }
}
