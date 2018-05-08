object RequestTemplate extends TestSetUp {

  val registerRequestTemplate =
    """{"userName":"${userName}${num}","emailId":"${email}","password":"123456789"}""".stripMargin

  val registerRequest =
    """{"userName":"test${num}","emailId":"test{num}@xyz.com","password":"123456789"}"""

  val loginTemplate =
    """{"userName": "testUser","password": "987654321"}"""
}
