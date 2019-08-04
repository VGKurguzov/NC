package com.historyClass.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.historyClass.client.HistoryClassService;

public class HistoryClassServiceImpl extends RemoteServiceServlet implements HistoryClassService {

    public String getMessage(String msg) {
        return "Client said: \"" + msg + "\"<br>Server answered: \"Hi!\"";
    }
}