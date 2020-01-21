package br.pegz.tvp.repository;

import br.pegz.tvp.model.Vacation;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VacationRepository extends MongoRepository<Vacation, String>{
}
