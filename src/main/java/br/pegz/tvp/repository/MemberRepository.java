package br.pegz.tvp.repository;

import br.pegz.tvp.model.Member;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MemberRepository extends MongoRepository<Member, String> {

}
