/**
  * Created by igor on 21-2-16.
  */
object BasicPatternMatching {
  def main(args : Array[String]){
    val firstArg = if(args.isEmpty) "" else args(0)

    val friend = firstArg match{
      case "salt" => "pepper"
      case "chips" => "salsa"
      case "eggs" => "bacon"
      case _ => "??"
    }

    println(friend)
  }
}
