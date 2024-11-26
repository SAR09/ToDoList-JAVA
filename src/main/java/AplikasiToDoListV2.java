import repository.ToDoListRepository;
import repository.ToDoListRepositoryImpl;
import service.ToDoLisServiceImpl;
import service.ToDoListService;
import util.DatabaseUtil;
import view.ToDoListView;

import javax.sql.DataSource;

public class AplikasiToDoListV2 {

    public static void main(String[] args) {
        DataSource dataSource = DatabaseUtil.getDataSource();
        ToDoListRepository toDoListRepository = new ToDoListRepositoryImpl(dataSource);
        ToDoListService toDoListService = new ToDoLisSer1viceImpl(toDoListRepository);
        ToDoListView toDoListView = new ToDoListView(toDoListService);

        toDoListView.showToDoList();
    }
}
