package de.block.moving.dsl

class Block(var x: Int = 1, var y: Int = 1) {
  def goUp = y = y - 1
  def goDown = y = y + 1
  def goRight = x = x + 1
  def goLeft = x = x - 1
}