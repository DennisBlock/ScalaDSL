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
        case Runter() => controller fuegeHinzu (controller.block.geheRunter)
        case Hoch() => controller fuegeHinzu (controller.block.geheHoch)
        case Links() => controller fuegeHinzu (controller.block.geheLinks)
        case Rechts() => controller fuegeHinzu (controller.block.geheRechts)
        case _ => println("Fehlerhafte Richtungsangabe!")
      }

    }
    this
  }

  def wand(richtung: Richtung) = {
    richtung match {
      case Runter() => controller fuegeHinzu (() =>
        {
          if (controller hatWandUnten)
            true
          else {
            controller.block.geheRunter()
            false
          }
        })
      case Hoch() => controller fuegeHinzu (() =>
        {
          if (controller hatWandOben)
            true
          else {
            controller.block.geheHoch()
            false
          }
        })
      case Links() => controller fuegeHinzu (() =>
        {
          if (controller hatWandLinks)
            true
          else {
            controller.block.geheLinks()
            false
          }
        })
      case Rechts() => controller fuegeHinzu (() =>
        {
          if (controller hatWandRechts)
            true
          else {
            controller.block.geheRechts()
            false
          }
        })
    }

    this
  }

  def danke() = controller start

}
