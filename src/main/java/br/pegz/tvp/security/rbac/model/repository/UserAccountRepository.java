package br.pegz.tvp.security.rbac.model.repository;

import br.pegz.tvp.security.rbac.model.UserAccount;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserAccountRepository extends MongoRepository<UserAccount, String> {

}
