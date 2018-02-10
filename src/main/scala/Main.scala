import spark_helpers.SparkSessionHelper

object Main {
  def main(args: Array[String]): Unit = {
    val spark = SparkSessionHelper.buildSession()
  }
}
