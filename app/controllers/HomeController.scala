package controllers

import javax.inject._

import models.User
import akka.actor.ActorSystem
import play.api.data._
import play.api.data.Forms._
import play.api.mvc.PathBindable
import play.api.data.validation.Constraints._
import play.api.mvc._
import play.api.libs.streams.ActorFlow
import akka.stream.Materializer
/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class HomeController @Inject()(cc: ControllerComponents)
                              (implicit system: ActorSystem, mat: Materializer)
  extends AbstractController(cc) {

  /**
   * Create an Action to render an HTML page.
   *
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   * Redirects to the login Page
   */
  def index() = Action { implicit request: Request[AnyContent] =>
    Redirect(routes.HomeController.loginView)
  }

  /**
    *Returns the login view
    */
  def loginView = Action {
    Ok(views.html.login(LoginForm))
  }

  /**
    *
    * https://www.playframework.com/documentation/2.6.x/ScalaForms
    */
  val LoginForm = Form(
    mapping (
      "username" -> nonEmptyText
    )(User.apply)(User.unapply)
  )
  /**
    * Checks login:
    *   Success: redirects to the chat page
    *   Failure: HTTP 400 -> Bad request
    */
  def performLogin = Action { implicit request =>
    LoginForm.bindFromRequest.fold(
      formWithErrors => {
        // binding failure, you retrieve the form containing errors:
        BadRequest(views.html.login(formWithErrors))

      },
      userData => {
        /* binding success, you get the actual value. */
        println("userData: "+userData)
        Redirect(routes.HomeController.chat(userData))
      }
    )
  }

  /**
    * Returns the chat view of the User user
    */
  def chat(user:User) = Action {
    Ok(views.html.chat(user))
  }

  /**
    * Websocket entry point using actors
    * docs: https://www.playframework.com/documentation/2.6.x/ScalaWebSockets
    */
  def websocket(user: User) = WebSocket.accept[String, String] { request =>
    ActorFlow.actorRef { out =>
      MyWebSocketActor.props(out, user)
    }
  }
}
