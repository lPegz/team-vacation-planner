package br.pegz.tvp.security.rbac.service;


import br.pegz.tvp.security.jwt.util.JWTUtil;
import br.pegz.tvp.security.login.exception.UserNotFoundException;
import br.pegz.tvp.security.login.exception.WrongPasswordException;
import br.pegz.tvp.security.login.model.AuthenticationRequest;
import br.pegz.tvp.security.login.model.AuthenticationResponse;
import br.pegz.tvp.security.password.PasswordStorage;
import br.pegz.tvp.security.rbac.model.UserAccount;
import br.pegz.tvp.security.rbac.model.UserAccountId;
import br.pegz.tvp.security.rbac.model.repository.UserAccountRepository;
import br.pegz.tvp.security.rbac.model.value.ConfirmationValue;
import br.pegz.tvp.security.rbac.model.value.UserAccountValue;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.nio.charset.Charset;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class DefaultUserRegisterService implements UserRegisterService, UserLoginService {

    private final UserAccountRepository userAccountRepository;

    private final JWTUtil jwtUtil;

    @Override
    public ConfirmationValue registerTenant(UserAccountValue userAccountValue) {
        UserAccount userAccount = getUserAccount(userAccountValue);
        UserAccount created = userAccountRepository.save(userAccount);
        return new ConfirmationValue(created.getUsername(), created.getTeamId());
    }

    private UserAccount getUserAccount(UserAccountValue userAccountValue) throws IllegalArgumentException {
        UserAccount userAccount;
        try {
            String passwordHash = PasswordStorage.createHash(userAccountValue.getPassword());
            userAccount = UserAccount.builder()
                    .userAccountId(new UserAccountId(userAccountValue.getTeamName(), userAccountValue.getUsername()))
                    .passwordSalt(passwordHash.getBytes(Charset.defaultCharset()))
                    .password(passwordHash)
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

    public Optional<UserAccount> loadUserByUsernameAndTeam(String username, String teamName) {
        return userAccountRepository.findByTeamNameAndUsername(teamName, username);
    }

    @Deprecated
    @Override
    public UserAccount loadUserByUsername(String username) throws UsernameNotFoundException {
        int splitterIndex = username.indexOf("@");
        String teamName =  username.substring(splitterIndex);
        String cleanUsername = username.substring(0, splitterIndex);
        return loadUserByUsernameAndTeam(teamName, cleanUsername)
                .orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest) throws AuthenticationException {
        UserAccount userAccount = loadUserByUsernameAndTeam(authenticationRequest.getMemberUsername(),
                authenticationRequest.getTeamName())
                .orElseThrow(UserNotFoundException::new);
        if (validatePassword(authenticationRequest.getPasswordHash(), userAccount)) {
            String jwt = jwtUtil.generateJwt(authenticationRequest.getTeamName(),
                    authenticationRequest.getMemberUsername());
            return new AuthenticationResponse(jwt);
        } else {
            throw new WrongPasswordException();
        }
    }

    private boolean validatePassword(byte[] password, UserDetails userDetails) {

        return false;
    }
}
