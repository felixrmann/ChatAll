/**
 * @author Felix Mann
 * @version 1.0
 * @since 2020-März-09
 */

public class User {

    private String name;
    private GetMyIPAddress ip;

    public User(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GetMyIPAddress setIp() {
        ip = new GetMyIPAddress();
        return ip;
    }
    public GetMyIPAddress getIp(){
        return ip;
    }
}
