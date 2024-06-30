package example

import scala.quoted.* // imports Quotes, Expr

object Scala3Macro:
  inline def inspect(inline x: Any): String = ${ inspectCode('x) }

  def inspectCode(x: Expr[Any])(using Quotes): Expr[String] =
    Expr(x.show)
