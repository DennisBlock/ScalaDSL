package de.block.moving.dsl

object MovingDSL {
  private val controller = new Controller

  //  trait Direction[+T]
  //  case class Unten extends Direction[Unten]
  //  case class Oben extends Direction[Oben]
  //  case class Links extends Direction[Links]
  //  case class Rechts extends Direction[Rechts]
  //  
  //  var lastDirection : Direction = Unten
  //  var last : Int = 0
  //  
  //  
  //  def Start = controller start
  var x = 0
  def Gehe(x: Int) = {
    this.x = x
  }
  //  def ->[T <: Direction](d: T) = { lastDirection = d; controller putDirection d; this}

  def mal(richtung: Richtung) = {
    for (i <- 0 until x) {
//    	controller fillQueue controller.block.goDown
    }
  }
  //  }

}

case class Richtung
