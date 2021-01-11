package org.example
import scala.math.{pow,sqrt}

object stats {

	def mean(a : List[Int]) : Double = {
		if(a.length > 0) {
			(1.0/a.length) * a.sum
		}
		else {
			throw new IllegalArgumentException("List is empty")
		}
	}

	def variance(a : List[Int]) : Double = {
		if(a.length > 0) {
			val avg         = mean(a)
			val sum_squares = a map (x => pow(x-avg,2)) reduce(_ + _)
			sum_squares/(a.length-1)
		}
		else {
			throw new IllegalArgumentException("List is empty")
		}
	}

  // get the 95% confidence interval
	def get_ci(a : List[Int]) : Tuple2[Double, Double] = {
		if(a.length > 0) {
			val n = a.length
			val m = mean(a)
			val s = sqrt(variance(a))
			val z = 1.96
			val high = m + z * s / sqrt(n)
			val low = m - z * s / sqrt(n)
			(low, high)
		}
		else {
			throw new IllegalArgumentException("List is empty")
		}
	}

  // returns 1 if in the confidence interval or 0 if not
  def in_ci(lambda : Double)(ci : Tuple2[Double, Double]) : Int = {
    if( lambda >= ci._1 & lambda <= ci._2) {1}
    else {0}
  }

}