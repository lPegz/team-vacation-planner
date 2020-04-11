package br.pegz.tvp.it

import br.pegz.tvp.TeamVacationPlannerApplication
import org.testcontainers.containers.localstack.LocalStackContainer
import spock.lang.Specification

import static org.testcontainers.containers.localstack.LocalStackContainer.Service.DYNAMODB

class TeamVacationPlannerITSpecification extends Specification {

    LocalStackContainer localstack = new LocalStackContainer().withServices(DYNAMODB)

    TeamVacationPlannerApplication teamVacationPlannerApplication

    def "load application context"() {
        expect:
        TeamVacationPlannerApplication.main()
    }
}
