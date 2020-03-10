package br.pegz.tvp.it

import br.pegz.tvp.TeamVacationPlannerApplication
import spock.lang.Specification

class TeamVacationPlannerITSpecification extends Specification {

    TeamVacationPlannerApplication teamVacationPlannerApplication

    def "load application context"() {
        expect:
        TeamVacationPlannerApplication.main()
    }
}
