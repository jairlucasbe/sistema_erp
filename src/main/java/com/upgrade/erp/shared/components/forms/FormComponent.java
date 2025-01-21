package com.upgrade.erp.shared.components.forms;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.textfield.TextField;

public class FormComponent extends FormLayout {

    public FormComponent() {
        setResponsiveSteps(new ResponsiveStep("0", 1));
    }

    public TextField addTextField(String label, String placeholder) {
        TextField textField = new TextField(label);
        textField.setPlaceholder(placeholder);
        add(textField);
        return textField;
    }

    public void addComponent(Component component) {
        add(component);
    }

    public void clearForm() {
        removeAll();
    }
}
