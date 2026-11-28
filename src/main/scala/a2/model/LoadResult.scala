package a2.model

//outcome of loading a fle
case class LoadResult(accepted: Vector[Row], rejected: Vector[ParseError]):
  def read: Int = accepted.size + rejected.size
