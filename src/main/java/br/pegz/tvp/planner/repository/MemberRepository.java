package br.pegz.tvp.planner.repository;

import br.pegz.tvp.planner.model.Member;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

@EnableScan
public interface MemberRepository extends PagingAndSortingRepository<Member, String> {

    Optional<Member> findByNameAndTeamId(String name, String teamId);
    Page<Member> findAllByTeamId(String teamId, Pageable pageable);
}
