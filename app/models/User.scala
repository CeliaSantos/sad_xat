package models

import play.mvc._
import play.api.mvc.PathBindable
import play.api.libs.json.{JsValue, Json}


case class User(username: String){

  /**
    * Create a Json object of an user
    */
  def toJson:JsValue = Json.obj(
    "username" -> username
  )
}

object User {

  /**
    * Transform a json into a User.
    */
  def jsonToUser(json: JsValue): User = {
    val username = (json \ "username").as[String]
    val user = User(username)
    user
  }
  /**
    * Allow the serialization of an User object as a path param. If no sucessful request
    * the client receives a Bad Request.
    */
  implicit def pathBinder(implicit stringBinder: PathBindable[String]) = new PathBindable[User] {
    override def bind(key: String, value: String): Either[String, User] = {
      try {
        Right(User(value))
      } catch {
        case e:Exception => Left("Who R U?") //Bad Request
      }
    }
    override def unbind(key: String, user: User): String = {
      user.username
    }
  }

}