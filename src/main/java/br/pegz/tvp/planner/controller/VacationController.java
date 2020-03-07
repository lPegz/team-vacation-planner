package br.pegz.tvp.planner.controller;

import br.pegz.tvp.planner.model.MemberValue;
import br.pegz.tvp.planner.model.VacationRequest;
import br.pegz.tvp.planner.model.VacationValue;
import br.pegz.tvp.planner.service.VacationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class VacationController {

    private VacationService vacationService;

    public VacationController(VacationService vacationService) {
        this.vacationService = vacationService;
    }

    @PostMapping("/vacation/{teamUid}/{memberId}")
    public ResponseEntity<VacationValue> addNewVacation(
            @RequestBody VacationRequest vacationRequest, @RequestParam String teamUid, @RequestParam String memberId) {

        VacationValue vacationValue = vacationService.
                addNewVacation(new MemberValue(teamUid, memberId), vacationRequest);
        return ResponseEntity.ok(vacationValue);

    }

}
