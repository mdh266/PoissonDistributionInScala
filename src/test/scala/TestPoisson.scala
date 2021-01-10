import org.scalatest.funsuite.AnyFunSuite
import org.example.Poisson

class TestPoisson extends AnyFunSuite {

	test("Test Constructor") {
		val p = new Poisson(3.2)
		assert(p.getLambda() == 3.2)
	}

	test("Test Poisson.prob") {
		val p = new Poisson(2)
		assert(p.prob(3) == 0.1804470443154836)
	}

	test("Test Poisson.cdf") {
		val p = new Poisson(1)
		assert(p.cdf(1) == 0.7357588823428847)
	}

	test("Test Poisson.uniform") {
		val p = new Poisson(0.2)
		assert(p.uniform(7).length == 7)
	}

	test("Test Poisson.getSum") {
		val p = new Poisson(0.0)
		val x = List(1.0,2.0,3.0)
		assert(p.getSum(x)(1) == 3)
	}

	test("Test Poisson.sample throws exception") {
		intercept[IllegalArgumentException] {
			val p = new Poisson(0.0)
			p.sample(-1)
	  }
	}
	
	test("Test Poisson.prob throws exception") {
		intercept[IllegalArgumentException] {
			val p = new Poisson(1.0)
			p.prob(-1)
	  }
	}

	test("Test Poisson.cdf throws exception") {
		intercept[IllegalArgumentException] {
			val p = new Poisson(1.0)
			p.cdf(-1)
	  }
	}
}
