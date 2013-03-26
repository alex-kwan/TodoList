package models

import anorm._
import anorm.SqlParser._

import play.api.db._
import play.api.Play.current

case class User(id: Long, name: String)
object User {
  
  val user = {
  get[Long]("id") ~ 
  get[String]("name") map {
    case id~name => User(id, name)
  }
}
  
//  def all(): List[Task] = Nil
  def all(): List[User] = DB.withConnection { implicit c =>
  SQL("select * from user").as(user *)
}
 def create(name: String) {
  DB.withConnection { implicit c =>
    SQL("insert into user (name) values ({name})").on(
      'name -> name
    ).executeUpdate()
  }
}

def delete(id: Long) {
  DB.withConnection { implicit c =>
    SQL("delete from user where id = {id}").on(
      'id -> id
    ).executeUpdate()
  }
}
}