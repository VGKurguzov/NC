package com.testings.client;

import com.testings.shared.FieldVerifier;
import com.google.gwt.core.client.GWT;
import com.google.gwt.junit.client.GWTTestCase;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.ServiceDefTarget;

/**
 * GWT JUnit tests must extend GWTTestCase.
 */
public class TestingProjectTest extends GWTTestCase {

  /**
   * must refer to a valid module that sources this class.
   */
  public String getModuleName() {
    return "com.testings.HelloWorldJUnit";
  }

  /**
   * tests the FieldVerifier.
   */
  public void testFieldVerifier() {
    assertFalse(FieldVerifier.isValidName(null));
    assertFalse(FieldVerifier.isValidName(""));
    assertFalse(FieldVerifier.isValidName("a"));
    assertFalse(FieldVerifier.isValidName("ab"));
    assertFalse(FieldVerifier.isValidName("abc"));
    assertTrue(FieldVerifier.isValidName("abcd"));
  }

  public void testGreetingService() {
    /* create the service that we will test. */
    GreetingServiceAsync greetingService =
            GWT.create(GreetingService.class);
    ServiceDefTarget target = (ServiceDefTarget) greetingService;
    target.setServiceEntryPoint(GWT.getModuleBaseURL()
            + "helloworld/greet");

      /* since RPC calls are asynchronous, we will need to wait
       for a response after this test method returns. This line
       tells the test runner to wait up to 10 seconds
       before timing out. */
    delayTestFinish(10000);

    /* send a request to the server. */
    greetingService.greetServer("GWT User",
            new AsyncCallback<String>() {
              public void onFailure(Throwable caught) {
                /* The request resulted in an unexpected error. */
                fail("Request failure: " + caught.getMessage());
              }

              public void onSuccess(String result) {
                /* verify that the response is correct. */
                assertTrue(result.startsWith("Hello, GWT User!"));

            /* now that we have received a response, we need to
             tell the test runner that the test is complete.
             You must call finishTest() after an asynchronous test
             finishes successfully, or the test will time out.*/
                finishTest();
              }
            });

    public void testGetGreeting() {
      TestingProject helloWorld = new TestingProject();
      String name = "Robert";
      String expectedGreeting = "Hello "+name+"!";
      assertEquals(expectedGreeting,helloWorld.getGreeting(name));
    }

  }

}