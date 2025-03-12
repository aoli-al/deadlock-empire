package org.pastalab.deadlockempire;

import org.junit.jupiter.api.extension.ExtendWith;
import org.pastalab.fray.junit.junit5.FrayTestExtension;
import org.pastalab.fray.junit.junit5.annotations.ConcurrencyTest;

/**
 * Translation of "Boolean Flags Are Enough For Everyone" from The Deadlock Empire
 *
 * This demonstrates how two threads can both enter a critical section when using
 * a simple boolean flag as a mutex.
 *
 * Story: The Deadlock Empire opened its gates and from them surged massive amounts of soldiers,
 * loyal servants of the evil Parallel Wizard. Two armies are approaching our border keeps.
 *
 * WIN CONDITION: Get both threads to enter the critical section simultaneously.
 */
@ExtendWith(FrayTestExtension.class)
public class BooleanFlags extends DeadlockEmpireTestBase {
    private volatile boolean flag = false;

    @ConcurrencyTest
    public void runTest() {
        Thread firstArmy = new Thread(() -> {
            while (true) {
                while (flag != false) {
                }
                flag = true;
                criticalSection();
                flag = false;
            }
        }, "First Army");

        Thread secondArmy = new Thread(() -> {
            while (true) {
                while (flag != false) {
                }
                flag = true;
                criticalSection();
                flag = false;
            }
        }, "Second Army");

        firstArmy.start();
        secondArmy.start();
    }
}
