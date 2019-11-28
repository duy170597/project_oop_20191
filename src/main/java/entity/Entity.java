package entity;

public class Entity {
    public static int numberTypeEntity = 7;    // số loại thực thể

    private String id;		// định danh
    private String label;	// nhãn hiển thị
    private String description;	// mô tả

    public Entity() {
    }

    public Entity(String id, String label, String description) {
        this.id = id;
        this.label = label;
        this.description = description;
    }

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

    public String toString() {
        return "\nid: " + id + "\nlabel: " + label + "\ndescription: " + description;
    }
}

