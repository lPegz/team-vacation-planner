package br.pegz.tvp.planner.repository;

import br.pegz.tvp.planner.model.Member;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MemberRepository extends MongoRepository<Member, String> {

}
