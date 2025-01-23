package com.upgrade.erp.client.components.forms;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;

@Component
public class FormResponsesComponent {   

    private final Map<String, Object> fields = new HashMap<>();

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

    public void addField(String label, Object field) {
        fields.put(label, field);
    }

    public void clearForm() {
        fields.clear();
    }
}