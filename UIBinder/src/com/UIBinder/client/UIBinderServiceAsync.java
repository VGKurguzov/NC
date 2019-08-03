package com.UIBinder.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface UIBinderServiceAsync {
    void getMessage(String msg, AsyncCallback<String> async);
}
