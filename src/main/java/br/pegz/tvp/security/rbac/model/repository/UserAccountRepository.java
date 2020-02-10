package br.pegz.tvp.security.rbac.model.repository;

import br.pegz.tvp.security.rbac.model.UserAccount;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserAccountRepository extends MongoRepository<UserAccount, String> {

    Optional<UserAccount> findByTeamNameAndUsername(String teamName, String username);

}
