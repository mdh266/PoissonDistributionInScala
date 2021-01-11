import org.scalatest.funsuite.AnyFunSuite
import org.example.stats.{mean, variance, get_ci, in_ci}

class TestFunctions extends AnyFunSuite {

  test("Test mean") {
    val x = List(1,2,1,2,1,2)
    assert(mean(x) == 1.5)
  }

   test("Test mean throws exception") {
   	intercept[IllegalArgumentException] {
	    mean(List())
	  }
  }

   test("Test variance") {
    val x = List(1,1,1,1,1)
    assert(variance(x) == 0)
  }

   test("Test variance throws exception") {
     intercept[IllegalArgumentException] {
       variance(List())
     }
   }

  test("Test get_ci"){
    assert(get_ci(List(1,0,1,0,1,0,1)) ==
      (0.1754487739641048,0.9674083688930379)
    )
  }

  test("Test get_ci throws exception"){
    intercept[IllegalArgumentException] {
      get_ci(List())
    }
  }

  test("Test in_ci"){
    assert(in_ci(8.3)((7.8,9.2)) == 1)
  }

  test("Test too low to be in_ci"){
    assert(in_ci(3.8)((7.8,9.2)) == 0)
  }

  test("Test too high to be in_ci"){
    assert(in_ci(10.0)((7.8,9.2)) == 0)
  }
}
