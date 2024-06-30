package example

import example.Scala3Only._

class CrossSuite extends munit.FunSuite {
  test("tests that run for both 2.13 and 3") {
    
    // Can use enum
    val red: MyEnum = MyEnum.Red
    val blue: MyEnum = MyEnum.Blue
    
    assertNotEquals(red, blue)
    
    // Opaque type works
    assert(Age(1).isInstanceOf[Int])
    // Given works
    assertEquals(implicitly[MyEnum], MyEnum.Blue)
    
    // Some Scala 3 features can be used within the library as long as they're used directly
    assertEquals(funcUsingInlineInside, 3)

    // Seems like you can also use Scala 3 macros in your implementation
    assertEquals(usingScala3MacroInside(3), "example.Scala3Only.Age.apply(num)")
    
    // Caveat: Some unsupported Scala 3 features can be defined in the same scope as other which are used by 2.13
    // library and it won't lead to a compile error as long as they aren't used by 2.13 directly.
    // Uncomment any of the following lines is a compile error for 2.13
    // new TraitWithParam("some name") {}
    // inlineThis

  }
}
