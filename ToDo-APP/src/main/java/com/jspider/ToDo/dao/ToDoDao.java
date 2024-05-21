package com.jspider.ToDo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jspider.ToDo.connection.EntityConnection;
import com.jspider.ToDo.dto.Entity;

public class ToDoDao {

	Connection connection = EntityConnection.getConnection();

	public boolean addToDo(Entity e) {
		boolean insert = false;
		String insertQry = "insert into todo(name,todo,status) values(?,?,?)";

		try {
			PreparedStatement ps = connection.prepareStatement(insertQry);
			ps.setString(1, e.getName());
			ps.setString(2, e.getToDo());
			ps.setString(3, e.getStatus());

			int i = ps.executeUpdate();

			if (i == 1) {
				insert = true;
			}

		} catch (Exception e2) {
			// TODO: handle exception
		}
		return insert;
	}

	public List<Entity> getAllToDodetails() {
		List<Entity> list = new ArrayList<>();

		String displayQry = "Select * From Todo";
		try {
			PreparedStatement ps = connection.prepareStatement(displayQry);

			ResultSet result = ps.executeQuery();

			while (result.next()) {
				int id = result.getInt("id");
				String name = result.getString("name");
				String todo = result.getString("todo");
				String status = result.getString("status");

				Entity e = new Entity(id, name, todo, status);
				list.add(e);

			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

	public int deleteToDo(int id) {
		String deleteQry = "Delete from todo where id =?";
		try {
			PreparedStatement ps = connection.prepareStatement(deleteQry);
			ps.setInt(1, id);

			int result = ps.executeUpdate();

			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}

	public Entity getAllToDoBy__id(int id) {
		String selctQry = "select * from todo where id=?";
		PreparedStatement ps;
		Entity e = null;
		try {
			ps = connection.prepareStatement(selctQry);
			ps.setInt(1, id);

			ps.execute();
			ResultSet result = ps.executeQuery();
			while (result.next()) {
				int id1 = result.getInt("id");
				String name = result.getString("name");
				String todo = result.getString("todo");
				String status = result.getString("status");

				e = new Entity(id1, name, todo, status);
			}
			return e;

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return null;
		}

	}

	public int updateToDo(Entity e) {
		String updateQry = "Update Todo set name=?,todo=?,status=? where id=?";
		try {
			PreparedStatement ps = connection.prepareStatement(updateQry);
			ps.setString(1, e.getName());
			ps.setString(2, e.getToDo());
			ps.setString(3, e.getStatus());
			ps.setInt(4, e.getId());

			int i = ps.executeUpdate();
			return i;
		} catch (SQLException e1) {
			e1.printStackTrace();
			return 0;
		}
	}
}
