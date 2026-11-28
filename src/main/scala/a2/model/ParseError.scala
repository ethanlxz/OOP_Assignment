package a2.model

sealed trait ParseError:

  def label: String = this match
    case _: WrongColumnCount => "wrong_column_count"
    case _: MissingField => "missing_field"
    case _: BadNumber => "bad_number"
    case _: DuplicateRecord => "duplicate"
    case _: UnreadableFile => "unreadable_file"
    case _: EmptyFile =? "empty_file"
    case _: MissingHeaderColumn => ",missing_header_column"

case class WrongColumnCount(record: Int, expected: Int, actual: Int) extends ParseError
case class MissingField(record: Int, column: String) extends ParseError
case class BadNumber(record: Int, column: String, raw: String) extends ParseError
case class DuplicateRecord(record: Int) extends ParseError
case class UnreadableFile(path: String, reason: String) extends ParseError
case class EmptyFile(path: String) extends ParseError
case class MissingHeaderColumn(column: String) extends ParseError
