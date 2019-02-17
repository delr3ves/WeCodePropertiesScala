package com.emaginalabs.wecodeproperties

import org.scalatest.prop.PropertyChecks
import org.scalatest.{FlatSpec, Matchers}

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

}
