package br.pegz.tvp.planner.model;

import br.pegz.tvp.planner.model.enums.Impact;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@Document
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
