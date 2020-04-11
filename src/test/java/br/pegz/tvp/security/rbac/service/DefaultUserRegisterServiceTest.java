package br.pegz.tvp.security.rbac.service;

import br.pegz.tvp.security.rbac.model.UserAccount;
import br.pegz.tvp.security.rbac.model.repository.UserAccountRepository;
import br.pegz.tvp.security.rbac.model.value.UserAccountValue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DefaultUserRegisterServiceTest {

    @Mock
    private UserAccountRepository mockRepository;

    @InjectMocks
    private DefaultUserRegisterService defaultUserRegisterService;


    @Test
    void whenRegisterNewUserSuccess() {
        UserAccount mockUserAccount = mock(UserAccount.class);
        when(mockUserAccount.getUsername()).thenReturn("wile.e.coyote");
        when(mockUserAccount.getTeamName()).thenReturn("Carnivorous Vulgaris");
        when(mockRepository.save(any(UserAccount.class))).thenReturn(mockUserAccount);
        UserAccountValue validUserAccountVRequest = new UserAccountValue("Carnivorous Vulgaris",
                "wile.e.coyote", "wcoyote@acme.com", "i<3rrunner");
        defaultUserRegisterService.registerTenant(validUserAccountVRequest);
        verify(mockRepository, atMostOnce()).save(any(UserAccount.class));
    }

    @Test
    void whenRegisterAccountThrowIllegalArgument() {
        assertThrows(IllegalArgumentException.class, () -> {
            UserAccountValue validUserAccountVRequest = new UserAccountValue("Carnivorous Vulgaris",
                    "wile.e.coyote", "wcoyote@acme.com", null);
            defaultUserRegisterService.registerTenant(validUserAccountVRequest);
        });
    }

}