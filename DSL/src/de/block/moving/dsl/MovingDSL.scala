package de.block.moving.dsl
object MovingDSL {
  
  def apply() = new MovingDSL

  sealed abstract class Richtung
  case class Runter extends Richtung
  case class Hoch extends Richtung
  case class Links extends Richtung
  case class Rechts extends Richtung

  def runter = Runter()
  def hoch = Hoch()
  def links = Links()
  def rechts = Rechts()

  class Verbund
  val zur = new Verbund
}
class MovingDSL {
  import de.block.moving.dsl.MovingDSL._
  private val controller = new Controller

  var x = 0

  def gehe(x: Int) = {
    this.x = x
    this
  }

  def gehe(verbund: Verbund) = this

  def mal(richtung: Richtung): MovingDSL = {
    for (i <- 0 until x) {
      richtung match {
        case Runter() => controller fillQueue (controller.block.goDown)
        case Hoch() => controller fillQueue (controller.block.goUp)
        case Links() => controller fillQueue (controller.block.goLeft)
        case Rechts() => controller fillQueue (controller.block.goRight)
        case _ => println("aahh")
      }

    }
    this
  }

  def wand(richtung: Richtung) = {
    richtung match {
      case Runter() => controller fillQueue (() =>
        {
          if (controller hasWallUnder)
            true
          else {
            controller.block.goDown()
            false
          }
        })
      case Hoch() => controller fillQueue (() =>
        {
          if (controller hasWallOver)
            true
          else {
            controller.block.goUp()
            false
          }
        })
      case Links() => controller fillQueue (() =>
        {
          if (controller hasWallLeft)
            true
          else {
            controller.block.goLeft()
            false
          }
        })
      case Rechts() => controller fillQueue (() =>
        {
          if (controller hasWallRight)
            true
          else {
            controller.block.goRight()
            false
          }
        })
    }

    this
  }

  def danke() = controller start

}
