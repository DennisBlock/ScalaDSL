package de.block.moving.dsl

import scala.swing.MainFrame
import scala.swing.SimpleSwingApplication
import java.awt.Dimension
import java.awt.Color
import scala.swing.Frame

object MovingMain {
  def main(args: Array[String]) {
	  new Controller
  }
}

class Controller {
  val block = new Block(1, 1)

  val panel = new DrawPanel(block) {
    minimumSize = new Dimension(50 * 10, 50 * 10)
    preferredSize = minimumSize
    maximumSize = minimumSize
    background = Color.white
  }
  val frame = new Frame {
    contents = panel
    visible = true
  }
}

class Block(var x: Int, var y: Int)