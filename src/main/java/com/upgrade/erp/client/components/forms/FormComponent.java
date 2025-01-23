package com.upgrade.erp.client.components.forms;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.textfield.TextField;

import lombok.Getter;

import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.textfield.NumberField;

@Component
public class FormComponent extends FormLayout {

    @Autowired
    @Getter
    private FormResponsesComponent formResponsesComponent;

    private int fieldCount = 0;  // Contador de campos

    public FormComponent() {
        // Ajuste inicial (esto se actualizará dinámicamente)
        setResponsiveSteps(
            new FormLayout.ResponsiveStep("0", 1), // 1 columna por defecto
            new FormLayout.ResponsiveStep("600px", 1), // En pantallas más grandes, siempre 1 columna
            new FormLayout.ResponsiveStep("900px", 1)  // Mantener 1 columna, ya que lo ajustamos dinámicamente
        );
    }

    private void adjustColumnLayout() {
        // Ajustar el número de columnas según la cantidad de campos
        if (fieldCount <= 7) {
            setResponsiveSteps(
                new FormLayout.ResponsiveStep("0", 1), // 1 columna
                new FormLayout.ResponsiveStep("600px", 1),
                new FormLayout.ResponsiveStep("900px", 1)
            );
        } else if (fieldCount <= 14) {
            setResponsiveSteps(
                new FormLayout.ResponsiveStep("0", 2), // 2 columnas
                new FormLayout.ResponsiveStep("600px", 2),
                new FormLayout.ResponsiveStep("900px", 2)
            );
        } else {
            setResponsiveSteps(
                new FormLayout.ResponsiveStep("0", 3), // 3 columnas
                new FormLayout.ResponsiveStep("600px", 3),
                new FormLayout.ResponsiveStep("900px", 3)
            );
        }
    }

    public TextField addTextField(String label, String placeholder) {
        TextField textField = new TextField(label);
        textField.setPlaceholder(placeholder);
        add(textField);
        formResponsesComponent.addField(label, textField);
        fieldCount++;
        adjustColumnLayout();
        return textField;
    }

    public PasswordField addPasswordField(String label, String placeholder) {
        PasswordField passwordField = new PasswordField(label);
        passwordField.setPlaceholder(placeholder);
        add(passwordField);
        formResponsesComponent.addField(label, passwordField);
        fieldCount++;
        adjustColumnLayout();
        return passwordField;
    }

    public Checkbox addCheckbox(String label) {
        Checkbox checkbox = new Checkbox(label);
        add(checkbox);
        formResponsesComponent.addField(label, checkbox);
        fieldCount++;
        adjustColumnLayout();
        return checkbox;
    }

    public <T> ComboBox<T> addComboBox(String label, List<T> items) {
        ComboBox<T> comboBox = new ComboBox<>(label);
        comboBox.setItems(items);
        add(comboBox);
        formResponsesComponent.addField(label, comboBox);
        fieldCount++;
        adjustColumnLayout();
        return comboBox;
    }

    public NumberField addNumberField(String label, double min, double max) {
        NumberField numberField = new NumberField(label);
        numberField.setMin(min);
        numberField.setMax(max);
        add(numberField);
        formResponsesComponent.addField(label, numberField);
        fieldCount++;
        adjustColumnLayout();
        return numberField;
    }
}
