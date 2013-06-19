package de.block.moving.dsl

object MovingMain {
  def main(args: Array[String]) {
    import de.block.moving.dsl.MovingDSL._
    /* Neues Objekt der DSL
	  * Alle Funktionen bitte auf dieses Objekt ausführen
	  */
    val bitte = MovingDSL()

    //	  bitte gehe zur Wand runter danke
    bitte gehe 4 mal Runter() danke

  }

}

