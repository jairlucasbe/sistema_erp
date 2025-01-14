package com.upgrade.erp.shared.components;

import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.Nav;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

public class MenuComponent extends HorizontalLayout {

    public MenuComponent() {
        setWidthFull();
        setJustifyContentMode(JustifyContentMode.BETWEEN);

        Anchor createModuleLink = new Anchor("/auth/modules/create", "Create Module");
        Anchor listModulesLink = new Anchor("/auth/modules/list", "Module List");

        Nav nav = new Nav(createModuleLink, listModulesLink);
        add(nav);
    }
}
