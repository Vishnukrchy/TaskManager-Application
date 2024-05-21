package com.jspider.ToDo.dto;

public class Entity {
	
	private int id ;
	private String name ;
private String toDo ;
private String  status;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getToDo() {
	return toDo;
}
public void setToDo(String toDo) {
	this.toDo = toDo;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public Entity(int id, String name, String toDo, String status) {
	super();
	this.id = id;
	this.name = name;
	this.toDo = toDo;
	this.status = status;
}
@Override
public String toString() {
	return "Entity [id=" + id + ", name=" + name + ", toDo=" + toDo + ", status=" + status + "]";
}


}
