package de.block.moving.dsl

import scala.swing.Panel
import java.awt.Graphics2D
import java.awt.Color

object DrawPanel {
  val None = 0
  val Wall = None + 1
  val Block = None + 2
  val Finish = None + 3
}

class DrawPanel(block: Block) extends Panel {

  private val level = Array[Array[Int]](
    Array[Int](1, 1, 1, 1, 1, 1, 1, 1, 1, 1),
    Array[Int](1, 0, 0, 1, 0, 0, 0, 0, 0, 1),
    Array[Int](1, 0, 0, 1, 0, 1, 0, 1, 0, 1),
    Array[Int](1, 0, 1, 1, 0, 1, 1, 3, 0, 1),
    Array[Int](1, 0, 0, 0, 0, 0, 1, 0, 0, 1),
    Array[Int](1, 0, 0, 0, 0, 0, 1, 0, 0, 1),
    Array[Int](1, 0, 1, 1, 0, 0, 1, 0, 1, 1),
    Array[Int](1, 0, 0, 1, 1, 0, 0, 0, 0, 1),
    Array[Int](1, 0, 0, 0, 0, 0, 0, 0, 0, 1),
    Array[Int](1, 1, 1, 1, 1, 1, 1, 1, 1, 1))

  /*	   0  1  2  3  4  5  6  7  8  9
   * 	0 (1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
  		1  1, 0, 0, 1, 0, 0, 0, 0, 0, 1,
		2  1, 0, 0, 1, 0, 1, 0, 1, 0, 1,
		3  1, 0, 1, 1, 0, 1, 1, 3, 0, 1,
		4  1, 0, 0, 0, 0, 0, 1, 0, 0, 1,
		5  1, 0, 0, 0, 0, 0, 1, 0, 0, 1,
		6  1, 0, 1, 1, 0, 0, 1, 0, 1, 1,
		7  1, 0, 0, 1, 1, 0, 0, 0, 0, 1,
		8  1, 0, 0, 0, 0, 0, 0, 0, 0, 1,
		9  1, 1, 1, 1, 1, 1, 1, 1, 1, 1)
  */
  override def paintComponent(g: Graphics2D) {
    drawLevel(g)

    drawBlock(g)
  }

  def drawBlock(g: Graphics2D) {
    g.setColor(Color.RED)
    g.fillRect(block.x * 50, block.y * 50, 50, 50)
  }

  def drawLevel(g: Graphics2D) {
    for {
      x <- 0 until level.length
      y <- 0 until level(x).length
    } {
      level(y)(x) match {
        case DrawPanel.Wall => g.setColor(Color.BLACK)
        case DrawPanel.None => g.setColor(Color.WHITE)
        case DrawPanel.Finish => g.setColor(Color.BLUE)
        case _ => println("undefined on " + x + "/" + y)
      }
      g.fillRect(x * 50, y * 50, 50, 50)
      g.setColor(Color.WHITE)
      g.drawString(x + ", " + y, x * 50 + 15, y * 50 + 25)
      
    }
  }
}