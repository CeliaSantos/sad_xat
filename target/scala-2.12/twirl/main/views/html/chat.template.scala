
package views.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

object chat extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[User,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(user: User):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.14*/("""

"""),_display_(/*3.2*/index/*3.7*/ {_display_(Seq[Any](format.raw/*3.9*/("""
    """),format.raw/*4.5*/("""<div class="row collapse">
        <div class="large-12 columns panel">
            <div class="row">
                <div class="small-12 large-8 columns text-left">
                    <h2>
                        <span> user: """),_display_(/*9.39*/user/*9.43*/.username),format.raw/*9.52*/("""</span>
                    </h2>
                </div>
                <div class="small-12 large-4 columns text-right">
                    <a class="button alert small" id="logout" href=""""),_display_(/*13.70*/routes/*13.76*/.HomeController.index()),format.raw/*13.99*/("""">Logout</a>
                </div>
            </div>
            <div class="row">
                <div class="large-12 columns">
                    <div id="output"></div>
                </div>
            </div>
            <div class="row">
                <div class="large-12 columns">
                    <div class="row collapse">
                        <div class="large-9 columns">
                            <input class="w3-input w3-hover-grey" type="text" id="message" placeholder="Write something..."/>
                        </div>
                        <div class="large-3 columns">
                            <button id="send" class="button postfix">Send</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
""")))}/*35.2*/{_display_(Seq[Any](format.raw/*35.3*/("""
    """),format.raw/*36.5*/("""<script src=""""),_display_(/*36.19*/routes/*36.25*/.Assets.at("javascripts/webSocket.js")),format.raw/*36.63*/(""""></script>

    <script type="text/javascript">
        var load = function () """),format.raw/*39.32*/("""{"""),format.raw/*39.33*/("""

            """),format.raw/*41.13*/("""//initialize the webSocket with the init method form the websocket.js file
            initWebsocket('"""),_display_(/*42.29*/routes/*42.35*/.HomeController.websocket(user)),format.raw/*42.66*/("""');

            $('#message').focus();

            $('#send').click(function (e) """),format.raw/*46.43*/("""{"""),format.raw/*46.44*/("""
                """),format.raw/*47.17*/("""var message =  $('#message').val();
                if(message) """),format.raw/*48.29*/("""{"""),format.raw/*48.30*/("""
                    """),format.raw/*49.21*/("""doSend(message);
                    $('#message').val("");
                """),format.raw/*51.17*/("""}"""),format.raw/*51.18*/("""
                """),format.raw/*52.17*/("""$('#message').focus();
            """),format.raw/*53.13*/("""}"""),format.raw/*53.14*/(""");

            //also doSend the text when user hits return on the input
            $('#message').keypress(function(e) """),format.raw/*56.48*/("""{"""),format.raw/*56.49*/("""
                """),format.raw/*57.17*/("""if(e.which == 13) """),format.raw/*57.35*/("""{"""),format.raw/*57.36*/("""
                    """),format.raw/*58.21*/("""$('#send').click();
                """),format.raw/*59.17*/("""}"""),format.raw/*59.18*/("""
            """),format.raw/*60.13*/("""}"""),format.raw/*60.14*/(""");

            $('#logout').click(function (e) """),format.raw/*62.45*/("""{"""),format.raw/*62.46*/("""
                """),format.raw/*63.17*/("""performLogout();
            """),format.raw/*64.13*/("""}"""),format.raw/*64.14*/(""");
        """),format.raw/*65.9*/("""}"""),format.raw/*65.10*/(""";

        $(window).on('load', load);
    </script>
""")))}),format.raw/*69.2*/("""

"""))
      }
    }
  }

  def render(user:User): play.twirl.api.HtmlFormat.Appendable = apply(user)

  def f:((User) => play.twirl.api.HtmlFormat.Appendable) = (user) => apply(user)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Fri May 25 04:34:40 CEST 2018
                  SOURCE: /home/celiasantos/src/SADprojects/sad_xat/app/views/chat.scala.html
                  HASH: 14de41f77b7d7a23c2360645604de0f347aa6e18
                  MATRIX: 726->1|833->13|861->16|873->21|911->23|942->28|1198->258|1210->262|1239->271|1458->463|1473->469|1517->492|2352->1309|2390->1310|2422->1315|2463->1329|2478->1335|2537->1373|2645->1453|2674->1454|2716->1468|2846->1571|2861->1577|2913->1608|3024->1691|3053->1692|3098->1709|3190->1773|3219->1774|3268->1795|3372->1871|3401->1872|3446->1889|3509->1924|3538->1925|3687->2046|3716->2047|3761->2064|3807->2082|3836->2083|3885->2104|3949->2140|3978->2141|4019->2154|4048->2155|4124->2203|4153->2204|4198->2221|4255->2250|4284->2251|4322->2262|4351->2263|4435->2317
                  LINES: 21->1|26->1|28->3|28->3|28->3|29->4|34->9|34->9|34->9|38->13|38->13|38->13|60->35|60->35|61->36|61->36|61->36|61->36|64->39|64->39|66->41|67->42|67->42|67->42|71->46|71->46|72->47|73->48|73->48|74->49|76->51|76->51|77->52|78->53|78->53|81->56|81->56|82->57|82->57|82->57|83->58|84->59|84->59|85->60|85->60|87->62|87->62|88->63|89->64|89->64|90->65|90->65|94->69
                  -- GENERATED --
              */
          