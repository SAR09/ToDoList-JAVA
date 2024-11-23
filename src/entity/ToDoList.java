package entity;

public class ToDoList {

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
}
