import io.gatling.core.Predef._
import io.gatling.core.scenario.Simulation
import io.gatling.core.structure.ScenarioBuilder
import io.gatling.http.Predef._

class AddReports extends Simulation with TestSetUp {

  val addReport : ScenarioBuilder = scenario("User login")
    .exec(
      http("Login Request")
        .put("Add reports url")
        .formParamSeq(
          Seq(
            ("projectName","project name"),
              ("moduleName","module name"),
                ("registrationKey","registration key"),
                  ("organisation","organisation name")
          ))
        .bodyPart(RawFileBodyPart("file", "file to be added")
        .transferEncoding("binary")).asMultipartForm
        .check(jsonPath("$.status").is("Expected status"))
    )

  setUp(addReport.inject(atOnceUsers(1)).protocols(httpConf)).assertions(
    global.responseTime.max.gt(100),
    global.successfulRequests.percent.gt(95)
  )

}
