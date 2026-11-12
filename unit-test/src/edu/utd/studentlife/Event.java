package edu.utd.studentlife;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/** Campus event that students can RSVP to (FR-4, FR-9, UC-2). */
public class Event {
    private final String eventID;
    private final String title;
    private final LocalDateTime dateTime;
    private final int capacity;
    private final List<RSVP> rsvps = new ArrayList<>();

    public Event(String eventID, String title, LocalDateTime dateTime, int capacity) {
        if (capacity < 1) {
            throw new IllegalArgumentException("capacity must be at least 1");
        }
        this.eventID = eventID;
        this.title = title;
        this.dateTime = dateTime;
        this.capacity = capacity;
    }

    /** Number of active (non-cancelled) RSVPs. */
    public int getRSVPCount() {
        int count = 0;
        for (RSVP r : rsvps) {
            if (r.isActive()) count++;
        }
        return count;
    }

    public boolean isFull() {
        return getRSVPCount() >= capacity;
    }

    /**
     * UNIT UNDER TEST. Saves an RSVP for the student if the event has space.
     * Rejects the RSVP if the event is full or the student already has an active RSVP.
     */
    public RSVP addRSVP(String studentID) throws EventFullException {
        for (RSVP r : rsvps) {
            if (r.isActive() && r.getStudentID().equals(studentID)) {
                throw new IllegalStateException("Student " + studentID + " already RSVP'd");
            }
        }
        if (isFull()) {
            throw new EventFullException(eventID);
        }
        RSVP rsvp = new RSVP(eventID + "-" + (rsvps.size() + 1), studentID);
        rsvps.add(rsvp);
        return rsvp;
    }

    public String getEventID() { return eventID; }
    public String getTitle() { return title; }
    public LocalDateTime getDateTime() { return dateTime; }
    public int getCapacity() { return capacity; }
}
