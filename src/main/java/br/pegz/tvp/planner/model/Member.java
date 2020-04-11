package br.pegz.tvp.planner.model;

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
    private final String teamId;
    private final String name;
    private final Set<Vacation> vacations;
}
