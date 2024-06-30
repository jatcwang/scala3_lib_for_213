package example

object Scala3Only:
  def num: Int = 123
  
  enum MyEnum {
    case Red
    case Blue
  }
  
  opaque type Age = Int
  
  object Age:
    def apply(i: Int): Age = i
    
  def funcUsingInlineInside: Int = inlineThis

  inline def inlineThis: Int = 3
  
  def usingScala3MacroInside(num: Int): String = {
    Scala3Macro.inspect(Age(num))
  }
  
  given givenEnum: MyEnum = MyEnum.Blue
  
// Trait parameters are not supported in Scala 2.13
trait TraitWithParam(val name: String)
    
