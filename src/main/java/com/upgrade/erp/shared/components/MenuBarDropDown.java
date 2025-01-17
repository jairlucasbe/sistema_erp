package com.upgrade.erp.shared.components;

import org.vaadin.lineawesome.LineAwesomeIconUrl;

import com.vaadin.flow.component.contextmenu.MenuItem;
import com.vaadin.flow.component.contextmenu.SubMenu;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Hr;
import com.vaadin.flow.component.menubar.MenuBar;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route("menu-bar-dropdown")
@PageTitle("Menu Bar DropDown")
@Menu(order = 1, icon = LineAwesomeIconUrl.ADDRESS_CARD_SOLID)
public class MenuBarDropDown extends Div {
    public MenuBarDropDown() {
        MenuBar menuBar = new MenuBar();
        MenuItem item = menuBar.addItem("John Smith");
        SubMenu subMenu = item.getSubMenu();
        subMenu.addItem("Profile");
        subMenu.addItem("Account");
        subMenu.addItem("Preferences");
        subMenu.add(new Hr());
        subMenu.addItem("Sign out");

        add(menuBar);
    }

}