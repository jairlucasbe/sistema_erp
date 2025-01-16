package com.upgrade.erp.shared.layouts.main.styles;

import com.upgrade.erp.shared.layouts.main.MainLayout;
import com.vaadin.flow.theme.lumo.LumoUtility;

public class MainLayoutStyles {

    public static void applyStyles(MainLayout mainLayout) {
        applyHeaderStyles(mainLayout);
        applyDrawerStyles(mainLayout);
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
    }

    public static void toggleHeaderTitleStyle(MainLayout mainLayout, boolean isDrawerOpened) {
        if (isDrawerOpened) {
            mainLayout.getHeaderTitle().getClassNames().add(LumoUtility.Margin.Left.MEDIUM);
        } else {
            mainLayout.getHeaderTitle().getClassNames().remove(LumoUtility.Margin.Left.MEDIUM);
        }
    }

    public static String[] toggleButtonStyle() {
        return new String[] {
            LumoUtility.FontSize.SMALL,
            LumoUtility.Padding.SMALL,
            LumoUtility.Background.CONTRAST_5,
            LumoUtility.BorderRadius.MEDIUM,
            LumoUtility.Display.FLEX,
            LumoUtility.AlignItems.CENTER,
            LumoUtility.Margin.SMALL,
            LumoUtility.AlignSelf.START
        };
    }

    public static String[] headerContainerStyle() {
        return new String[] {
                LumoUtility.Background.BASE,
                LumoUtility.Display.FLEX,
                LumoUtility.AlignItems.CENTER,
                LumoUtility.JustifyContent.BETWEEN
        };
    }

    // Estilo para el título
    public static String[] headerTitleStyle() {
        return new String[] {
                LumoUtility.FontWeight.MEDIUM,
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
                LumoUtility.Height.MEDIUM,
                LumoUtility.Margin.Top.AUTO
        };
    }

    public static String[] sideNavStyle() {
        return new String[] {
                LumoUtility.Padding.Horizontal.SMALL,
                LumoUtility.Display.FLEX,
        };
    }

    // Estilo para el contenedor principal del sidebar
    public static String[] sidebarContainerStyle() {
        return new String[] {
                "sidebar-container",
                LumoUtility.Display.FLEX,
                LumoUtility.FlexDirection.COLUMN,
                LumoUtility.Height.FULL,
                LumoUtility.AlignItems.CENTER,  
        };
    }

    // Estilo para el contenedor del logo
    public static String[] logoContainerStyle() {
        return new String[] {
                LumoUtility.Background.CONTRAST_5,
                LumoUtility.Display.FLEX,
                LumoUtility.JustifyContent.CENTER,
                LumoUtility.Padding.Vertical.SMALL,
        };
    }

    // Estilo para el logo o nombre de la app
    public static String[] logoStyle() {
        return new String[] {
                LumoUtility.FontSize.LARGE,
                LumoUtility.FontWeight.BOLD
        };
    }   

    // Estilo para el scroller (navegación)
    public static String[] scrollerStyle() {
        return new String[] {
                LumoUtility.Background.CONTRAST_5,
                LumoUtility.Flex.GROW,
                LumoUtility.Overflow.AUTO   
        };
    }

}
