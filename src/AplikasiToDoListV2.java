import repository.ToDoListRepository;
import repository.ToDoListRepositoryImpl;
import service.ToDoLisServiceImpl;
import service.ToDoListService;
import view.ToDoListView;

public class AplikasiToDoListV2 {

    public static void main(String[] args) {
        ToDoListRepository toDoListRepository = new ToDoListRepositoryImpl();
        ToDoListService toDoListService = new ToDoLisServiceImpl(toDoListRepository);
        ToDoListView toDoListView = new ToDoListView(toDoListService);

        toDoListView.showToDoList();
    }
}
