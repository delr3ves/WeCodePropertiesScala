package com.emaginalabs.wecodeproperties.maxibon

import com.emaginalabs.wecodeproperties.maxibon.developer.Developer

case class KarumiHQs(val chat: Chat) {
  private val minMaxibons = 2
  private val maxMaxibons = 10

  var maxibonsLeft: Int = maxMaxibons

  def openFridge(developer: Developer) {
    grabMaxibons(developer)
    if (shouldBuyMoreMaxibons()) {
      notifyWeShouldBuyMaxibon(developer)
      buyMaxibons()
    }
  }

  def openFridge(developers: List[Developer]) {
    developers.foreach { developer =>
      openFridge(developer)
    }
  }

  private def grabMaxibons(developer: Developer) {
    maxibonsLeft -= developer.numberOfMaxibonsToGrab
  }

  private def shouldBuyMoreMaxibons(): Boolean = maxibonsLeft <= minMaxibons

  private def notifyWeShouldBuyMaxibon(developer: Developer) =
    chat.sendMessage(s"Hi guys, I'm ${developer.name}. We need more maxibons!")

  private def buyMaxibons() {
    maxibonsLeft += maxMaxibons
  }
}
