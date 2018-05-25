
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/celiasantos/src/SADprojects/sad_xat/conf/routes
// @DATE:Fri May 25 00:50:32 CEST 2018

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset

// @LINE:6
package controllers.javascript {

  // @LINE:6
  class ReverseHomeController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:11
    def chat: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.chat",
      """
        function(user0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "chat/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[models.User]].javascriptUnbind + """)("user", user0))})
        }
      """
    )
  
    // @LINE:8
    def loginView: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.loginView",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "login"})
        }
      """
    )
  
    // @LINE:9
    def performLogin: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.performLogin",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "login"})
        }
      """
    )
  
    // @LINE:12
    def websocket: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.websocket",
      """
        function(user0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "ws/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[models.User]].javascriptUnbind + """)("user", user0))})
        }
      """
    )
  
    // @LINE:6
    def index: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.index",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + """"})
        }
      """
    )
  
  }

  // @LINE:17
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:17
    def at: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.at",
      """
        function(file1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("file", file1)})
        }
      """
    )
  
  }


}
