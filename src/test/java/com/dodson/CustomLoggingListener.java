package com.dodson;

import org.junit.platform.engine.TestExecutionResult;
import org.junit.platform.launcher.TestExecutionListener;
import org.junit.platform.launcher.TestIdentifier;

public class CustomLoggingListener implements TestExecutionListener {

    @Override
    public void executionStarted(TestIdentifier testIdentifier) {
        if (testIdentifier.isTest()) {
            System.out.println("[CustomLoggingListener] Test Started: " + testIdentifier.getDisplayName());
        }
    }

    @Override
    public void executionFinished(TestIdentifier testIdentifier, TestExecutionResult testExecutionResult) {
        if (testIdentifier.isTest()) {
            String status = testExecutionResult.getStatus().toString();
            System.out.println("[CustomLoggingListener] Test Finished: " + testIdentifier.getDisplayName() + " - Status: " + status);
            testExecutionResult.getThrowable().ifPresent(throwable -> {
                System.out.println("Test Failed with Exception:");
                throwable.printStackTrace(System.out);
            });
        }
    }

    @Override
    public void executionSkipped(TestIdentifier testIdentifier, String reason) {
        if (testIdentifier.isTest()) {
            System.out.println("[CustomLoggingListener] Test Skipped: " + testIdentifier.getDisplayName());
        }
    }
}
