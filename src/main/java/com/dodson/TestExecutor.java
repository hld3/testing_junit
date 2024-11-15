package com.dodson;

import org.junit.platform.engine.discovery.DiscoverySelectors;
import org.junit.platform.launcher.Launcher;
import org.junit.platform.launcher.LauncherDiscoveryRequest;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;

public class TestExecutor {

    public static void main(String[] args) {
        Launcher launcher = LauncherFactory.create();

        launcher.registerTestExecutionListeners(new CustomLoggingListener());

        LauncherDiscoveryRequest request = LauncherDiscoveryRequestBuilder.request()
                .selectors(DiscoverySelectors.selectPackage("com.dodson"))
                .build();

        launcher.execute(request);
    }
}
