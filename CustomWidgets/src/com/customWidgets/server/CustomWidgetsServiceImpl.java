package com.customWidgets.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.customWidgets.client.CustomWidgetsService;

public class CustomWidgetsServiceImpl extends RemoteServiceServlet implements CustomWidgetsService {
    // Implementation of sample interface method
    public String getMessage(String msg) {
        return "Client said: \"" + msg + "\"<br>Server answered: \"Hi!\"";
    }
}