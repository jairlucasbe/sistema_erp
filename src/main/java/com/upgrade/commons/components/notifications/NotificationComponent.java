package com.upgrade.commons.components.notifications;

import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;

public class NotificationComponent {

    // Método para mostrar una notificación de éxito
    public static void showSuccess(String message) {
        Notification notification = new Notification(message, 3000, Notification.Position.TOP_CENTER);
        notification.addThemeVariants(NotificationVariant.LUMO_SUCCESS);  // Estilo verde para éxito
        notification.open();
    }

    // Método para mostrar una notificación de error
    public static void showError(String message) {
        Notification notification = new Notification(message, 3000, Notification.Position.TOP_CENTER);
        notification.addThemeVariants(NotificationVariant.LUMO_ERROR);  // Estilo rojo para error
        notification.open();
    }

    // Método para mostrar una notificación informativa
    public static void showInfo(String message) {
        Notification notification = new Notification(message, 3000, Notification.Position.TOP_CENTER);
        notification.addThemeVariants(NotificationVariant.LUMO_CONTRAST);  // Estilo neutral para información
        notification.open();
    }
}