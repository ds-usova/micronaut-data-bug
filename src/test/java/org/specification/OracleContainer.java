package org.specification;

import java.time.Duration;

public class OracleContainer {

    public static final org.testcontainers.oracle.OracleContainer ORACLE;

    private OracleContainer() {
        // private constructor to prevent instantiation
    }

    static {
        ORACLE = new org.testcontainers.oracle.OracleContainer(
                "gvenzl/oracle-free:slim-faststart")
                .withStartupTimeout(Duration.ofMinutes(5));

        ORACLE.start();
    }

}
