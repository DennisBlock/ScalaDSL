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
  import de.block.moving.dsl.DrawPanel._
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
        case Wall => g.setColor(Color.BLACK)
        case None => g.setColor(Color.WHITE)
        case Finish => g.setColor(Color.BLUE)
        case _ => println("undefined on " + x + "/" + y)
      }
      g.fillRect(x * 50, y * 50, 50, 50)
      g.setColor(Color.WHITE)
    }
  }

  def isCollidedWithWall(): Boolean = {
    val x = block.x
    val y = block.y
    level(y)(x) == Wall
  }

  def isAtFinish(): Boolean = {
    val x = block.x
    val y = block.y
    level(y)(x) == Finish
  }

  def hasWallOver(): Boolean = {
    val x = block.x
    val y = block.y
    level(y - 1)(x) == Wall
  }
  def hasWallUnder(): Boolean = {
    val x = block.x
    val y = block.y
    level(y + 1)(x) == Wall
  }
  def hasWallLeft(): Boolean = {
    val x = block.x
    val y = block.y
    level(y)(x - 1) == Wall
  }
  def hasWallRight(): Boolean = {
    val x = block.x
    val y = block.y
    level(y)(x + 1) == Wall
  }
}