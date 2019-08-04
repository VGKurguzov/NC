package com.customWidgets.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("CustomWidgetsService")
public interface CustomWidgetsService extends RemoteService {
    // Sample interface method of remote interface
    String getMessage(String msg);

    /**
     * Utility/Convenience class.
     * Use CustomWidgetsService.App.getInstance() to access static instance of CustomWidgetsServiceAsync
     */
    public static class App {
        private static CustomWidgetsServiceAsync ourInstance = GWT.create(CustomWidgetsService.class);

        public static synchronized CustomWidgetsServiceAsync getInstance() {
            return ourInstance;
        }
    }
}
