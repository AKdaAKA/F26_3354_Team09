package edu.utd.studentlife;

/** One student's RSVP to one event (see Class Diagram 2.5.2). */
public class RSVP {
    public static final String CONFIRMED = "CONFIRMED";
    public static final String CANCELLED = "CANCELLED";

    private final String rsvpID;
    private final String studentID;
    private String status;

    public RSVP(String rsvpID, String studentID) {
        this.rsvpID = rsvpID;
        this.studentID = studentID;
        this.status = CONFIRMED;
    }

    public void cancel() { this.status = CANCELLED; }

    public boolean isActive() { return CONFIRMED.equals(status); }
    public String getRsvpID() { return rsvpID; }
    public String getStudentID() { return studentID; }
    public String getStatus() { return status; }
}
