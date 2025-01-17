package com.upgrade.erp.shared.components;

import org.vaadin.lineawesome.LineAwesomeIconUrl;

import com.vaadin.flow.component.contextmenu.MenuItem;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.menubar.MenuBar;
import com.vaadin.flow.component.menubar.MenuBarVariant;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route("menu-bar-tooltip")
@PageTitle("Menu Bar Tooltip")
@Menu(order = 1, icon = LineAwesomeIconUrl.ADDRESS_CARD_SOLID)
public class MenuBarTooltip extends Div {
    public MenuBarTooltip() {
        MenuBar menuBar = new MenuBar();
        menuBar.addThemeVariants(MenuBarVariant.LUMO_ICON);

        createIconItem(menuBar, VaadinIcon.EYE, "View");
        createIconItem(menuBar, VaadinIcon.PENCIL, "Edit");
        createIconItem(menuBar, VaadinIcon.FOLDER, "Move");
        createIconItem(menuBar, VaadinIcon.COPY, "Duplicate");
        MenuItem archive = createIconItem(menuBar, VaadinIcon.ARCHIVE,
                "Archive");
        archive.setEnabled(false);
        add(menuBar);
    }

    private MenuItem createIconItem(MenuBar menu, VaadinIcon iconName,
            String tooltipText) {
        Icon icon = new Icon(iconName);
        MenuItem item = menu.addItem(icon, tooltipText);
        return item;
    }

}