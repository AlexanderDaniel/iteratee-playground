package com.lachdrache

import org.scalatest.FunSpec
import play.api.libs.iteratee.{Input, Iteratee, Step}
import play.api.test.Helpers._
import scala.concurrent.ExecutionContext.Implicits.global

import scala.concurrent.{ExecutionContext, Future}

class IterateeSpec extends FunSpec {

  // http://www.playframework.com/documentation/2.3.x/Iteratees
  describe("primitive iteratees: done") {

    def folder(step: Step[String, Int]): Future[Option[Int]] = step match {
      case Step.Done(a, e) => Future(Some(a))
      case Step.Cont(k) => Future(None)
      case Step.Error(msg, e) => Future(None)
    }

    val doneIteratee = new Iteratee[String, Int] {
      def fold[B](folder: Step[String, Int] => Future[B])(implicit ec: ExecutionContext): Future[B] =
        folder(Step.Done(1, Input.Empty))
    }

    it("fold doneIteratee") {
      assertResult(Some(1)) {
        val eventuallyMaybeResult: Future[Option[Int]] = doneIteratee.fold(folder)
        await(eventuallyMaybeResult)
      }
    }

  }
}