package controllers

import play.api._
import play.api.mvc._

import play.api.data._
import play.api.data.Forms._

import models.Task
import models.User
  
object Application extends Controller {
  
  def  taskForm = Form(
		  "label" -> nonEmptyText
  )
  def index = Action {
//     Ok(views.html.index("Your new application is ready!!!."))
//     Ok("Hello World");
    Redirect( routes.Application.tasks)
  }
  
  def tasks = Action {
	  Ok(views.html.index(Task.all(), taskForm))
  
  }
  
  def newTask = Action { implicit request =>
    taskForm.bindFromRequest.fold(
        errors => BadRequest(views.html.index(Task.all(), errors)),
        label => {
        	Task.create(label)
        	Redirect(routes.Application.tasks)
        })
  }
  
  def deleteTask(id: Long) = Action {
		  Task.delete(id)
		  Redirect(routes.Application.tasks)
  }
  
  def deleteUser(id: Long) = Action {
	  	  User.delete(id)
	  	  Redirect(routes.Application.tasks)
  }
  
  def newUser = TODO
  def users = TODO
}