package com.upgrade.erp.shared.layouts.main.styles;

import com.vaadin.flow.theme.lumo.LumoUtility;

public class MainLayoutStyles {

    // Estilo común para elementos con padding
    public static String[] commonPadding() {
        return new String[] { LumoUtility.Padding.Horizontal.SMALL };
    }

    // Estilo para fondo y alineación
    public static String[] commonBackgroundAlignment() {
        return new String[] {
                LumoUtility.Background.CONTRAST_5,
                LumoUtility.Display.FLEX,
                LumoUtility.JustifyContent.CENTER
        };
    }

    // Estilo para el título
    public static String[] headerTitleStyle() {
        return new String[] {
                LumoUtility.FontWeight.BOLD,
                LumoUtility.FontSize.XLARGE,
                LumoUtility.Display.FLEX,
                LumoUtility.AlignItems.START,
                LumoUtility.JustifyContent.START
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
                LumoUtility.Padding.SMALL,
                LumoUtility.AlignItems.CENTER // Centra los elementos horizontalmente
        };
    }

    // Estilo para el contenedor del logo
    public static String[] logoContainerStyle() {
        return new String[] {
                LumoUtility.Display.FLEX,
                LumoUtility.JustifyContent.CENTER,
                LumoUtility.Padding.Vertical.SMALL
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
                LumoUtility.Flex.GROW, // Hace que el scroller tome el espacio disponible
                LumoUtility.Overflow.AUTO
        };
    }

}
