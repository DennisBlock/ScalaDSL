package de.block.datum.dsl

import java.util.Calendar

object Datum {
  class Verbund
  val und = new Verbund
  
  def Heute = new Datum(Calendar.getInstance)
  def heute = Heute

  implicit class Monate(x: Int) {
    private val datum = Heute
    def Januar = datum setTag x setMonat Calendar.JANUARY
    def Februar = datum setTag x setMonat Calendar.FEBRUARY
    def März = datum setTag x setMonat Calendar.MARCH
    def April = datum setTag x setMonat Calendar.APRIL
    def Mai = datum setTag x setMonat Calendar.MAY
    def Juni = datum setTag x setMonat Calendar.JUNE
    def Juli = datum setTag x setMonat Calendar.JULY
    def August = datum setTag x setMonat Calendar.AUGUST
    def September = datum setTag x setMonat Calendar.SEPTEMBER
    def Oktober = datum setTag x setMonat Calendar.OCTOBER
    def November = datum setTag x setMonat Calendar.NOVEMBER
    def Dezember = datum setTag x setMonat Calendar.DECEMBER
  }
}

class Datum(datum: Calendar) {
  import Datum.Verbund
  
  datum.clear(Calendar.HOUR)

  def apply(jahr: Int): Datum = {
    datum.set(Calendar.YEAR, jahr)
    this
  }

  private var last = 0;

  def plus(x: Int) = { last = x; this }
  def minus(x: Int) = { last = -x; this }
  
  def +(x: Int) = plus(x)
  def -(x: Int) = minus(x)

  def setTag(tag: Int): Datum = { datum.set(Calendar.DAY_OF_MONTH, tag); this }
  def setMonat(monat: Int): Datum = { datum.set(Calendar.MONTH, monat); this }

  def Tag: Datum = { datum.add(Calendar.DAY_OF_MONTH, last); this }
  def Tag(und: Verbund): Datum = Tag
  def Tage: Datum = Tag
  def Tage(und: Verbund): Datum = Tag
  
  def Monat: Datum = { datum.add(Calendar.MONTH, last); this }
  def Monat(und: Verbund): Datum = Monat
  def Monate = Monat
  def Monate(und: Verbund): Datum = Monat
  
  def Jahr: Datum = { datum.add(Calendar.YEAR, last); this }
  def Jahr(und: Verbund): Datum = Jahr
  def Jahre = Jahr
  def Jahre(und: Verbund): Datum = Jahr
  
  override def toString = "%1$Td.%1$Tm.%1$TY" format datum
}

