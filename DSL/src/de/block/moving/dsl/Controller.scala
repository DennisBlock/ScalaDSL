package de.block.moving.dsl

import java.awt.Dimension
import java.awt.Color
import scala.swing.Frame
import javax.swing.WindowConstants
import scala.collection.mutable.Queue

class Controller extends Runnable {
  // TODO Queue mit Functions
  private var queue = new Queue[String]
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
  
  def run() = {
    while (isRunning) {
      Thread.sleep(300L)
//      queue 
      block.goDown
      if (panel.isCollidedWithWall == true) { stop }
      else if(panel.isAtFinish == true) { stop }

      panel.repaint

    }
  }
  
}