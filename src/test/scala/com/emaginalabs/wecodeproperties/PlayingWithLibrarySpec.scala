package com.emaginalabs.wecodeproperties

import org.scalatest.prop.PropertyChecks
import org.scalatest.{FlatSpec, Matchers}

import scala.util.{Failure, Success, Try}

class PlayingWithLibrarySpec extends FlatSpec with PropertyChecks with Matchers {

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

  it should "fail when a generator is too restrictive" in {
    //write a custom generator that is too restrictive to find enough values to run the tests.
    //Tip: You can capture the error the same way the previous test :)
  }

  it should "fail when a generator is limited but not restrictive" in {
    //write a custom generator that only generate a very limited range of values.
    //Tip: You can use an already defined generator or just implement yours. I'll do mine :).
  }

}
