package a2.model

case class LoadResult(accepted: Vector[Row], rejected: Vector[ParseError]):
  def read: Int = accepted.size + rejected.size
