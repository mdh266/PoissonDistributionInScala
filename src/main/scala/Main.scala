package org.example
import org.example.stats.{mean, variance, get_ci, in_ci}


object main extends App {

	def printInfo(poisson : Poisson, n_samples : Int) : Unit = {
		val l = poisson.getLambda
		val samples = poisson.sample(n_samples)

		val m = mean(samples)
		val v = variance(samples)
    val ci = get_ci(samples)

		println(s"Mean for ${n_samples} samples: ${m}")
		println(s"Variance for ${n_samples} samples: ${v}")
    println(s"Confidence interval for ${n_samples} is ${ci}\n")
	}

	// create poisson distribution and sample it
	val lambda   = 1.3
	val p = new Poisson(lambda)

	println(s"Using ${p} for sampling...")
	List(100,1000,10000,100000).foreach(x =>printInfo(p,x))

  // simulate n_cis confidence intervals to see how many times
  // the confidences intervals capture the true lambda
  val n_cis = 20000
  val n_samples = 100
  val lambda_in_ci = in_ci(lambda) _

  val samples = List.fill(n_cis)(n_samples).map(p.sample)
  val percent = 100 * samples.map(get_ci).map(lambda_in_ci).sum.toDouble/ n_cis.toDouble

  println(s"95% confidence interval captures ${lambda} ${percent}% of the time.")

}