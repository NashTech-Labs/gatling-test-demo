# GatlingTestsDemo
This repo consist various gatling test examples.

## To run individual test, use the following command:
sbt "project postDeploymentTest" "gatling:testOnly <class name>"

Any simulation can be run by mentioning its name

## To run all tests, use the following command:
sbt "project postDeploymentTest" "gatling:test"
