package de.block.moving.dsl

object MovingMain  {
  def main(args: Array[String]) {
	  import de.block.moving.dsl.MovingDSL._
//	  var dsl = new MovingDSL
	  Gehe(7) mal(Unten()) 
	  Gehe(6) mal Rechts() 
	  Gehe(5) mal Oben() 
	  Start  
	   
//	  Gehe nach unten
//	  Gehe nach links
//	  solange links frei gehe nach unten
	  //gehe hoch
  }

}

