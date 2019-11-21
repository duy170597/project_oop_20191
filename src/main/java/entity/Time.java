package entity;

import java.util.Date;

public class Time extends Entity {
    private Date time;

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Time(Date time) {
        this.time = time;
    }

    public Time(String id, String label, String description, Date time) {
        super(id, label, description);
        this.time = time;
    }

    public String toString() {
        return super.toString() + "\ntime: " + getTime();
    }
}
