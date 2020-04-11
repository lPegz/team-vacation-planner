package br.pegz.tvp.planner.repository;

import br.pegz.tvp.planner.model.Member;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface MemberRepository extends PagingAndSortingRepository<Member, String> {

}
