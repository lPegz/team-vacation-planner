package br.pegz.tvp.planner.repository;

import br.pegz.tvp.planner.model.Vacation;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VacationRepository extends MongoRepository<Vacation, String>{
}
