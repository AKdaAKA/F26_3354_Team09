package edu.utd.studentlife;

import static org.junit.Assert.*;

import java.time.LocalDateTime;
import org.junit.Before;
import org.junit.Test;

public class EventRSVPTest {
    private Event event;

    @Before
    public void setUp() {
        event = new Event("E100", "Board Game Night", LocalDateTime.of(2026, 11, 20, 19, 0), 2);
    }

    /** TC-1: RSVP when space is available is saved and the count updates. */
    @Test
    public void tc1_rsvpWithSpaceIsSaved() throws Exception {
        RSVP r = event.addRSVP("S001");
        assertEquals(RSVP.CONFIRMED, r.getStatus());
        assertEquals(1, event.getRSVPCount());
        assertFalse(event.isFull());
    }

    /** TC-2: RSVP to a full event is rejected and the count does not change. */
    @Test
    public void tc2_rsvpToFullEventIsRejected() throws Exception {
        event.addRSVP("S001");
        event.addRSVP("S002");
        assertTrue(event.isFull());
        try {
            event.addRSVP("S003");
            fail("Expected EventFullException");
        } catch (EventFullException expected) {
            // expected
        }
        assertEquals(2, event.getRSVPCount());
    }

    /** TC-3: Cancelling an RSVP frees a seat so another student can join. */
    @Test
    public void tc3_cancelFreesSeat() throws Exception {
        RSVP first = event.addRSVP("S001");
        event.addRSVP("S002");
        first.cancel();
        assertEquals(1, event.getRSVPCount());
        assertFalse(event.isFull());
        event.addRSVP("S003");
        assertEquals(2, event.getRSVPCount());
    }

    /** TC-4: The same student cannot RSVP twice to the same event. */
    @Test(expected = IllegalStateException.class)
    public void tc4_duplicateRsvpIsRejected() throws Exception {
        event.addRSVP("S001");
        event.addRSVP("S001");
    }

    /** TC-5: An event cannot be created with a capacity below 1. */
    @Test(expected = IllegalArgumentException.class)
    public void tc5_invalidCapacityIsRejected() {
        new Event("E101", "Empty Event", LocalDateTime.of(2026, 11, 21, 18, 0), 0);
    }
}
