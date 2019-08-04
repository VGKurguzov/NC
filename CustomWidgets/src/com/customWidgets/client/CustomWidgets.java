package com.customWidgets.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;

public class CustomWidgets implements EntryPoint {

    private static class OptionalTextBox extends Composite implements
            ClickHandler {

        private TextBox textBox = new TextBox();
        private CheckBox checkBox = new CheckBox();
        private boolean enabled = true;

        public boolean isEnabled() {
            return enabled;
        }

        public void setEnabled(boolean enabled) {
            this.enabled = enabled;
        }

        public OptionalTextBox(String caption) {

            HorizontalPanel panel = new HorizontalPanel();

            panel.setSpacing(10);
            panel.add(checkBox);
            panel.add(textBox);

            initWidget(panel);

//            setStyleName("optionalTextWidget");
//
//            textBox.setStyleName("optionalTextBox");
//
//            checkBox.setStyleName("optionalCheckBox");
            textBox.setWidth("200");

            checkBox.setText(caption);
            checkBox.setValue(enabled);
            checkBox.addClickHandler(this);
            enableTextBox(enabled,checkBox.getValue());
        }

        public void onClick(ClickEvent event) {
            if (event.getSource() == checkBox) {
                enableTextBox(enabled,checkBox.getValue());
            }
        }

        private void enableTextBox(boolean enable,boolean isChecked){
            enable = (enable && isChecked) || (!enable && !isChecked);
            textBox.setStyleDependentName("disabled", !enable);
            textBox.setEnabled(enable);
        }
    }

    public void onModuleLoad() {
        OptionalTextBox otb = new OptionalTextBox(
                "Want to explain the solution?");
        otb.setEnabled(true);
        RootPanel.get().add(otb);
    }
}