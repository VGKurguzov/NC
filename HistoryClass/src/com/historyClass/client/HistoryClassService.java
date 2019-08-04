package com.historyClass.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("HistoryClassService")
public interface HistoryClassService extends RemoteService {

    String getMessage(String msg);

    public static class App {
        private static HistoryClassServiceAsync ourInstance = GWT.create(HistoryClassService.class);

        public static synchronized HistoryClassServiceAsync getInstance() {
            return ourInstance;
        }
    }
}
