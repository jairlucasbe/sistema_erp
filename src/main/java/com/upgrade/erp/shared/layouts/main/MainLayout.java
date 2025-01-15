package com.upgrade.erp.shared.layouts.main;

import com.upgrade.erp.shared.layouts.main.styles.MainLayoutStyles;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Footer;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.SvgIcon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.Scroller;
import com.vaadin.flow.component.sidenav.SideNav;
import com.vaadin.flow.component.sidenav.SideNavItem;
import com.vaadin.flow.router.Layout;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import com.vaadin.flow.server.menu.MenuConfiguration;
import com.vaadin.flow.server.menu.MenuEntry;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Layout
@AnonymousAllowed
@Data
@EqualsAndHashCode(callSuper = true)
public class MainLayout extends AppLayout {

    /**
     * Componentes de la cabecera
     */
    private H1 headerTitle;
    private DrawerToggle toggle;

    /**
     * Componentes del drawer
     */
    private Div drawerBackground;
    private Footer footer;

    public MainLayout() {
        setPrimarySection(Section.DRAWER);
        addDrawerContent();
        addHeaderContent();
        MainLayoutStyles.applyStyles(this);
    }

    private void addHeaderContent() {
        this.toggle = new DrawerToggle();
        this.toggle.setIcon(new Icon(VaadinIcon.ANGLE_RIGHT));
        headerTitle = new H1();
        headerTitle.addClassNames(MainLayoutStyles.headerTitleStyle());
        addToNavbar(true, toggle, headerTitle);
    }

    private void addDrawerContent() {
        this.toggle = new DrawerToggle();
        this.toggle.setIcon(new Icon(VaadinIcon.ANGLE_LEFT));
        Div logoContainer = new Div();
        logoContainer.addClassNames(MainLayoutStyles.logoContainerStyle());
        Span appName = new Span("GRUPO UPGRADE");
        appName.addClassNames(MainLayoutStyles.logoStyle());
        logoContainer.add(appName);

        Scroller scroller = new Scroller(createNavigation());
        scroller.addClassNames(MainLayoutStyles.scrollerStyle());

        this.footer = new Footer();
        this.footer.add(new Span("© 2025 | Consultancy | v1.0.0"));
        this.drawerBackground = new Div();
        this.drawerBackground.add(this.toggle, logoContainer, scroller, this.footer);
        addToDrawer(this.drawerBackground);
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
        headerTitle.setText(getCurrentPageTitle());
    }

    private String getCurrentPageTitle() {
        return MenuConfiguration.getPageHeader(getContent()).orElse("");
    }
}
