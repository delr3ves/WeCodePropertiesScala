package com.emaginalabs.wecodeproperties

import scala.annotation.tailrec

object Fibonacci {

  def apply(n: Int): Long = {
    @tailrec
    def fib_tail( n: Int, a:Long , b:Long): Long = n match {
      case 0 => a
      case _ => fib_tail( n-1, b, a+b )
    }
    return fib_tail( n, 0, 1)
  }

}
