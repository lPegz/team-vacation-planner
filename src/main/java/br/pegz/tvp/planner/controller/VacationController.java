package br.pegz.tvp.planner.controller;

import br.pegz.tvp.planner.model.MemberValue;
import br.pegz.tvp.planner.model.VacationRequest;
import br.pegz.tvp.planner.model.VacationValue;
import br.pegz.tvp.planner.service.VacationService;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class VacationController {

    private VacationService vacationService;

    public VacationController(VacationService vacationService) {
        this.vacationService = vacationService;
    }

    @PostMapping("/{teamUid}/{memberId}/vacation")
    public ResponseEntity<VacationValue> addNewVacation(
            @RequestBody VacationRequest vacationRequest, @PathVariable String teamUid,
            @PathVariable String memberId) throws ChangeSetPersister.NotFoundException {
        VacationValue vacationValue = vacationService.
                addNewVacation(new MemberValue(teamUid, memberId), vacationRequest);
        return ResponseEntity.ok(vacationValue);

    }

}
