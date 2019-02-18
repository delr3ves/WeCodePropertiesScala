package com.emaginalabs.wecodeproperties

import org.scalacheck.Gen
import org.scalatest.prop.PropertyChecks
import org.scalatest.{FlatSpec, Matchers}

class CollectionsSpec extends FlatSpec with PropertyChecks with Matchers {

  "Collections" should "contain one more element after insertion" in {
    forAll() { (list: List[Int], a: Int) =>
      val newList = list :+ a
      newList.length shouldBe list.length + 1
    }
  }

  it should "contain the inserted element" in {
    forAll() { (list: List[Int], a: Int) =>
      val newList = list :+ a
      newList should contain(a)
    }
  }

  val generatorForRemove: Gen[(List[String], String)] = for {
    generated <- Gen.nonEmptyListOf(Gen.alphaNumStr)
    indexToRemove <- Gen.chooseNum(0, generated.length - 1)
  } yield (generated, generated(indexToRemove))

  it should "have an element less after deletion" in {
    forAll(generatorForRemove) { (input) =>
      val list = input._1
      val itemToRemove = input._2
      val newList = list.filter(_ != itemToRemove)
      val numberOfItems = list.count(_ == itemToRemove)
      newList.length shouldBe list.length - numberOfItems
    }
  }

  it should "not contain the removed element" in {
    forAll(generatorForRemove) { (input) =>
      val list = input._1
      val itemToRemove = input._2
      val newList = list.filter(_ != itemToRemove)
      newList shouldNot contain(itemToRemove)
    }
  }

  it should "contain the items of the two collections after a concatenation" in {
    forAll() { (list1: List[String], list2: List[String]) =>
      val newList = list1 ++ list2
      ensureCollectionContainsAllItems(newList, list1)
      ensureCollectionContainsAllItems(newList, list2)
    }
  }

  it should "no duplicated elements when convert to a set" in {
    forAll() { list: List[String] =>
      val nonRepeated = list.toSet.toList
      val distinctElements = list.distinct
      ensureCollectionContainsAllItems(nonRepeated, distinctElements)
      nonRepeated.length shouldBe distinctElements.length
    }
  }

  private def ensureCollectionContainsAllItems[T](haystack: List[T],
                                                  needle: List[T]): Unit = {
    needle.foreach {
      haystack should contain(_)
    }
  }

}
