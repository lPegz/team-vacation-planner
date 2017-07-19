package br.pegz.tvp.entity;

import br.pegz.tvp.entity.enums.Impact;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.Set;

@Setter
@Getter
public class Member {

    @Id
    private String uid;
    private String name;
    private String role;
    private Impact impact;
    private Set<Vacation> vacations;

    public Member() {
        //default for JPA
    }


}
