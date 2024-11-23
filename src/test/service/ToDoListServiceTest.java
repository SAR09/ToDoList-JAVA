package test.service;

import entity.ToDoList;
import repository.ToDoListRepository;
import repository.ToDoListRepositoryImpl;
import service.ToDoLisServiceImpl;
import service.ToDoListService;

public class ToDoListServiceTest {

    public static void main(String[] args) {
        testRemoveToDoList();
    }

    public static void testShowToDoList(){
        ToDoListRepositoryImpl toDoListRepository = new ToDoListRepositoryImpl();
        toDoListRepository.data[0] = new ToDoList("Belajar Java Dasar");
        toDoListRepository.data[1] = new ToDoList("Belajar Java OOP");
        toDoListRepository.data[2] = new ToDoList("Belajar Java Standart Classes");
        ToDoListService toDoListService = new ToDoLisServiceImpl(toDoListRepository);

        toDoListService.showToDoList();
    }

    public static void testAddToDoList(){
        ToDoListRepository toDoListRepository = new ToDoListRepositoryImpl();
        ToDoListService toDoListService = new ToDoLisServiceImpl(toDoListRepository);

        toDoListService.addToDoList("Belajar Java Dasar");
        toDoListService.addToDoList("Belajar Java OOP");
        toDoListService.addToDoList("Belajar Java Standart Classes");

        toDoListService.showToDoList();
    }

    public static void testRemoveToDoList(){
        ToDoListRepository toDoListRepository = new ToDoListRepositoryImpl();
        ToDoListService toDoListService = new ToDoLisServiceImpl(toDoListRepository);

        toDoListService.addToDoList("Belajar Java Dasar");
        toDoListService.addToDoList("Belajar Java OOP");
        toDoListService.addToDoList("Belajar Java Standart Classes");

        toDoListService.showToDoList();

        toDoListService.removeToDoList(5);
        toDoListService.removeToDoList(2);
        toDoListService.showToDoList();
    }
}
