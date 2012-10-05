package controllers

import play.api._
import play.api.data._
import play.api.data.Forms._
import play.api.mvc._
import jewecalc.Material._
import jewecalc.Unit._
import models._

object Application extends Controller {

  val form: Form[Jewellery] = Form(
    // Defines a mapping that will handle Contact values
    mapping(
      "material" -> nonEmptyText,
      "unit" -> nonEmptyText,
      "pricePerUnit" -> number,
      "probe" ->  optional(number),
      "weight"  -> optional(number)
      )(Jewellery.apply)(Jewellery.unapply)
  )

  def showCalc = Action{
    Ok( views.html.calc( form ) )
  }

  def calculate = Action{ implicit request=>
    form.bindFromRequest().fold(
      errors=>{
        println("Like ERR")
        BadRequest(views.html.calc(errors))
      },
      jewellery=>{
        println("Like OK, " + jewellery.weight)
        Ok(views.html.calc(form))
      }
    )
  }
  
}