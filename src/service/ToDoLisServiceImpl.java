package service;

import entity.ToDoList;
import repository.ToDoListRepository;

public class ToDoLisServiceImpl implements ToDoListService{

    private ToDoListRepository toDoListRepository;

    public ToDoLisServiceImpl(ToDoListRepository toDoListRepository) {
        this.toDoListRepository = toDoListRepository;
    }

    @Override
    public void showToDoList() {
        System.out.println("TODOLIST");
        ToDoList[] model = toDoListRepository.getAll();
        for (var i = 0; i < model.length; i++ ){
            var todolist= model[i];
            var no = i + 1;

            if (todolist != null){
                System.out.println(no + ". " + todolist.getTodo());
            }
        }
    }

    @Override
    public void addToDoList(String todo) {
        ToDoList toDoList = new ToDoList(todo);
        toDoListRepository.add(toDoList);
        System.out.println("SUKSES MENAMBAH TODO : " + todo);
    }

    @Override
    public void removeToDoList(Integer number) {
        boolean success = toDoListRepository.remove(number);
        if (success){
            System.out.println("SUKSES MENGHAPUS TODO : " + number);
        }else {
            System.out.println("GAGAL MENGHAPUS TODO : " + number);
        }
    }
}
