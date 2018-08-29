package com.lz.po;

public class InterViewQuestion {
    private int id;
    private String name;
    private String path;
    private String kind;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPath() {
        return path;
    }
    public void setPath(String path) {
        this.path = path;
    }
    public String getKind() {
        return kind;
    }
    public void setKind(String kind) {
        this.kind = kind;
    }
    @Override
    public String toString() {
        return "InterViewQuestion [id=" + id + ", name=" + name + ", path=" + path + ", kind=" + kind + "]";
    }

}
