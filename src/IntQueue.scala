import scala.collection.mutable.ArrayBuffer

/**
  * Created by igor on 26-2-16.
  */
abstract class IntQueue {
  def put(i: Int)
  def get() : Int
}

class BasicIntQueue extends IntQueue{
  private val buf = new ArrayBuffer[Int]

  def get() = buf.remove(0)
  def put(i : Int) { buf += i }
}

trait Doubling extends IntQueue{
  abstract override def put(i : Int){super.put(i * 2)}
}

trait Incrementing extends IntQueue{
  abstract override def put(i : Int){super.put(i + 1)}
}

trait Filtering extends IntQueue{
  abstract override def put(i : Int){
    if(i >= 0)
      super.put(i + 1)
  }
}
