import io.gatling.http.Predef._
import io.gatling.core.Predef._
import io.gatling.http.protocol.HttpProtocolBuilder


trait TestSetUp {

  val httpConf: HttpProtocolBuilder = http
    .baseURL("Base URL")
    //.acceptHeader("image/png,image/*;q=0.8,*/*;q=0.5")
    //.acceptEncodingHeader("gzip, deflate")
    //.acceptLanguageHeader("en-US,en;q=0.5")
    .disableWarmUp
  //.userAgentHeader("Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko)
  //("Chrome/34.0.1847.116) (Safari/537.36"))

  val feeder = csv("emailFeederFile.csv").queue

  val numbers = Iterator.continually(Map("num" -> scala.util.Random.nextInt(Int.MaxValue)))


}
