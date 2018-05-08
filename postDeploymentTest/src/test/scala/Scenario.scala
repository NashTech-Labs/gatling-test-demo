import io.gatling.core.Predef._
import io.gatling.http.Predef._

object Scenario extends TestSetUp {

  val loginAsAdmin =  http("Login Request")
    .post("login url path")
    .body(StringBody(RequestTemplate.loginTemplate)).asJSON
    .check(jsonPath("$..registrationKey").saveAs("accessKey"))
      .check(status.is(200))

val addReport =  http("Login Request")
  .put("add reports url path")
  .formParamSeq(
    Seq(
      ("projectName","project name"),
      ("moduleName","module name"),
      ("registrationKey","${accessKey}"),
      ("organisation","organisation name")
    ))
  .bodyPart(RawFileBodyPart("file", "file to be added")
    .transferEncoding("binary")).asMultipartForm
  .check(jsonPath("$.status").is("Expected status"))

}
