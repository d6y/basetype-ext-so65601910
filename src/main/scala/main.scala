import slick.jdbc.H2Profile.api._

object Example extends App {

  import slick.lifted.LiteralColumn
  import slick.lifted.Rep
  import slick.ast.BaseTypedType

  object RepExtensions {
    implicit class RichRep[T : BaseTypedType](rep: Rep[T]) {
      def =?=(rhs: Option[T]): Rep[Boolean] =
        rhs.map(rep === _).getOrElse(LiteralColumn[Boolean](true))
    }
  }

}
