package controllers


import play.api._
import play.api.mvc._
import models.dao.{DAOFactory,Item}

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
object Items  extends Controller {

  /**
   * Create an Action to render an HTML page.
   *
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */
  val bidDAO = DAOFactory.bidDAO

  
  
   
   
def itemsHigherBids(items: Seq[Item]) = items.map(i => (i, bidDAO.highest(i.id)))
  
}
