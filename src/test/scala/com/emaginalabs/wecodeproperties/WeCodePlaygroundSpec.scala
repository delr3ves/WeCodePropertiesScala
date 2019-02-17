package com.emaginalabs.wecodeproperties

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
      //write test the whatever property about the sum but add logs to know the value of the received numbers
    }
  }

  it should "allow us to modify the number of executions" in {
    //write a test in order to ensure the the number of executions
    // Here, you'll find how to change the number of success executions: https://stackoverflow.com/a/38706052
  }

  it should "make a test fail in order to see how shrink works" in {
    val result = Try {
      forAll() { (a: Int, b: Int) =>
        //write a test that sometimes fail and add traces in order to know how the library tries to give you a clue about the failing data
        fail("Just fail")
      }
    }
    result match {
      case Failure(exception) => print(exception.getMessage)
      case Success(_) => fail("The property should fail but it didn't")
    }
  }

  it should "fail when a test is too restrictive" in {
    //write a custom generator that is too restrictive to find enough values to run the tests.
    //Tip: You can capture the error the same way the previous test :)
  }

}
