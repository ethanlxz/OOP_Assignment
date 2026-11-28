package a2.model

//Reasons for a record to be rejected
sealed trait ParseError:
  def label: String = this match
    case _: WrongColumnCount => "wrong_column_count"
    case _: MissingField => "missing_field"
    case _: BadNumber => "bad_number"
    case _: DuplicateRecord => "duplicate"

case class WrongColumnCount(record: Int, expected: Int, actual: Int) extends ParseError //Different number of fields from the header
case class MissingField(record: Int, column: String) extends ParseError //column named in submission.json is empty after trimming
case class BadNumber(record: Int, column: String, raw: String) extends ParseError //numeric column is not a finite number
case class DuplicateRecord(record: Int) extends ParseError //record text is identical to earlier accepted record
