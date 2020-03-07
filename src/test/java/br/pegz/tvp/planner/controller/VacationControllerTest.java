package br.pegz.tvp.planner.controller;

import br.pegz.tvp.planner.service.VacationService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class VacationControllerTest {

    @InjectMocks
    VacationController vacationController;

    @Mock
    VacationService vacationService;

    @Test
    void testAddNewVacation() {
        
    }
}