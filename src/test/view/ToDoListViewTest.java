package test.view;

import repository.ToDoListRepository;
import repository.ToDoListRepositoryImpl;
import service.ToDoLisServiceImpl;
import service.ToDoListService;
import view.ToDoListView;

public class ToDoListViewTest {
    public static void main(String[] args) {
        testRemoveToDoList();
    }

    public static void tesShowToDoList(){
        ToDoListRepository toDoListRepository = new ToDoListRepositoryImpl();
        ToDoListService toDoListService = new ToDoLisServiceImpl(toDoListRepository);
        ToDoListView toDoListView = new ToDoListView(toDoListService);

        toDoListService.addToDoList("BELAJAR JAVA DASAR");
        toDoListService.addToDoList("BELAJAR JAVA OOP");
        toDoListService.addToDoList("BELAJAR JAVA STADART CLASSES");

        toDoListView.showToDoList();
    }

    public static void testAddToDoList(){
        ToDoListRepository toDoListRepository = new ToDoListRepositoryImpl();
        ToDoListService toDoListService = new ToDoLisServiceImpl(toDoListRepository);
        ToDoListView toDoListView = new ToDoListView(toDoListService);

        toDoListView.addToDoList();
        toDoListService.showToDoList();
        toDoListView.addToDoList();
        toDoListService.showToDoList();
    }

    public static void testRemoveToDoList(){
        ToDoListRepository toDoListRepository = new ToDoListRepositoryImpl();
        ToDoListService toDoListService = new ToDoLisServiceImpl(toDoListRepository);
        ToDoListView toDoListView = new ToDoListView(toDoListService);

        toDoListService.addToDoList("BELAJAR JAVA DASAR");
        toDoListService.addToDoList("BELAJAR JAVA OOP");
        toDoListService.addToDoList("BELAJAR JAVA STADART CLASSES");

        toDoListService.showToDoList();

        toDoListView.removeToDoList();

        toDoListService.showToDoList();
    }
}
