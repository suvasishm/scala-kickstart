/**
  * Created by suvasish on 24-Oct-16.
  */
import ChecksumAccumulator.calculate

object Summer {
    def main(args: Array[String]): Unit = {
        for (arg <- args)
            println(arg + ": " + calculate(arg))
    }
}
