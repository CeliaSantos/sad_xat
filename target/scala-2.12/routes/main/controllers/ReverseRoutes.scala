
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/celiasantos/src/SADprojects/sad_xat/conf/routes
// @DATE:Fri May 25 00:50:32 CEST 2018

import play.api.mvc.Call


import _root_.controllers.Assets.Asset

// @LINE:6
package controllers {

  // @LINE:6
  class ReverseHomeController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:11
    def chat(user:models.User): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "chat/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[models.User]].unbind("user", user)))
    }
  
    // @LINE:8
    def loginView(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "login")
    }
  
    // @LINE:9
    def performLogin(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "login")
    }
  
    // @LINE:12
    def websocket(user:models.User): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "ws/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[models.User]].unbind("user", user)))
    }
  
    // @LINE:6
    def index(): Call = {
      
      Call("GET", _prefix)
    }
  
  }

  // @LINE:17
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:17
    def at(file:String): Call = {
      implicit val _rrc = new play.core.routing.ReverseRouteContext(Map(("path", "/public")))
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[play.api.mvc.PathBindable[String]].unbind("file", file))
    }
  
  }


}
