package com.upgrade.erp.modules.auth.views;

import com.upgrade.erp.modules.auth.controllers.dto.AuthCreateRoleRequest;
import com.upgrade.erp.modules.auth.controllers.dto.AuthCreateUserRequest;
import com.upgrade.erp.modules.auth.controllers.dto.AuthLoginRequest;
import com.upgrade.erp.modules.auth.controllers.dto.AuthResponse;
import com.upgrade.erp.modules.auth.services.UserDetailServiceImpl;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Route("/auth/login")
public class AuthenticationView extends VerticalLayout {  // Usamos VerticalLayout para un layout más flexible

    @Autowired
    private UserDetailServiceImpl userDetailService;

    public AuthenticationView() {
        // Formulario de registro
        TextField usernameRegister = new TextField("Username");
        PasswordField passwordRegister = new PasswordField("Password");

        // Gestión de roles
        TextField roleInput = new TextField("Role");
        Button addRoleButton = new Button("Add Role");
        List<String> roles = new ArrayList<>();
        Grid<String> roleGrid = new Grid<>(String.class, false);
        roleGrid.addColumn(role -> role).setHeader("Roles");

        addRoleButton.addClickListener(event -> {
            String role = roleInput.getValue();
            if (roles.size() < 3) {
                roles.add(role);
                roleGrid.setItems(roles);
                roleInput.clear();
            } else {
                Notification.show("The user cannot have more than 3 roles");
            }
        });

        Button signUpButton = new Button("Sign Up", event -> {
            String username = usernameRegister.getValue();
            String password = passwordRegister.getValue();

            try {
                AuthCreateRoleRequest roleRequest = new AuthCreateRoleRequest(roles);
                AuthCreateUserRequest request = new AuthCreateUserRequest(username, password, roleRequest);
                AuthResponse response = userDetailService.createUser(request);
                Notification.show("User registered: " + response.username());
                roles.clear();
                roleGrid.setItems(roles); // Limpiar la lista de roles tras el registro
            } catch (Exception e) {
                Notification.show("Error: " + e.getMessage());
            }
        });

        // Formulario de inicio de sesión
        TextField usernameLogin = new TextField("Username");
        PasswordField passwordLogin = new PasswordField("Password");

        Button loginButton = new Button("Log In", event -> {
            String username = usernameLogin.getValue();
            String password = passwordLogin.getValue();

            try {
                AuthLoginRequest request = new AuthLoginRequest(username, password);
                AuthResponse response = userDetailService.loginUser(request);
                if (response.status()) {
                    Notification.show("Welcome back: " + response.username());
                } else {
                    Notification.show("Error: " + response.message());
                }
            } catch (Exception e) {
                Notification.show("Error: " + e.getMessage());
            }
        });

        // Disposición de los componentes
        HorizontalLayout roleLayout = new HorizontalLayout(roleInput, addRoleButton);
        VerticalLayout registerLayout = new VerticalLayout(usernameRegister, passwordRegister, roleLayout, roleGrid, signUpButton);
        VerticalLayout loginLayout = new VerticalLayout(usernameLogin, passwordLogin, loginButton);

        // Añadir ambos formularios a la vista
        add(registerLayout, loginLayout);
        setAlignItems(Alignment.CENTER); // Centrar los formularios
    }
}
