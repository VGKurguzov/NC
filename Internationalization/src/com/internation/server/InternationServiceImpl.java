package com.internation.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.internation.client.InternationService;

public class InternationServiceImpl extends RemoteServiceServlet implements InternationService {
    // Implementation of sample interface method
    public String getMessage(String msg) {
        return "Client said: \"" + msg + "\"<br>Server answered: \"Hi!\"";
    }
}