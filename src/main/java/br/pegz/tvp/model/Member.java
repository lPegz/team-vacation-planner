package br.pegz.tvp.model;

import br.pegz.tvp.model.enums.Impact;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;
import org.springframework.data.annotation.Id;

import java.util.Set;

@Value
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class Member {
    @Id
    private final String uid;
    private final String name;
    private final String role;
    private final Impact impact;
    private final Set<Vacation> vacations;

}
