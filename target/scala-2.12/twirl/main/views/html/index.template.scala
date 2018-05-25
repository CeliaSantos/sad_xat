
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

object index extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[Html,Html,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(mainContent: Html)(javascriptContent: Html):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.46*/("""
"""),format.raw/*2.1*/("""<!DOCTYPE html>

<html class="no-js" lang="en" >
  <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>!! SAD XAT !!</title>
    <link rel="stylesheet" type="text/css" href="/assets/stylesheets/index.css">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <script src=""""),_display_(/*11.19*/routes/*11.25*/.Assets.at("stylesheets/index.css")),format.raw/*11.60*/(""""></script>
  </head>
  <body class="color=black">
    <div class="center row">
      <div class="large-12 columns x-xat-panel">
        <div class="row">
          <div class="large-12 columns text-center">
            <h1 class="w3-back" style="text-shadow:1px px"><a href="http://soft0.upc.edu/~francesc/assd/"> SAD </a></h1>
          </div>
        </div>
        """),_display_(/*21.10*/mainContent),format.raw/*21.21*/("""
      """),format.raw/*22.7*/("""</div>
    </div>
      <script src=""""),_display_(/*24.21*/routes/*24.27*/.Assets.at("javascripts/jquery.js")),format.raw/*24.62*/(""""></script>
      """),_display_(/*25.8*/javascriptContent),format.raw/*25.25*/("""
  """),format.raw/*26.3*/("""</body>
</html>"""))
      }
    }
  }

  def render(mainContent:Html,javascriptContent:Html): play.twirl.api.HtmlFormat.Appendable = apply(mainContent)(javascriptContent)

  def f:((Html) => (Html) => play.twirl.api.HtmlFormat.Appendable) = (mainContent) => (javascriptContent) => apply(mainContent)(javascriptContent)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Fri May 25 04:41:21 CEST 2018
                  SOURCE: /home/celiasantos/src/SADprojects/sad_xat/app/views/index.scala.html
                  HASH: 9e4fc7fc6374d9b047d55a86bd2e9a99bdf91e34
                  MATRIX: 732->1|871->45|898->46|1291->412|1306->418|1362->453|1759->823|1791->834|1825->841|1890->879|1905->885|1961->920|2006->939|2044->956|2074->959
                  LINES: 21->1|26->1|27->2|36->11|36->11|36->11|46->21|46->21|47->22|49->24|49->24|49->24|50->25|50->25|51->26
                  -- GENERATED --
              */
          