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
}
