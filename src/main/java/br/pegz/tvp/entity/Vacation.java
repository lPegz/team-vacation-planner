package br.pegz.tvp.entity;

import br.pegz.tvp.entity.enums.Status;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Setter
@Getter
public class Vacation {

    @Id
    private String uid;
    private LocalDateTime yearReference;
    private Status vacationStatus;

    public Vacation() {
        //default for JPA
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("uid", uid)
                .append("yearReference", yearReference)
                .append("vacationStatus", vacationStatus)
                .toString();
    }
}
