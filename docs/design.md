# Design for Assignemtn 2

Date: 26 November 2026

## Packages

|Package|Responsibility|Depends On|
|-----|-------|-------|
| model| Row, ParseError, LoadResult, results | - |
| io| read file, parse records | model |
| analysis| Q1 to Q4 computations | model |
| report| format printed output | model |
| Main| wire the layers together, no logic  | all |

**Dependency Rule**: The analysis package never imports io or report packages. This keeps the calculations independent of where the data is parsed and how it is displayed, so each layer can be changed or tested alone.


## Traits
Each question is an implementation of the same trait:
```scala
trait Analysis[R]:
  def name: String
  def run(rows: Seq[Row]): R
```
Q1 to Q4 each implements Analysis. Main keeps them in a single List and runs each one. Adding a fifth analysis would require one new file and one new list entry. The analyses only return plain results and will not output. The report does the formatting for the data. We also write generic helpers with type parameters so it can be reused by more than one analysis.

## ParseError ADT
ParseError is a sealed trait with the following case-classes:
- `WrongColumnCount`: the record has a different number of fields from the header
- `MissingField`: a required column in `submission.json` is empty
- `BadNumber`: the `numericColumns` used for my question does not parse
- `DuplicateRecord`: record text is identical to an earlier accepted record

The loader returns `Either[ParseError, Row]` for each record. A bad record becomes a `Left` and is counted into the data quality. Errors are values and not exceptions, so a bad row can never crash the program.

## Distinction Challenge
**D1 Composable Query API**

A small library `trait Quey[-A, +B]` with `map.filter` and `andThen`, and re-express Q1-Q3 as compositions of queries. Justify each variance annotaiton with an example that would not compile without it.
