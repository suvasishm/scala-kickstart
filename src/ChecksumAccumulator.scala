/**
  * Created by suvasish on 24-Oct-16.
  */
import scala.collection.mutable

class ChecksumAccumulator {
    private var sum = 0;
    def add (b: Byte) = sum+=b
    def checksum() = ~(sum & 0xFF) + 1
}


object ChecksumAccumulator {

    private val cache = mutable.Map.empty[String, Int]

    def calculate(s: String): Int = {

        if (cache.contains(s))
            cache(s)
        else {
            val acc = new ChecksumAccumulator
            //s.foreach(acc.add(c.toByte))
            for (c <- s)
                acc.add(c.toByte)
            val cs = acc.checksum()
            cache += (s -> cs)
            cs
        }
    }
}
