package com.example.home;

public class BaseEntity {
    private boolean sex;

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "BaseEntity{" +
                "sex=" + sex +
                '}';
    }
}
