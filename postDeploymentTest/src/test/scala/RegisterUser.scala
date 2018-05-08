
import io.gatling.core.Predef._
import io.gatling.core.structure._
import io.gatling.http.Predef._
import io.gatling.http.protocol.HttpProtocolBuilder

class RegisterUser extends Simulation {

  val httpConf: HttpProtocolBuilder = http
    .baseURL("Base URL")

  val numbers = Iterator.continually(Map("num" -> scala.util.Random.nextInt(Int.MaxValue)))

  val registerUser: ScenarioBuilder = scenario("Register User")
    .feed(numbers)
    .exec(
      http("Registration Request")
        .post("Registration url")
        .body(StringBody(RequestTemplate.registerRequest)).asJSON
        .check(jsonPath("$.status").is("Expected status"))
    )

  setUp(registerUser.inject(atOnceUsers(50)).protocols(httpConf)).assertions(
    global.responseTime.max.lt(50),
    global.successfulRequests.percent.gte(100)
  )
}
