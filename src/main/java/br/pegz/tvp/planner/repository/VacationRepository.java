package br.pegz.tvp.planner.repository;

import br.pegz.tvp.planner.model.Vacation;

public interface VacationRepository {
    Vacation save(Vacation model);
}
