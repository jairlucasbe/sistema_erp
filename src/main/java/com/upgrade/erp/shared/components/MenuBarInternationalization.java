package com.upgrade.erp.shared.components;

import org.vaadin.lineawesome.LineAwesomeIconUrl;

import com.vaadin.flow.component.contextmenu.MenuItem;
import com.vaadin.flow.component.contextmenu.SubMenu;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.menubar.MenuBar;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route("menu-bar-internationalization")
@PageTitle("Menu Bar Internationalization")
@Menu(order = 1, icon = LineAwesomeIconUrl.ADDRESS_CARD_SOLID)
public class MenuBarInternationalization extends Div {

    public MenuBarInternationalization() {
        MenuBar menuBar = new MenuBar();
        MenuBar.MenuBarI18n customI18n = new MenuBar.MenuBarI18n()
                // Provide accessible label for the overflow menu button
                // to screen readers
                .setMoreOptions("More actions");

        menuBar.setI18n(customI18n);

        menuBar.addItem("View");
        menuBar.addItem("Edit");

        MenuItem share = menuBar.addItem("Share");
        SubMenu shareSubMenu = share.getSubMenu();
        MenuItem onSocialMedia = shareSubMenu.addItem("On social media");
        SubMenu socialMediaSubMenu = onSocialMedia.getSubMenu();
        socialMediaSubMenu.addItem("Facebook");
        socialMediaSubMenu.addItem("Twitter");
        socialMediaSubMenu.addItem("Instagram");
        shareSubMenu.addItem("By email");
        shareSubMenu.addItem("Get Link");

        MenuItem move = menuBar.addItem("Move");
        SubMenu moveSubMenu = move.getSubMenu();
        moveSubMenu.addItem("To folder");
        moveSubMenu.addItem("To trash");

        menuBar.addItem("Duplicate");

        add(menuBar);
    }

}