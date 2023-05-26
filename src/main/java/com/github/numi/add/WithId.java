package com.github.numi.add;

public class WithId<T> {
    private T data;
    private Long id;

    protected WithId() {}

    public WithId(T data, Long id) {
        this.data = data;
        this.id = id;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
