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

    // Componentes de la cabecera
    private H1 headerTitle;
    private DrawerToggle headerToggle;
    private Div headerContainer;

    // Componentes del drawer
    private Div drawerContainer;
    private Div logoContainer;
    private Footer footer;
    private Scroller scroller;
    private DrawerToggle drawerToggle;

    public MainLayout() {
        setPrimarySection(Section.DRAWER);
        addDrawerContent();
        addHeaderContent();
        MainLayoutStyles.applyStyles(this);
    }

    private void addHeaderContent() {
        this.headerTitle = new H1();
        this.headerContainer = new Div();
        this.headerToggle = createToggle();
        this.headerToggle.getStyle().set("display", "none");
        this.headerToggle.addClickListener(event -> handlerToggle());
        this.headerContainer.add(this.headerToggle, this.headerTitle);
        addToNavbar(true, this.headerContainer);
    }

    private void addDrawerContent() {
        this.drawerContainer = new Div();
        this.drawerToggle = createToggle();
        this.drawerToggle.addClickListener(event -> handlerToggle());
        this.drawerContainer.add(this.drawerToggle, createLogoContainer(), createScroller(), createFooter());
        addToDrawer(this.drawerContainer);
    }

    private DrawerToggle createToggle() {
        DrawerToggle toggle = new DrawerToggle();
        toggle.setIcon(new Icon(VaadinIcon.ANGLE_LEFT));
        return toggle;
    }

    /**
     * Maneja el cambio de visibilidad entre los botones `headerToggle` y `drawerToggle`según el estado del drawer (abierto o cerrado).
     */
    private void handlerToggle() {
        Boolean isDrawerOpened = isDrawerOpened();
        if (isDrawerOpened) {
            this.drawerToggle.getStyle().set("display", "block");
            this.headerToggle.getStyle().set("display", "none");
            this.drawerToggle.setIcon(new Icon(VaadinIcon.ANGLE_LEFT));
        } else {
            this.drawerToggle.getStyle().set("display", "none");
            this.headerToggle.getStyle().set("display", "block");
            this.headerToggle.setIcon(new Icon(VaadinIcon.ANGLE_RIGHT));
        }
        MainLayoutStyles.toggleHeaderTitleStyle(this, isDrawerOpened);
    }

    private Div createLogoContainer() {
        this.logoContainer = new Div();
        Span appName = new Span("GRUPO UPGRADE");
        appName.addClassNames(MainLayoutStyles.logoStyle());
        logoContainer.add(appName);
        return logoContainer;
    }

    private Scroller createScroller() {
        this.scroller = new Scroller(createNavigation());
        return this.scroller;
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
        this.headerTitle.setText(getCurrentPageTitle());
    }

    /**
     * Obtiene el título de la página actual desde la configuración del menú.
     * 
     * @return El título de la página actual si está configurado, o una cadena vacía
     *         en caso contrario.
     */
    private String getCurrentPageTitle() {
        return MenuConfiguration.getPageHeader(getContent()).orElse("");
    }
}
