package controllers

import akka.actor.{Actor, ActorRef, ActorSystem, Props}
import models.User
import models.Message
import play.api.libs.json.{JsValue, Json}

import scala.collection.mutable

/**
  * Every instance of MyWebSocketActor represents a Client
  * https://doc.akka.io/docs/akka/2.5.5/scala/actors.html
  */
class MyWebSocketActor(user:User, client: ActorRef, clientsList: ActorRef) extends Actor{

  /**
    * Right after starting the actor, its preStart method is invoked.
    * Adds the client to the client list
    */
  override def preStart()  = {
    clientsList ! AddClient(user, client)
  }

  /**
    * After stopping an actor, its postStop hook is called
    * Removes the client from the client list
    */
  override def postStop()  = {
    clientsList ! RemoveClient(user, client)
  }

  /**
    * When a message is received, this method send a broadcast message to all connected
    * clients in the ClientsList
    * The receive method define a series of case statements that defines which messages
    * your Actor can handle and the implementation of how the messages should be processed.
    */
  def receive = {
    case msg: String =>
      println ("Rx message: " + msg)
      val json: JsValue = Json.parse(msg)
      val message = (json \ "message").as[String]
      println ("Broadcasting...")
      clientsList ! SendBroadcast(Message(user, message))
  }
}


object MyWebSocketActor{

  /**
    * Singleton instance of the list of client Actors.
    * An actor system is a hierarchical group of actors which share common configuration
    */
  var clientsList = ActorSystem().actorOf(Props[ClientsList])

  /**
    * Every time the HomeController invokes this method, a new MyWebSocketActor is initialized.
    * Props is a configuration class to specify options for the creation of actors
    */
  def props(out: ActorRef, user: User) = {
    Props(new MyWebSocketActor(user, out, clientsList))
  }
}


/**
  * Represents a client, with a name and an actor
  */
case class Client(val userName:String, val actor: ActorRef);


/**
  * Represents the different type of requests that the ClientListActor can receibe.
  * A sealed trait can be extended only in the same file as its declaration. "alternative to enums"
  */
sealed trait ClientsListRequests{}

case class AddClient(val user:User, val client:ActorRef) extends ClientsListRequests

case class RemoveClient(val user:User, val client:ActorRef) extends ClientsListRequests

case class SendBroadcast(val message:Message) extends ClientsListRequests

/**
  * The ClientsList actor is the one in charge of managing the list of connected clients.
  * This method allows:
  * *Adding/Removing a client
  * *Send broadcast messages
  */
class ClientsList extends Actor {

  /**
    * The queue with all the Clients
    */
  private val clientsList = mutable.Queue[Client]()


  /**
    * Depending on the request
    */
  def receive = {

    case AddClient(user, actor) =>{
      println("AddClient" + user)

      val newLogin = Json.obj(
      "type" -> "login",
      "user" -> user.username
      )


      clientsList.foreach( client => {
        //sends a new login message to the rest of clients
        client.actor ! newLogin.toString()

        //notifies to the new client all the current clients connected
        val currentLogin = Json.obj(
          "type" -> "login",
          "user" -> client.userName
        )
        actor ! currentLogin.toString()
      })

      clientsList.enqueue(Client(user.username, actor))
    }

    case RemoveClient(user, actor) =>{

      println("RemoveClient" + user)

      //dequeueFirst: Returns the first element in the queue which satisfies the given predicate, and removes this element from the queue.
      if(clientsList.dequeueFirst( _ == Client(user.username, actor)).isDefined) {  //Checks user is on the clientsList
        //Client has been removed
        //sends the logout message to the rest of clients
        val logout = Json.obj(
          "type" -> "logout",
          "user" -> user.username
        )
        clientsList.foreach(client => {
          client.actor ! logout.toString()
        })
      } else {
        //TODO: THROW EXCEPTION -> CLIENT IS NOT ON THE CLIENTSLIST
      }
    }

    case SendBroadcast(message) => {
      println("SendBroadcast -> " + message)

      val json = Json.obj(
        "type" -> "message",
        "message" -> message.text,
        "user" -> message.user.username
      )

      println("Message to broadcast -> " + json)

      clientsList.foreach(client => client.actor ! json.toString())
    }

  }
}