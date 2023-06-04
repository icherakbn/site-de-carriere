package ma.enset.careerwebsite.web;

public class UserSignUpDto {
    private static String username;
    private static String password;

    public UserSignUpDto(String username, String password) {
        this.username = username;

        this.password = password;
    }

    public UserSignUpDto() {

    }

    public static String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public static String getPassword() {
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }
}
