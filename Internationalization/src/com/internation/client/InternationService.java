package com.internation.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("InternationService")
public interface InternationService extends RemoteService {

    String getMessage(String msg);

    public static class App {
        private static InternationServiceAsync ourInstance = GWT.create(InternationService.class);

        public static synchronized InternationServiceAsync getInstance() {
            return ourInstance;
        }
    }
}
