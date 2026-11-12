package edu.utd.studentlife;

/** Thrown when a student tries to RSVP to an event that has reached capacity. */
public class EventFullException extends Exception {
    public EventFullException(String eventID) {
        super("Event " + eventID + " is full");
    }
}
