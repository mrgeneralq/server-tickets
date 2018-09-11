package me.mrgeneralq.servertickets.interfaces;

import java.util.List;

public interface IRepository<T> {

	void create(T object);
	void delete(T object);
	void update(T object);
	boolean exists(T id);
	T get(int id);
	List<T> getAll();
}
