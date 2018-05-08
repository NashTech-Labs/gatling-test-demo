import io.gatling.core.Predef._
import io.gatling.core.scenario.Simulation

class AddProjectReport extends Simulation with TestSetUp {

setUp(
  ScenarioImpl.addReportScenarioBuilder.inject(rampUsers(1000) over 10).protocols(httpConf)
  ).assertions(
  global.successfulRequests.percent.gte(100)
)
}
