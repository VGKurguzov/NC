package com.internation.client;

import com.google.gwt.i18n.client.Messages;

public interface InternationMessages extends Messages {
    @DefaultMessage("Enter your name")
    String enterName();

    @DefaultMessage("Click Me")
    String clickMe();

    @DefaultMessage("Application Internationalization Demonstration")
    String applicationTitle();

    @DefaultMessage("Hello {0}")
    String greeting(String name);
}