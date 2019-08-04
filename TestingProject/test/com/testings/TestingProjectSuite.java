package com.testings;

import com.testings.client.TestingProjectTest;
import com.google.gwt.junit.tools.GWTTestSuite;
import junit.framework.Test;
import junit.framework.TestSuite;

public class TestingProjectSuite extends GWTTestSuite {
  public static Test suite() {
    TestSuite suite = new TestSuite("Tests for TestingProject");
    suite.addTestSuite(TestingProjectTest.class);
    return suite;
  }
}
