
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

object login extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[Form[User],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(loginForm: Form[User]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.25*/("""

"""),_display_(/*3.2*/index/*3.7*/{_display_(Seq[Any](format.raw/*3.8*/("""
  """),_display_(/*4.4*/helper/*4.10*/.form(action = routes.HomeController.performLogin())/*4.62*/ {_display_(Seq[Any](format.raw/*4.64*/("""
    """),format.raw/*5.5*/("""<div class="row collapse">
      <div class="small-12 large-8 columns text-left">
        <span class="prefix">User name</span>
      </div>
      <div class="small-7 large-8 columns">
        <input class="w3-input w3-hover-grey" type="text" id="username" name="username" placeholder="Write your name" required="true" />
      </div>
    </div>
    <div class="row collapse">
      <div class="small-8 large-6 columns large-offset-3 small-offset-2">
        <button class="x-loggin-button button" type="submit">Access to chat -></button>
      </div>
    </div>
  """)))}),format.raw/*18.4*/("""
""")))}/*19.2*/{_display_(Seq[Any](format.raw/*19.3*/("""

""")))}),format.raw/*21.2*/("""
"""))
      }
    }
  }

  def render(loginForm:Form[User]): play.twirl.api.HtmlFormat.Appendable = apply(loginForm)

  def f:((Form[User]) => play.twirl.api.HtmlFormat.Appendable) = (loginForm) => apply(loginForm)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Fri May 25 04:46:30 CEST 2018
                  SOURCE: /home/celiasantos/src/SADprojects/sad_xat/app/views/login.scala.html
                  HASH: a441fd041451f2f42f5772a84686a6d7502158a3
                  MATRIX: 733->1|851->24|879->27|891->32|928->33|957->37|971->43|1031->95|1070->97|1101->102|1697->668|1717->670|1755->671|1788->674
                  LINES: 21->1|26->1|28->3|28->3|28->3|29->4|29->4|29->4|29->4|30->5|43->18|44->19|44->19|46->21
                  -- GENERATED --
              */
          