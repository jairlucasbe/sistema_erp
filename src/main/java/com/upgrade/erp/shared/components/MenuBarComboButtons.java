package com.upgrade.erp.shared.components;

import org.vaadin.lineawesome.LineAwesomeIconUrl;

import com.vaadin.flow.component.contextmenu.MenuItem;
import com.vaadin.flow.component.contextmenu.SubMenu;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.menubar.MenuBar;
import com.vaadin.flow.component.menubar.MenuBarVariant;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route("menu-bar-combo-buttons")
@PageTitle("Menu Bar Combo Buttons")
@Menu(order = 1, icon = LineAwesomeIconUrl.ADDRESS_CARD_SOLID)
public class MenuBarComboButtons extends Div {
    public MenuBarComboButtons() {
        MenuBar menuBar = new MenuBar();
        menuBar.addThemeVariants(MenuBarVariant.LUMO_ICON,
                MenuBarVariant.LUMO_PRIMARY);
        menuBar.addItem("Save");
        MenuItem item = menuBar.addItem(new Icon(VaadinIcon.CHEVRON_DOWN));
        SubMenu subItems = item.getSubMenu();
        subItems.addItem("Save as draft");
        subItems.addItem("Save as copy");
        subItems.addItem("Save and publish");
        add(menuBar);
    }

}