package com.UIBinder.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("UIBinderService")
public interface UIBinderService extends RemoteService {
    String getMessage(String msg);

    public static class App {
        private static UIBinderServiceAsync ourInstance = GWT.create(UIBinderService.class);

        public static synchronized UIBinderServiceAsync getInstance() {
            return ourInstance;
        }
    }
}
