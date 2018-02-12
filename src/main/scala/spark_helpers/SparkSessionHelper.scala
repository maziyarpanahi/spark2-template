package spark_helpers

import com.typesafe.config.ConfigFactory
import org.apache.spark.sql.SparkSession

object SparkSessionHelper {
  def buildSession(): SparkSession = {

    val sparkMaster = ConfigFactory.load().getString("spark.conf.master.value")

    println("Spark Master: ", sparkMaster)

    val spark: SparkSession = SparkSession.builder
      .appName("Spark Application")
      .master(sparkMaster)
      .enableHiveSupport()
      .getOrCreate

    spark.sparkContext.setLogLevel("WARN")

    spark
  }

  def getSparkSession(): SparkSession ={
    SparkSession.builder().getOrCreate()
  }
}