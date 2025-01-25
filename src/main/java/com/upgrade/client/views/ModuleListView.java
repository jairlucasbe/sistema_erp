package com.upgrade.client.views;

import org.vaadin.lineawesome.LineAwesomeIconUrl;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("List Module")
@Route("List")
@Menu(order = 3, icon = LineAwesomeIconUrl.ACCUSOFT)
public class ModuleListView extends VerticalLayout {
    
    public ModuleListView() {
        removeAll();
    }
}
