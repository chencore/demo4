package com.transfar.sdc


import org.apache.spark.SparkConf
import org.apache.spark.streaming.{Seconds, StreamingContext}
/**
  * Spark Streaming处理Socket数据
  *
  * 测试： nc
  */
object NetworkWordCount {


  def main(args: Array[String]): Unit = {

    val sparkConf = new SparkConf()
      .setMaster("local[2]")
      //.setMaster("spark://172.28.65.27:7077") //提交到spark集群，需要服务端客户端网络双向都通
      .setAppName("NetworkWordCount")
      .set("spark.testing.memory", "512000000")//后面的值大于512m即可
    /**
      * 创建StreamingContext需要两个参数：SparkConf和batch interval
      */
    val ssc = new StreamingContext(sparkConf, Seconds(5))

    val lines = ssc.socketTextStream("172.28.65.27", 6789)

    val result = lines.flatMap(_.split(" ")).map((_,1)).reduceByKey(_+_)

    result.print()

    ssc.start()
    ssc.awaitTermination()
  }
}
