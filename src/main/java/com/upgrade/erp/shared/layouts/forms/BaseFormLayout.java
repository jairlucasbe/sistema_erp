package com.upgrade.erp.shared.layouts.forms;

import com.upgrade.erp.shared.components.buttons.ButtonComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import lombok.Data;
import lombok.EqualsAndHashCode;

import com.vaadin.flow.component.html.H1;

@Data
@EqualsAndHashCode(callSuper = true)
public class BaseFormLayout extends VerticalLayout {

    private final H1 titleLabel;
    private final ButtonComponent buttonComponent;

    public BaseFormLayout() {
        // Configuración inicial del layout
        setSpacing(true);
        setPadding(true);
        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.START);
        setClassName("base-form-layout");

        // Crear componentes básicos
        titleLabel = new H1(); // Crear el Label con texto vacío
        titleLabel.setClassName("form-title");

        buttonComponent = new ButtonComponent();

        // Agregar los componentes al layout
        add(titleLabel, buttonComponent);
    }

    // Métodos para personalizar el título del formulario
    public void setTitle(String title) {
        titleLabel.setText(title);
    }

    public String getTitle() {
        return titleLabel.getText();
    }

}
