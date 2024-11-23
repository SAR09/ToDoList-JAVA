public class AplikasiToDoList {

    public static String[] model = new String[10];

    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args) {

        viewShowToDoList();

    }

    /**
     * Menampilkan todo list
     */
    public static void showToDoList(){
        System.out.println("TODOLIST");
        for (var i = 0; i < model.length; i++ ){
            var todo = model[i];
            var no = i + 1;

            if (todo != null){
                System.out.println(no + ". " + todo);
            }
        }
    }

    public static void testShowToDoList(){
        model[0] = "Belajar Java Dasar";
        model[1] = "Studi kasus java dasar : aplikasi todo list";
        showToDoList();
    }

    /**
     * Menambah todo ke list
     */
    public static void addToDoList(String todo){
        var isFull = true;
        // cek apakah model penuh?
        for (int i = 0; i < model.length; i++){
            if (model[i] == null){
                //model masih ada yang kosong
                isFull = false;
                break;
            }
        }

        // jika penuh kita resize ukuran array 2 kali lipat
        if (isFull){
            var temp = model;
            model = new String[model.length * 2];

            for (int i = 0; i < temp.length; i++){
                model[i] = temp[i];
            }
        }

        // tambahkan ke posisi yang data array nya null
        for (var i = 0; i < model.length; i++){
            if (model[i] == null){
                model[i] = todo;
                break;
            }
        }


    }

    public static void testAddToDoList(){
        for (int i = 0; i < 25; i++) {
            addToDoList("Contoh Tod ke. " + i);
        }

        showToDoList();
    }


    /**
     * Menghapus todo dari list
     */
    public static boolean removeToDoList(Integer number){

        if ((number - 1) >= model.length){
            return false;
        }else if (model[number - 1] == null){
            return false;
        }else {
            for (int i = (number - 1) ; i < model.length; i++) {
                if (i == (model.length - 1)){
                    model[i] = null;
                }else {
                    model[i] = model[i + 1];
                }
            }
            return true;
        }
    }

    public static void testRemoveTodoList(){
        addToDoList("Satu");
        addToDoList("dua");
        addToDoList("tiga");
        addToDoList("empat");
        addToDoList("lima");

        var result = removeToDoList(20);
        System.out.println(result);

        result = removeToDoList(7);
        System.out.println(result);

        result = removeToDoList(2);
        System.out.println(result);

        showToDoList();
    }

    public static String input(String info){
        System.out.print(info + " : " );
        String data = scanner.nextLine();
        return data;
    }

    public static void testInput(){
        var name = input("Nama");
        System.out.println("Hi " + name);

    }

    /**
     * Menampilkan view todo list
     */
    public static void viewShowToDoList(){
        while (true){
            showToDoList();

            System.out.println("Menu : ");
            System.out.println("1. Tambah");
            System.out.println("2. Hapus");
            System.out.println("x. Keluar");

            var input = input("Pilih");
            if (input.equals("1")){
                viewAddToDoList();
            }else if (input.equals("2")){
                viewRemoveToDoList();
            } else if(input.equals("x")) {
                break;
            } else {
                System.out.println("Pilihan tidak dimengerti");
            }
        }
    }

    public static void testViewShowToDoList(){
        addToDoList("Satu");
        addToDoList("Dua");
        addToDoList("Tiga");
        addToDoList("Empat");
        addToDoList("Lima");
        viewShowToDoList();
    }

    /**
     * Menampilkan view menambah todo list
     */
    public static void viewAddToDoList(){
        System.out.println("MENAMBAH TODOLIST");

        var todo = input("Todo (x jika batal)");

        if (todo.equals("x")){
            //batal
        }else {
            addToDoList(todo);
        }
    }

    public static void testViewAddTodoList(){
        addToDoList("Satu");
        addToDoList("Dua");

        viewAddToDoList();

        showToDoList();
    }

    /**
     * Menampilkan view menghapus todo list
     */
    public static void viewRemoveToDoList(){
        System.out.println("MENGHAPUS TODOLIST");

        var number = input("Nomor yang dihapus (x jika batal)");

        if (number.equals("x")){
            //batal
        }else {
           boolean success = removeToDoList(Integer.valueOf(number));
           if (!success){
               System.out.println("Gagal menghapus todolist : " + number);
           }
        }
    }

    public static void testViewRemoveToDoList(){
        addToDoList("Satu");
        addToDoList("Dua");
        addToDoList("Tiga");

        showToDoList();

        viewRemoveToDoList();

        showToDoList();
    }
}
