package de.block.moving.dsl
//object Moving {
//}
object MovingDSL {
//  import de.block.moving.dsl.Moving._
  private val controller = new Controller
  
  
  sealed abstract class Richtung
  case class Unten extends Richtung
  case class Oben extends Richtung
  case class Links extends Richtung
  case class Rechts extends Richtung
  
  var x = 0
  
  def Gehe(x: Int) = {
    this.x = x
    this
  }

  def mal(richtung: Richtung) = {
    for (i <- 0 until x) {
      richtung match {
        case Unten() => controller fillQueue (controller.block.goDown)
        case Oben() => controller fillQueue (controller.block.goUp)
        case Links() => controller fillQueue (controller.block.goLeft)
        case Rechts() => controller fillQueue (controller.block.goRight)
        case _ => println("aahh")
      }

    }
  }

  def Start = controller start

}
