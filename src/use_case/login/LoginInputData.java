public class LoginInputData {

    final private int id;
    final private String name;
    final private String password;

    public LoginInputData(int id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    String getId(){
        return id;
    }
    String getName(){
        return name;
    }
    String getPassword(){
        return password;
    }
}