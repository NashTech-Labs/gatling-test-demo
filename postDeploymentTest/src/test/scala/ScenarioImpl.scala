import io.gatling.core.structure._
import io.gatling.core.Predef._

object ScenarioImpl {

def addReportScenarioBuilder: ScenarioBuilder =
  scenario("Add report as an admin")
    .exec(Scenario.loginAsAdmin).pause(5)
    .exec(Scenario.addReport).pause(5)
}

