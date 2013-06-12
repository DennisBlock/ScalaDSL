package de.block.moving.dsl

class Block(var x: Int = 1, var y: Int = 1) {
  def goUp  : ()  => Boolean= {() =>  y = y - 1; true}
  def goDown : ()  => Boolean = {()  =>  y = y + 1; ; true}
  def goRight : ()  => Boolean= {() => x = x + 1; true}
  def goLeft : ()  => Boolean= {() => x = x - 1; true}
}