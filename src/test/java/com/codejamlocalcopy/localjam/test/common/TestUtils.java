package com.codejamlocalcopy.localjam.test.common;

import org.apache.commons.io.IOUtils;

import java.io.IOException;

/**
 * Utils class that contains tool methods related to testing.
 */
public class TestUtils {
    /**
     * Read resource file into string
     *
     * @param testClass - the *Test.java class
     * @param filename - the text file name, this file should locate at /src/test/resources/[package path of testClass]/
     * @return
     * @throws IOException
     */
    public static String getResourceAsString(Class testClass, String filename) throws IOException {
        return IOUtils.toString(testClass.getResourceAsStream(filename),"UTF-8");
    }
}
