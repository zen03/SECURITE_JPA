package dao;


import java.util.List;

import entities.User;

public interface IUser {
	public int add(User user);
	public int delete(int idU);
	public int update(User user);
	public List<User> liste();
	public User getServeurById(int idU);
}
