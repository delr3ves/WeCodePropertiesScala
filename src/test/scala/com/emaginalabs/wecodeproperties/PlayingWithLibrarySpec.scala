package com.emaginalabs.wecodeproperties

import org.scalacheck.Gen
import org.scalatest.prop.PropertyChecks
import org.scalatest.{FlatSpec, Matchers}

import scala.util.{Failure, Success, Try}

class PlayingWithLibrarySpec
    extends FlatSpec
    with PropertyChecks
    with Matchers {

  "Playing with the library" should "add logs to know how it executes" in {
    forAll() { (a: Int, b: Int) =>
      println(s"Just executed the test with values [a: $a, b: $b]")
      a + b shouldBe b + a
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
      case Success(_)         => fail("The property should fail but it didn't")
    }
  }

  it should "fail when a generator is too restrictive" in {
    val result = Try {
      forAll(
        Gen
          .choose(Int.MinValue, Int.MaxValue)
          .filter(a => {
            a > 3 && a < 5
          })) { (a: Int) =>
        succeed
      }
    }
    result match {
      case Failure(exception) => print(exception.getMessage)
      case Success(_) =>
        fail("The property should fail because generator is to restritive")
    }
  }

  def numericRangeGenerator(a: Int, b: Int): Gen[Int] =
    for {
      generated <- Gen.chooseNum(Int.MinValue, Int.MaxValue)
      absA = Math.abs(a)
      absB = Math.abs(b)
      i = Math.abs(generated) % (absB - absA)
      number = i + absA
      x = number
    } yield (number)

  it should "fail when a generator is limited but not restrictive" in {
    forAll(numericRangeGenerator(3, 5)) { (a: Int) =>
      a should be >= 3
      a should be <= 5
    }
  }

}
