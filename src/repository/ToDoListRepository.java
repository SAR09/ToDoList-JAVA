package repository;

import entity.ToDoList;

public interface ToDoListRepository {

    ToDoList[] getAll();

    void add(ToDoList toDoList);

    boolean remove(Integer number);
}
