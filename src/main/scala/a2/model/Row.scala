package a2.model

//Columns matching the submission.json for the dataset.csv
object Columns:
  val Date: String = "date"
  val Market: String = "market"
  val Commodity: String = "commodity"
  val Price: String = "price"
  val UsdPrice: String = "usdprice"
  val Required: Vector[String] = Vector(Date, Market, Commodity, Price, UsdPrice)
  //numeric columns
  val Numeric: Vector[String] = Vector(Price, UsdPrice)

//accepted record
case class Row(date: String, market: String, commodity: String, price: Double, usdPrice: Double)

//row construction
object Row:
  def from(text: Map[String, String], numbers: Map[String, Double]): Row =
    Row(
      text.getOrElse(Columns.Date, "")
      text.getOrElse(Columns.Market, "")
      text.getOrElse(Columns.Commodity, "")
      text.getOrElse(Columns.Price, 0.0)
      text.getOrElse(Columns.UsdPrice, 0.0)
    )
