package edu.utd.studentlife;

import org.junit.runner.Description;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;

/** Runs EventRSVPTest and prints PASS/FAIL per test case. */
public class VerboseRunner {
    public static void main(String[] args) {
        JUnitCore core = new JUnitCore();
        final java.util.Set<String> failed = new java.util.HashSet<>();
        core.addListener(new RunListener() {
            @Override public void testFailure(Failure f) { failed.add(f.getDescription().getMethodName()); }
            @Override public void testFinished(Description d) {
                System.out.println((failed.contains(d.getMethodName()) ? "FAIL  " : "PASS  ") + d.getMethodName());
            }
        });
        Result r = core.run(EventRSVPTest.class);
        System.out.println("Tests run: " + r.getRunCount() + ", Failures: " + r.getFailureCount()
                + ", Time: " + r.getRunTime() + " ms");
        System.out.println(r.wasSuccessful() ? "OK" : "FAILED");
    }
}
