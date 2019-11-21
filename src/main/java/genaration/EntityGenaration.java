package genaration;

import entity.Entity;

abstract public class EntityGenaration {
    private String[] id;		// tập các định danh
    private String[] label;	// tập các nhãn hiển thị
    private String[] description;   // tập các mô tả

    abstract public EntityGenaration loadFromFile(String fileName);

    abstract public Entity[] genarate(int amount);

    public String[] getId() {
        return id;
    }

    public void setId(String[] id) {
        this.id = id;
    }

    public String[] getLabel() {
        return label;
    }

    public void setLabel(String[] label) {
        this.label = label;
    }

    public String[] getDescription() {
        return description;
    }

    public void setDescription(String[] description) {
        this.description = description;
    }
}
