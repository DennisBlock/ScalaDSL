package de.block.datum.dsl

import java.util.Calendar

object DatumDSL {

  def main(args: Array[String]) {
    import de.block.datum.dsl.Datum._
    println(Heute)
    println(Morgen)
    println(Gestern)
    println(1 Juni 2013 plus 3 Tage und plus 22 Monate)
  }
}