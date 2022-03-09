package beans;

/**
 * @author lixu
 * @create 2022-03-02-19:17
 */
public class user1 {
    String username;
    String name;
    String password;
    int id;

    @Override
    public String toString() {
        return "user1{" +
                "username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", id=" + id +
                '}';
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String realname) {
        this.name = realname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
