package a2.model

//one printable value
sealed trait Cell

// Text for strings like names or periods, Num for decimals in double data type, Count for whole numbers
case class Text(value: String) extends Cell
case class Num(value: Double) extends Cell
case class Count(value: Long) extends Cell

//Contains anything the analysis return: lines of cells that is formatted by report layer
trait Tabular:
  def lines: Vector[Vector[Cell]]
