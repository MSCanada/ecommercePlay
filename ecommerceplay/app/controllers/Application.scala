package controllers

import play.api._
import play.api.Play.current
import play.api.data._
import play.api.cache.Cached
import play.api.data.Forms._
import play.api.i18n.Lang
import play.api.mvc._
import play.api.templates.Html

import models._
import models.dao._
import views._
/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */

object Application extends Controller {

  /**
   * Create an Action to render an HTML page.
   *
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */
  
   val categoryDAO = DAOFactory.categoryDAO
   val itemDAO = DAOFactory.itemDAO
    def mainMenu(implicit request: Request[AnyContent]) = html.menu(categoryDAO.all())
  def index = Action { implicit request =>
    Ok(html.index(body = html.body(Items.itemsHigherBids(itemDAO.all(false))), menu = mainMenu))
  }
  
  

  
}
