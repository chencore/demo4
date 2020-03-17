package com.transfar.sdc

import org.apache.spark.{SparkConf,SparkContext}

object RddTest {
  def main(args: Array[String]) = {
    val conf = new SparkConf()
      .setMaster("local[2]")
      .setAppName("rddtest")
      .set("spark.testing.memory", "512000000")//后面的值大于512m即可;

    val sc = new SparkContext(conf);

    val rdd0 = sc.makeRDD(List(1,2,3,4,5,6));
    val rdd1 = sc.makeRDD(Array(1,2,3,4,5,6));
    val rdd2 = rdd0.map{x => x*x};
    println(rdd0.collect().mkString(","))
    println(rdd2.collect().mkString(","));

  }
}
