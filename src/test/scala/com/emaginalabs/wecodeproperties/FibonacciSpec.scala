package com.emaginalabs.wecodeproperties

import org.scalatest.prop.PropertyChecks
import org.scalatest.{FlatSpec, Matchers}
import org.scalacheck.Gen


class FibonacciSpec extends FlatSpec with PropertyChecks with Matchers {
  "Fibonacci of n" should "be the sum of fibonacci of n-2 + fibonacci of n-1" in {
    forAll(Gen.chooseNum(2, 1000)) { (n: Int) =>
      Fibonacci(n) shouldBe Fibonacci(n - 2) + Fibonacci(n - 1)
    }
  }
}
