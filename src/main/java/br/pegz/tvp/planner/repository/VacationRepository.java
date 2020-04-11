package br.pegz.tvp.planner.repository;

import br.pegz.tvp.planner.model.Vacation;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface VacationRepository extends PagingAndSortingRepository<Vacation, String> {
}
