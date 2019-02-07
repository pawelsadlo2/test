package controllers


import javax.inject._
import play.api._
import play.api.mvc._
import java.util.Calendar
import play.api.libs.json._
import play.api.libs.functional.syntax._

/**
  * This controller creates an `Action` to handle HTTP requests to the
  * application's home page.
  */
@Singleton
class HomeController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

  /**
    * Create an Action to render an HTML page.
    *
    * The configuration in the `routes` file means that this method
    * will be called when the application receives a `GET` request with
    * a path of `/`.
    */

  def index(x: Float, y: Float) = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.index(multiplication(x, y)))
  }

  def multiply(x: Float, y: Float) = Action { implicit request: Request[AnyContent] =>
    val json = Json.toJson(multiplication(x, y))
    Ok(json)
  }

  def hour() = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.hour(getHour))
  }


  def multiplication(a: Float, b: Float): Float = a * b

  def getHour: String = {
    def calInstance: Calendar = Calendar.getInstance()

    val h: Int = calInstance.get(Calendar.HOUR_OF_DAY)
    h.toString
  }

}
