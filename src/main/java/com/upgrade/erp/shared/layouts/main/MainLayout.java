package com.upgrade.erp.shared.layouts.main;

import com.upgrade.erp.shared.layouts.main.styles.MainLayoutStyles;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Footer;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Header;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.SvgIcon;
import com.vaadin.flow.component.orderedlayout.Scroller;
import com.vaadin.flow.component.sidenav.SideNav;
import com.vaadin.flow.component.sidenav.SideNavItem;
import com.vaadin.flow.router.Layout;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import com.vaadin.flow.server.menu.MenuConfiguration;
import com.vaadin.flow.server.menu.MenuEntry;

import java.util.List;

@Layout
@AnonymousAllowed
public class MainLayout extends AppLayout {

    private H1 viewTitle;

    public MainLayout() {
        setPrimarySection(Section.DRAWER);
        addDrawerContent();
        addHeaderContent();
    }

    private void addHeaderContent() {
        DrawerToggle toggle = new DrawerToggle();
        toggle.setAriaLabel("Menu toggle");
        viewTitle = new H1();
        viewTitle.addClassNames(MainLayoutStyles.headerTitleStyle());
        addToNavbar(true, toggle, viewTitle);
    }

    private void addDrawerContent() {
        Div sidebarContainer = new Div();
        sidebarContainer.addClassNames(MainLayoutStyles.sidebarContainerStyle());
        Div logoContainer = new Div();
        logoContainer.addClassNames(MainLayoutStyles.logoContainerStyle());
        Span appName = new Span("GRUPO UPGRADE");
        appName.addClassNames(MainLayoutStyles.logoStyle());
        logoContainer.add(appName);
        Scroller scroller = new Scroller(createNavigation());
        scroller.addClassNames(MainLayoutStyles.scrollerStyle());
        Footer footer = createFooter();
        sidebarContainer.add(logoContainer, scroller, footer);
        addToDrawer(sidebarContainer);
    }

    private Footer createFooter() {
        Footer footer = new Footer();
        Span content = new Span("© 2025 | Consultancy | v1.0.0");
        footer.add(content);
        footer.addClassNames(MainLayoutStyles.footerStyle());
        return footer;
    }

    private SideNav createNavigation() {
        SideNav nav = new SideNav();
        nav.addClassNames(MainLayoutStyles.sideNavStyle());
        List<MenuEntry> menuEntries = MenuConfiguration.getMenuEntries();
        menuEntries.forEach(entry -> {
            if (entry.icon() != null) {
                nav.addItem(new SideNavItem(entry.title(), entry.path(), new SvgIcon(entry.icon())));
            } else {
                nav.addItem(new SideNavItem(entry.title(), entry.path()));
            }
        });
        return nav;
    }

    @Override
    protected void afterNavigation() {
        super.afterNavigation();
        viewTitle.setText(getCurrentPageTitle());
    }

    private String getCurrentPageTitle() {
        return MenuConfiguration.getPageHeader(getContent()).orElse("");
    }
}
