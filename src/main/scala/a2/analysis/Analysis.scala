package a2.analysis

import a2.model.{Row, Tabular}

//question answered over the accepted rows
trait Analysis[R <: Tabular]:
  def name: String //question heading
  def run(rows: Seq[Row]): R //computes the result but never prints
