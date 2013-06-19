package de.block.moving.dsl

class Block(var x: Int = 1, var y: Int = 1) {
  def geheHoch  : ()  => Boolean= {() =>  y = y - 1; true}
  def geheRunter : ()  => Boolean = {()  =>  y = y + 1; true}
  def geheRechts : ()  => Boolean= {() => x = x + 1; true}
  def geheLinks : ()  => Boolean= {() => x = x - 1; true}
}