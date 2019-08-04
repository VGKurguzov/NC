package com.customWidgets.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface CustomWidgetsServiceAsync {
    void getMessage(String msg, AsyncCallback<String> async);
}
