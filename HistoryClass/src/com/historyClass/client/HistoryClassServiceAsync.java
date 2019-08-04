package com.historyClass.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface HistoryClassServiceAsync {
    void getMessage(String msg, AsyncCallback<String> async);
}
