import io.gatling.core.Predef._
import io.gatling.core.scenario.Simulation
import io.gatling.core.structure.ScenarioBuilder
import io.gatling.http.Predef._


class UserLogin extends Simulation with TestSetUp {

  val userLogin: ScenarioBuilder = scenario("User login")
    .feed(feeder)
    .exec(
      http("Login Request")
        .post("Login url")
        .body(StringBody(RequestTemplate.loginTemplate)).asJSON
        .check(jsonPath("$.status").is("Expected status"))
    )

  setUp(userLogin.inject(atOnceUsers(1)).protocols(httpConf)).assertions(
    global.responseTime.max.lt(2000),
    global.successfulRequests.percent.gt(95)
  )
}

