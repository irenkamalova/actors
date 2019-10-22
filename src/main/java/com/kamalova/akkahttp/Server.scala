package com.kamalova.akkahttp

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.stream.ActorMaterializer

import scala.concurrent.ExecutionContext
import akka.http.scaladsl.server.Directives.{complete, path, _}

/**
  * source: https://www.freecodecamp.org/news/how-you-can-build-a-hello-world-api-with-scala-and-akka-http-55e2ff67d70d/
  *
  * used scala-sdk-2.12.8
  *
  * result: http://localhost:9000/hello
  */
object Server extends App {
  val host = "localhost"
  val port = 9000

  implicit val system: ActorSystem = ActorSystem("helloworld")
  implicit val executor: ExecutionContext = system.dispatcher
  implicit val materializer: ActorMaterializer = ActorMaterializer()

  def route =
    path("hello") {
      get {
        complete("Hello, World!")
      }
    }

  Http().bindAndHandle(route, host, port)

}
