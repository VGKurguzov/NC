package com.UIBinder.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.UIBinder.client.UIBinderService;

public class UIBinderServiceImpl extends RemoteServiceServlet implements UIBinderService {
    // Implementation of sample interface method
    public String getMessage(String msg) {
        return "Client said: \"" + msg + "\"<br>Server answered: \"Hi!\"";
    }
}