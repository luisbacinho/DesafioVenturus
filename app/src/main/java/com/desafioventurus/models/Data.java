package com.desafioventurus.models;

public class Data<T> {
    private T data;
    private boolean success;
    private int status;

    public Data(T data, boolean success, int status) {
        this.data = data;
        this.success = success;
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
