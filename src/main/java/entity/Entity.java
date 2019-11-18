package entity;

public class Entity {
    private String id;		// định danh
    private String label;	// nhãn hiển thị
    private String description;	// mô tả

    public String getId() {
    	return id;
    }

    public String getLabel() {
    	return label;
    }

    public String getDescription() {
    	return description;
    }

    public void setId(String id) {
    	this.id = id;
    }

    public void setLabel(String label) {
    	this.label = label;
    }

    public void setDescription(String description) {
    	this.description = description;
    }
}

