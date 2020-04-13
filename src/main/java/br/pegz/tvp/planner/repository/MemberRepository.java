package br.pegz.tvp.planner.repository;

import br.pegz.tvp.planner.model.Member;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface MemberRepository extends PagingAndSortingRepository<Member, String> {

    Optional<Member> findByNameAndTeamId(String name, String teamId);

}
