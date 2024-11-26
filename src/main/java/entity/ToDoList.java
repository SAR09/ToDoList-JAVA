package entity;

public class ToDoList {

    private Integer id;

    private String todo;

    public ToDoList() {
    }

    public ToDoList(String todo) {
        this.todo = todo;
    }


    public String getTodo() {
        return todo;
    }

    public void setTodo(String todo) {
        this.todo = todo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
