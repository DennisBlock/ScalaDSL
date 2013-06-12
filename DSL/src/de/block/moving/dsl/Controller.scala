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
  def fillQueue(f: () => Any) = list append f
  
  def run() = {
    while (isRunning) {
      if(next < list.size)
      {
    	  val f = list(next)
    	  if(f() == true) next += 1
      }
      else{
    	  println("Keine weiteren Funktionen zum Ausführen vorhanden")
    	  stop	
      }
      if (panel.isCollidedWithWall == true) { stop; println("block ist gegen eine mauer gelaufen") }
      else if(next == list.size && panel.isAtFinish == true ) { stop; println("block ist am Ziel") }

      panel.repaint
      Thread.sleep(300L)

    }
  }
  
}