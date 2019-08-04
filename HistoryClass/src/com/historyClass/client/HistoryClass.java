package com.historyClass.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;

import com.google.gwt.logging.client.HasWidgetsLogHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.*;

import java.util.logging.Level;
import java.util.logging.Logger;

public class HistoryClass implements EntryPoint {
    private TabPanel tabPanel;
    private static Logger rootLogger = Logger.getLogger("");
    private VerticalPanel customLogArea;

    private void selectTab(String historyToken){
        try {
            if (historyToken.substring(0, 9).equals("pageIndex")) {
                String tabIndexToken = historyToken.substring(9, 10);
                int tabIndex = Integer.parseInt(tabIndexToken);
                tabPanel.selectTab(tabIndex);
            } else {
                tabPanel.selectTab(0);
            }
        } catch (IndexOutOfBoundsException e) {
            tabPanel.selectTab(0);
        }
    }

    public void onModuleLoad() {
        tabPanel = new TabPanel();

        HTML firstPage = new HTML("<h1>We are on first Page.</h1>");
        HTML secondPage = new HTML("<h1>We are on second Page.</h1>");
        HTML thirdPage = new HTML("<h1>We are on third Page.</h1>");

        String firstPageTitle = "First Page";
        String secondPageTitle = "Second Page";
        String thirdPageTitle = "Third Page";

        Hyperlink firstPageLink = new Hyperlink("1", "pageIndex0");
        Hyperlink secondPageLink = new Hyperlink("2", "pageIndex1");
        Hyperlink thirdPageLink = new Hyperlink("3", "pageIndex2");

        HorizontalPanel linksHPanel = new HorizontalPanel();
        linksHPanel.setSpacing(10);
        linksHPanel.add(firstPageLink);
        linksHPanel.add(secondPageLink);
        linksHPanel.add(thirdPageLink);

        String initToken = History.getToken();

        if (initToken.length() == 0) {
            History.newItem("pageIndex0");
            initToken = "pageIndex0";
        }

        tabPanel.setWidth("400");
        tabPanel.add(firstPage, firstPageTitle);
        tabPanel.add(secondPage,secondPageTitle);
        tabPanel.add(thirdPage, thirdPageTitle);

        History.addValueChangeHandler(new ValueChangeHandler<String>() {
            @Override
            public void onValueChange(ValueChangeEvent<String> event) {
                selectTab(event.getValue());
                rootLogger.log(Level.SEVERE, "pageIndex selected: "
                        + event.getValue());
            }
        });

        selectTab(initToken);

        VerticalPanel vPanel = new VerticalPanel();

        vPanel.setSpacing(10);
        vPanel.add(tabPanel);
        vPanel.add(linksHPanel);

        customLogArea = new VerticalPanel();
        vPanel.add(customLogArea);

        rootLogger.addHandler(new HasWidgetsLogHandler(customLogArea));

        RootPanel.get().add(vPanel);
    }
}