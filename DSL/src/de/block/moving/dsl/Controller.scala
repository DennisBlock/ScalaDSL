package de.block.moving.dsl

import java.awt.Dimension
import java.awt.Color
import scala.swing.Frame
import javax.swing.WindowConstants
import scala.collection.mutable.Queue
import scala.collection.mutable.ListBuffer
import scala.collection.mutable.ArrayBuffer

class Controller extends Runnable {
  private var list = ArrayBuffer.empty[Function0[Any]]
  private var next = 0
  var running = true
  val block = new Block

  val panel = new DrawPanel(block) {
    minimumSize = new Dimension(50 * 10, 50 * 10)
    preferredSize = minimumSize
    maximumSize = minimumSize
    background = Color.white
  }
  val frame = new Frame {
    title = "Moving"
    contents = panel
    visible = true
    peer.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE)
  }

  def isRunning: Boolean = running
  def stop = running = false
  def start = new Thread(this).start()
  def fuegeHinzu(f: () => Any) = list append f

  def run() = {
    while (isRunning) {
      if (next < list.size) {
        val f = list(next)
        if (f() == true) next += 1
      } else {
        println("Keine weiteren Funktionen zum Ausführen vorhanden")
        stop
      }
      
      if (panel.istMitWandKollidiert == true) { stop; println("Sie sind gegen eine Mauer gelaufen!") }
      else if (next == list.size && panel.istAmZiel == true) { stop; println("Glückwunsch Sie sind am Ziel") }

      panel.repaint
      Thread.sleep(300L)

    }
  }
  
  def hatWandOben(): Boolean = panel hatWandOben
  def hatWandUnten(): Boolean = panel hatWandUnten
  def hatWandLinks(): Boolean = panel hatWandLinks
  def hatWandRechts(): Boolean = panel hatWandRechts

}