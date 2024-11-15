package com.dodson;

import org.junit.platform.engine.TestExecutionResult;
import org.junit.platform.launcher.TestExecutionListener;
import org.junit.platform.launcher.TestIdentifier;

public class CustomLoggingListener implements TestExecutionListener {

    @Override
    public void executionStarted(TestIdentifier testIdentifier) {
        System.out.println("Test Started: " + testIdentifier.getDisplayName());
    }

    @Override
    public void executionFinished(TestIdentifier testIdentifier, TestExecutionResult testExecutionResult) {
        if (testIdentifier.isTest()) {
            String status = testExecutionResult.getStatus().toString();
            System.out.println("Test Finished: " + testIdentifier.getDisplayName());
            testExecutionResult.getThrowable().ifPresent(throwable -> {
                System.out.println("Test Failed with Exception:");
                throwable.printStackTrace(System.out);
            });
        }
    }
}
