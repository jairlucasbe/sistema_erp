package com.upgrade.client.layouts.main.styles;

import com.upgrade.client.layouts.main.MainLayout;
import com.vaadin.flow.component.sidenav.SideNavItem;
import com.vaadin.flow.theme.lumo.LumoUtility;

public class MainLayoutStyles {

    public static void applyStyles(MainLayout mainLayout) {
        applyHeaderStyles(mainLayout);
        applyDrawerStyles(mainLayout);
        applySideNavItemStyles(mainLayout);
    }

    public static void applyHeaderStyles(MainLayout mainLayout) {
        mainLayout.getHeaderToggle().addClassNames(toggleButtonStyle());
        mainLayout.getHeaderTitle().addClassNames(headerTitleStyle());
        mainLayout.getHeaderContainer().addClassNames(headerContainerStyle());
    }

    public static void applyDrawerStyles(MainLayout mainLayout) {
        mainLayout.getDrawerToggle().addClassNames(toggleButtonStyle());
        mainLayout.getDrawerContainer().addClassNames(sidebarContainerStyle());
        mainLayout.getLogoContainer().addClassNames(logoContainerStyle());
        mainLayout.getScroller().addClassNames(scrollerStyle());
        mainLayout.getFooter().addClassNames(footerStyle());
        mainLayout.getSideNav().addClassNames(sideNavStyle());
    }

    public static void toggleHeaderTitleStyle(MainLayout mainLayout, boolean isDrawerOpened) {
        if (isDrawerOpened) {
            mainLayout.getHeaderTitle().getClassNames().add(LumoUtility.Margin.Left.MEDIUM);
        } else {
            mainLayout.getHeaderTitle().getClassNames().remove(LumoUtility.Margin.Left.MEDIUM);
        }
    }

    public static void applySideNavItemStyles(MainLayout mainLayout) {
        mainLayout.getSideNav().getChildren().forEach(child -> {
            if (child instanceof SideNavItem) {
                applySideNavItemStyle((SideNavItem) child);
            }
        });
    }

    private static void applySideNavItemStyle(SideNavItem sideNavItem) {
        sideNavItem.addClassNames(LumoUtility.FontSize.MEDIUM);
    }

    public static String[] toggleButtonStyle() {
        return new String[] {
            LumoUtility.Padding.SMALL,
            LumoUtility.Display.FLEX,
            LumoUtility.AlignItems.CENTER,
            LumoUtility.Margin.SMALL,
            LumoUtility.AlignSelf.START,
            LumoUtility.FontSize.LARGE
        };
    }

    public static String[] headerContainerStyle() {
        return new String[] {
                LumoUtility.Background.BASE,
                LumoUtility.Display.FLEX,
                LumoUtility.AlignItems.CENTER,
                LumoUtility.JustifyContent.BETWEEN,
        };
    }

    public static String[] headerTitleStyle() {
        return new String[] {
                LumoUtility.FontWeight.BOLD,
                LumoUtility.FontSize.LARGE,
                LumoUtility.Display.FLEX,
                LumoUtility.AlignItems.START,
                LumoUtility.JustifyContent.START,
                LumoUtility.Margin.Left.MEDIUM
        };
    }

    public static String[] footerStyle() {
        return new String[] {
                LumoUtility.FontWeight.THIN,
                LumoUtility.FontSize.SMALL,
                LumoUtility.Display.FLEX,
                LumoUtility.AlignItems.CENTER,
                LumoUtility.JustifyContent.CENTER,
                LumoUtility.Height.MEDIUM
        };
    }

    public static String[] sideNavStyle() {
        return new String[] {
                LumoUtility.Display.FLEX,
                LumoUtility.FlexDirection.COLUMN,
                LumoUtility.JustifyContent.CENTER,
                LumoUtility.AlignItems.STRETCH
        };
    }

    /**
     * Estilos para el contenedor del drawer, establece el fondo negro con "sidebar-container" que esta en 
     * frontend > themes > sistemaerpupgrade > main-layout.css
     */
    public static String[] sidebarContainerStyle() {
        return new String[] {
                "sidebar-container",
                LumoUtility.Display.FLEX,
                LumoUtility.FlexDirection.COLUMN,
                LumoUtility.Height.FULL,
                LumoUtility.AlignItems.STRETCH,
        };
    }

    // Estilos para logo que esta en el drawer
    public static String[] logoContainerStyle() {
        return new String[] {
                LumoUtility.Display.FLEX,
                LumoUtility.JustifyContent.CENTER,
                LumoUtility.Margin.SMALL,
                LumoUtility.FontSize.XXLARGE,
                LumoUtility.FontWeight.THIN
        };
    }

    // Estilos para el contenedor de la barra de desplazamiento
    public static String[] scrollerStyle() {
        return new String[] {
                LumoUtility.Display.FLEX,
                LumoUtility.FlexDirection.COLUMN,
                LumoUtility.JustifyContent.CENTER,
                LumoUtility.AlignItems.STRETCH,
                LumoUtility.Height.FULL,
                LumoUtility.Overflow.AUTO,
                LumoUtility.Margin.SMALL
        };
    }
}
