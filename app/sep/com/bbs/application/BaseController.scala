package sep.com.bbs.application

import play.api.libs.json.Json
import play.api.mvc.Controller
import sep.com.bbs.application.services.AuthService
import sep.com.bbs.infra.util.BbsLog

import scala.util.parsing.json.JSONObject

trait BaseController extends Controller with AuthService{

  def notFoundException(fName: String, e: Throwable) = {
    BbsLog.debug(s"[Exception][{fName}] failed:" +  e.getMessage )
    NotFound(JSONObject(Map("exception" -> e.getMessage)).toString())
  }

  def internalServerError(fName: String, e: Throwable) = {
    BbsLog.debug(s"[Exception][{fName}] failed:" +  e.getMessage )
    InternalServerError(JSONObject(Map("exception" -> e.getMessage)).toString())
  }

}
