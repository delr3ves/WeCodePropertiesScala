package com.emaginalabs.wecodeproperties

import org.scalacheck.Gen
import org.scalatest.prop.PropertyChecks
import org.scalatest.{FlatSpec, Matchers}

import scala.util.{Failure, Success, Try}

class WeCodePlaygroundSpec extends FlatSpec with PropertyChecks with Matchers {

  val playground = new WeCodePlayground()

  "Sum" should "keep the associative property" in {
    forAll() { (a: Int, b: Int, c: Int) =>
      playground.sum(playground.sum(a, b), c) shouldBe playground.sum(a, playground.sum(b, c))
    }
  }

  it should "keep the commutative property" in {
    forAll() { (a: Int, b: Int) =>
      playground.sum(a, b) shouldBe playground.sum(b, a)
    }
  }

  it should "have an identity value" in {
    forAll() { (a: Int) =>
      playground.sum(a, 0) shouldBe a
    }
  }

  val sumCases = Table(
    ("a", "b", "result"),
    (1, 4, 5),
    (4, 5, 9),
    (0, 0, 0),
    (-1, -5, -6),
    (1, -5, -4),
    (-5, 1, -4)
  )

  it should "actually sum a couple numbers" in {
    forAll(sumCases) { (a: Int, b: Int, result: Int) =>
      playground.sum(a, b) shouldBe result
    }
  }

  "Playing with the library" should "add logs to know how it executes" in {
    forAll() { (a: Int, b: Int) =>
      println(s"Just executed the test with values [a: $a, b: $b]")
      playground.sum(a, b) shouldBe playground.sum(b, a)
    }
  }

  it should "allow us to modify the number of executions" in {
    var numOfExecutions = 0;
    forAll(minSuccessful(500)) { (a: Int) =>
      numOfExecutions += 1
      succeed
    }
    numOfExecutions shouldBe 500
  }

  it should "make a test fail in order to see how shrink works" in {
    val result = Try {
      forAll() { (a: Int, b: Int) =>
        println(s"Just executed the test with values [a: $a, b: $b]")
        if (a > 5 || b > 7) {
          fail("Just fail")
        }
      }
    }
    result match {
      case Failure(exception) => print(exception.getMessage)
      case Success(_) => fail("The property should fail but it didn't")
    }
  }

  it should "fail when a test is too restrictive" in {
    val result = Try {
      forAll(Gen.choose(Int.MinValue, Int.MaxValue).filter(a => { a > 1 && a < 5 })) { (a: Int) =>
        succeed
      }
    }
    result match {
      case Failure(exception) => print(exception.getMessage)
      case Success(_) => fail("The property should fail because generator is to restritive")
    }
  }

}
