package example

import example.Scala3Only.*

class Scala3Suite extends munit.FunSuite:
  test("3 works") {
    // Let's try some Scala3-only features just to be sure
    assertNotEquals(MyEnum.Red, MyEnum.Blue)
    assertEquals(inlineThis, 3)
    
    assertEquals(Scala3Macro.inspect(Age(1)), "example.Scala3Only.Age.apply(1)")
  }

