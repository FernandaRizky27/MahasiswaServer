package cc.k3521028.mahasiswaserver.dto;

import java.util.ArrayList;

public class OutputDto <T> {
    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private T data;
    private String message;
}
