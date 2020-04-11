package br.pegz.tvp.integrationtest;

import br.pegz.tvp.TeamVacationPlannerApplication;
import cloud.localstack.docker.LocalstackDockerExtension;
import cloud.localstack.docker.annotation.LocalstackDockerProperties;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(LocalstackDockerExtension.class)
@LocalstackDockerProperties(services = {"s3", "dynamoDB"})
class SpringContextIT {
    TeamVacationPlannerApplication teamVacationPlannerApplication;

    @Test
    void contextLoads() {

    }
}
