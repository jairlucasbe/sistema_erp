package com.upgrade.erp.shared.components.forms;

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

    public TextField addTextField(String label, String placeholder) {
        TextField textField = new TextField(label);
        textField.setPlaceholder(placeholder);
        add(textField);
        formResponsesComponent.addField(label, textField);
        return textField;
    }

    public PasswordField addPasswordField(String label, String placeholder) {
        PasswordField passwordField = new PasswordField(label);
        passwordField.setPlaceholder(placeholder);
        add(passwordField);
        formResponsesComponent.addField(label, passwordField);
        return passwordField;
    }

    public Checkbox addCheckbox(String label) {
        Checkbox checkbox = new Checkbox(label);
        add(checkbox);
        formResponsesComponent.addField(label, checkbox);
        return checkbox;
    }

    public <T> ComboBox<T> addComboBox(String label, List<T> items) {
        ComboBox<T> comboBox = new ComboBox<>(label);
        comboBox.setItems(items);
        add(comboBox);
        formResponsesComponent.addField(label, comboBox);
        return comboBox;
    }

    public NumberField addNumberField(String label, double min, double max) {
        NumberField numberField = new NumberField(label);
        numberField.setMin(min);
        numberField.setMax(max);
        add(numberField);
        formResponsesComponent.addField(label, numberField);
        return numberField;
    }
}
