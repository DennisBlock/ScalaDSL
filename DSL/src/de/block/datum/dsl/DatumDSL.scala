package de.block.datum.dsl

import java.util.Calendar

object DatumDSL {

  def main(args: Array[String]) {
    import de.block.datum.dsl.Datum._
    println(Heute plus 2 Tage und plus 2 Monate)
  }
/*
 * Sowas wie:	- Solange <Datum> vor/nach <Datum> ist in <Sekunden/Minuten/Stunden/Tage...)
 * 					tue <irgendwas> (println oder sowas)
 *     			- Von <Datum> bis <Datum> in <Sekunden/Minuten/Stunden/Tage...) 
 *        		- Dauer mit: 2 Stunden  + 3 Monate + 2 Jahre + 30 Minuten in Sekunden oder sowas
 */
}