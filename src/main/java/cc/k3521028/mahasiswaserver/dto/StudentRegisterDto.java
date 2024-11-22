package cc.k3521028.mahasiswaserver.dto;

public class StudentRegisterDto extends StudentDto {
    private String password;
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
