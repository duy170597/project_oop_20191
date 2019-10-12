package genaration;

import entity.Entity;

abstract public class EntityGenaration {
    private String[] id;		// tập các định danh
    private String[] label;	// tập các nhãn hiển thị
    private String[] description;   // tập các mô tả

    abstract public void readFile(String fileName);

    abstract public Entity[] genatate(int amount);
}
