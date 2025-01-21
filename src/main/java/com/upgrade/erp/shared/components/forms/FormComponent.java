package com.upgrade.erp.shared.components.forms;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

import org.springframework.stereotype.Component;

import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.textfield.NumberField;

@Component
public class FormComponent extends FormLayout {

    private final Map<String, Object> fields = new HashMap<>();

    public FormComponent() {
        setResponsiveSteps(new ResponsiveStep("0", 1));
    }

    public TextField addTextField(String label, String placeholder) {
        TextField textField = new TextField(label);
        textField.setPlaceholder(placeholder);
        add(textField);
        fields.put(label, textField);
        return textField;
    }

    public PasswordField addPasswordField(String label, String placeholder) {
        PasswordField passwordField = new PasswordField(label);
        passwordField.setPlaceholder(placeholder);
        add(passwordField);
        fields.put(label, passwordField);
        return passwordField;
    }

    public Checkbox addCheckbox(String label) {
        Checkbox checkbox = new Checkbox(label);
        add(checkbox);
        fields.put(label, checkbox);
        return checkbox;
    }

    public <T> ComboBox<T> addComboBox(String label, List<T> items) {
        ComboBox<T> comboBox = new ComboBox<>(label);
        comboBox.setItems(items);
        add(comboBox);
        fields.put(label, comboBox);
        return comboBox;
    }

    public NumberField addNumberField(String label, double min, double max) {
        NumberField numberField = new NumberField(label);
        numberField.setMin(min);
        numberField.setMax(max);
        add(numberField);
        fields.put(label, numberField);
        return numberField;
    }

    public String getTextFieldValue(String label) {
        TextField textField = (TextField) fields.get(label);
        return textField != null ? textField.getValue() : null;
    }
    
    public String getPasswordFieldValue(String label) {
        PasswordField passwordField = (PasswordField) fields.get(label);
        return passwordField != null ? passwordField.getValue() : null;
    }
    
    public boolean getCheckboxValue(String label) {
        Checkbox checkbox = (Checkbox) fields.get(label);
        return checkbox != null && checkbox.getValue();
    }

    public <T> T getComboBoxValue(String label) {
        Object field = fields.get(label);
        if (field instanceof ComboBox<?>) {
            @SuppressWarnings("unchecked")
            ComboBox<T> comboBox = (ComboBox<T>) field;
            return comboBox.getValue();
        }
        return null;
    }
    
    
    public Double getNumberFieldValue(String label) {
        NumberField numberField = (NumberField) fields.get(label);
        return numberField != null ? numberField.getValue() : null;
    }
    

    public void clearForm() {
        removeAll();
    }
}
