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
    def januar = Januar
    def Februar = datum setTag x setMonat 2
    def februar = Februar
    def März = datum setTag x setMonat Calendar.MARCH
    def märz = März
    def April = datum setTag x setMonat Calendar.APRIL
    def april = April
    def Mai = datum setTag x setMonat Calendar.MAY
    def mai = Mai
    def Juni = datum setTag x setMonat Calendar.JUNE
    def juni = Juni
    def Juli = datum setTag x setMonat Calendar.JULY
    def juli = Juli
    def August = datum setTag x setMonat Calendar.AUGUST
    def august = August
    def September = datum setTag x setMonat Calendar.SEPTEMBER
    def september = September
    def Oktober = datum setTag x setMonat Calendar.OCTOBER
    def oktober = Oktober
    def November = datum setTag x setMonat Calendar.NOVEMBER
    def november = November
    def Dezember = datum setTag x setMonat Calendar.DECEMBER
    def dezember = Dezember
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
  def tag = Tag
  def tag(und: Verbund): Datum = Tag
  def Tage: Datum = Tag
  def Tage(und: Verbund): Datum = Tag
  def tage: Datum = Tag
  def tage(und: Verbund): Datum = Tag
  
  def Monat: Datum = { datum.add(Calendar.MONTH, last); this }
  def Monat(und: Verbund): Datum = Monat
  def monat = Monat
  def monat(und: Verbund): Datum = Monat
  def Monate = Monat
  def Monate(und: Verbund): Datum = Monat
  def monate = Monat
  def monate(und: Verbund): Datum = Monat
  
  def Jahr: Datum = { datum.add(Calendar.YEAR, last); this }
  def Jahr(und: Verbund): Datum = Jahr
  def jahr = Jahr
  def jahr(und: Verbund): Datum = Jahr
  def Jahre = Jahr
  def Jahre(und: Verbund): Datum = Jahr
  def jahre = Jahr
  def jahre(und: Verbund): Datum = Jahr
  
  override def toString = "%1$Td.%1$Tm.%1$TY" format datum
}

