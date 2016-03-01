package controllers

import play.api._
import play.api.mvc._

object HtmlController extends Controller{

  def showArticleListScreen: Action[AnyContent] = Action{
    Ok(views.html.article.list())
  }

}
