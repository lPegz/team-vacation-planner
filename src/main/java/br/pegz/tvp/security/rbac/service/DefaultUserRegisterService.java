package br.pegz.tvp.security.rbac.service;


import br.pegz.tvp.security.password.PasswordStorage;
import br.pegz.tvp.security.rbac.model.UserAccount;
import br.pegz.tvp.security.rbac.model.repository.UserAccountRepository;
import br.pegz.tvp.security.rbac.model.value.ConfirmationValue;
import br.pegz.tvp.security.rbac.model.value.UserAccountValue;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class DefaultUserRegisterService implements UserRegisterService {

    private final UserAccountRepository userAccountRepository;

    @Override
    public ConfirmationValue registerNewUser(UserAccountValue userAccountValue) {
        UserAccount userAccount = getUserAccount(userAccountValue);
        UserAccount created = userAccountRepository.save(userAccount);
        return new ConfirmationValue(created.getUsername(), created.getTeamName());
    }

    private UserAccount getUserAccount(UserAccountValue userAccountValue) throws IllegalArgumentException {
        UserAccount userAccount;
        String tenantId = UUID.nameUUIDFromBytes(userAccountValue.getTeamName().getBytes()).toString();
        try {
            userAccount = UserAccount.builder()
                    .tenantId(tenantId)
                    .teamName(userAccountValue.getTeamName())
                    .password(PasswordStorage.createHash(userAccountValue.getPassword()))
                    .accountNonExpired(true)
                    .accountNonLocked(true)
                    .credentialsNonExpired(true)
                    .build();
        } catch (PasswordStorage.CannotPerformOperationException e) {
            log.error("Password could not be hashed, please advise", e);
            throw new IllegalArgumentException("Invalid password", e);
        }
        return userAccount;
    }
}
