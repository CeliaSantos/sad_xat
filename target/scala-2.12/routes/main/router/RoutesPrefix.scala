
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/celiasantos/src/SADprojects/sad_xat/conf/routes
// @DATE:Fri May 25 00:50:32 CEST 2018


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
