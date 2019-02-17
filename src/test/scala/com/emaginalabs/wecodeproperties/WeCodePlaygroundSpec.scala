package com.emaginalabs.wecodeproperties

import org.scalatest.prop.PropertyChecks
import org.scalatest.{FlatSpec, Matchers}

class WeCodePlaygroundSpec extends FlatSpec with PropertyChecks with Matchers {

  def sum(a: Int, b: Int): Int = ???

  "Sum" should "keep the associative property" in {
    //TODO test the associative property
  }

  it should "keep the commutative property" in {
    //TODO test the commutative property
  }

  it should "have an identity value" in {
    //TODO test the identity property
  }

  it should "actually sum a couple numbers" in {
    //TODO test the sum
  }

}
