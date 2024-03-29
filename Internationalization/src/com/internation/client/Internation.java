package com.internation.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class Internation implements EntryPoint {

    private InternationMessages messages =
            GWT.create(InternationMessages.class);

    public void onModuleLoad() {

        final TextBox txtName = new TextBox();
        txtName.setWidth("200");
        txtName.addKeyUpHandler(new KeyUpHandler() {
            @Override
            public void onKeyUp(KeyUpEvent event) {
                if(event.getNativeKeyCode() == KeyCodes.KEY_ENTER){
                    Window.alert(getGreeting(txtName.getValue()));
                }
            }
        });
        Label lblName = new Label(messages.enterName() + ": ");

        Button buttonMessage = new Button(messages.clickMe() + "!");

        buttonMessage.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                Window.alert(getGreeting(txtName.getValue()));
            }
        });

        HorizontalPanel hPanel = new HorizontalPanel();
        hPanel.add(lblName);
        hPanel.add(txtName);

        VerticalPanel vPanel = new VerticalPanel();
        vPanel.setSpacing(10);
        vPanel.add(hPanel);
        vPanel.add(buttonMessage);
        vPanel.setCellHorizontalAlignment(buttonMessage,
                HasHorizontalAlignment.ALIGN_RIGHT);

        DecoratorPanel panel = new DecoratorPanel();
        panel.add(vPanel);
        Label titleLabel = new Label(messages.applicationTitle());

        RootPanel.get("gwtAppTitle").add(titleLabel);

        RootPanel.get("gwtContainer").add(panel);
    }

    public String getGreeting(String name){
        return messages.greeting(name + "!");
    }
}
