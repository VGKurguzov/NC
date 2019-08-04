package com.internation.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface InternationServiceAsync {
    void getMessage(String msg, AsyncCallback<String> async);
}
