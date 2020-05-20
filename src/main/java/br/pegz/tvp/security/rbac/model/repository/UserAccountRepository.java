package br.pegz.tvp.security.rbac.model.repository;

import br.pegz.tvp.security.rbac.model.UserAccount;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

@EnableScan
public interface UserAccountRepository extends PagingAndSortingRepository<UserAccount, String> {

    Optional<UserAccount> findByTeamNameAndUsername(String teamName, String username);

}
