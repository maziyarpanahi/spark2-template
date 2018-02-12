package sql_practice

import spark_helpers.SparkSessionHelper
import org.apache.spark.sql.functions._

object examples {
  def exec1(): Unit ={
    val spark = SparkSessionHelper.getSparkSession()
    import spark.implicits._

    val toursDF = spark.read
      .option("multiline", true)
      .option("mode", "PERMISSIVE")
      .json("data/input/tours.json")
    toursDF.show

    println(toursDF
      .select(explode($"tourTags"))
      .groupBy("col")
      .count()
      .count()
    )

    toursDF
      .select(explode($"tourTags"), $"tourDifficulty")
      .groupBy($"col", $"tourDifficulty")
      .count()
      .orderBy($"count".desc).
      show(10)


  }
}
