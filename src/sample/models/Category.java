package sample.models;

public class Category {
    private Long id;
    private String name;
    private int active;

    public Category(String name, int active) {
        this.name = name;
        this.active = active;
    }

    public Category() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int isActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return
                ", name='" + name + '\'' +
                ", active=" + active ;

    }
}
