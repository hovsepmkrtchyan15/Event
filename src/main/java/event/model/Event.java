package event.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Event {
    private int id;
    private String name;
    private String place;
    private String isOnline;
    private double price;
    private String eventType;

    public Event(String name, String place, String isOnline, double price, String eventType) {
        this.name = name;
        this.place = place;
        this.isOnline = isOnline;
        this.price = price;
        this.eventType = eventType;
    }
}
