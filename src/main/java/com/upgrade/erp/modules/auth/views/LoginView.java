package com.upgrade.erp.modules.auth.views;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Login")
@Route("auth/login")
public class LoginView extends VerticalLayout {

    public LoginView() {
        setClassName("login-view");
        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);

        // Título
        H1 title = new H1("Login - Sistema ERP Upgrade");

        // Formulario de Login
        LoginForm loginForm = new LoginForm();
        loginForm.addLoginListener(event -> {
            String username = event.getUsername();
            String password = event.getPassword();
            if (authenticate(username, password)) {
                Notification.show("Login successful", 3000, Notification.Position.MIDDLE);
            } else {
                loginForm.setError(true);
            }
        });
        
        add(title, loginForm);
    }

    private boolean authenticate(String username, String password) {
        // Implementar lógica de autenticación  
        return "admin".equals(username) && "password".equals(password);
    }
}
