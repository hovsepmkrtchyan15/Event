package event.model;

import event.enums.EventType;
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
    private EventType eventType;

    public Event(String name, String place, String isOnline, double price, EventType eventType) {
        this.name = name;
        this.place = place;
        this.isOnline = isOnline;
        this.price = price;
        this.eventType = eventType;
    }
}
