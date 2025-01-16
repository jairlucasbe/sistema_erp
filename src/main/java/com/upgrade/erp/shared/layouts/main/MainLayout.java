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

        this.drawerBackground = new Div();
        this.drawerBackground.add(this.toggle, logoContainer, scroller, createFooter());
        addToDrawer(this.drawerBackground);
    }

    private Footer createFooter() {
        this.footer = new Footer();
        this.footer.add(new Span("© 2025 | Consultancy | v1.0.0"));
        return this.footer;
    }

    /**
     * Configura el menú de navegación lateral (SideNav) dinámico basado en las
     * entradas de {@link MenuConfiguration}
     * 
     * @return un componente {@link SideNav} configurado con los elementos del menú.
     */
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

    /*
     * Actualiza el título de la cabecera con el título de la página actual después
     * de la navegación.
     */
    @Override
    protected void afterNavigation() {
        super.afterNavigation();
        headerTitle.setText(getCurrentPageTitle());
    }

    /**
     * Obtiene el título de la página actual desde la configuración del menú.
     * @return El título de la página actual si está configurado, o una cadena vacía
     * en caso contrario.
     */
    private String getCurrentPageTitle() {
        return MenuConfiguration.getPageHeader(getContent()).orElse("");
    }
}
