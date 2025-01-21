package com.upgrade.erp.shared.layouts.forms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.upgrade.erp.shared.components.buttons.ButtonComponent;
import com.upgrade.erp.shared.components.forms.FormComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import lombok.Getter;

import com.vaadin.flow.component.html.H1;

@Component
public class BaseFormLayout extends VerticalLayout {

    private final H1 title;

    @Getter
    private final ButtonComponent buttonComponent;

    @Getter
    private final FormComponent formComponent;

    public BaseFormLayout(ButtonComponent buttonComponent, FormComponent formComponent) {
        this.title = new H1();
        this.buttonComponent = buttonComponent;
        this.formComponent = formComponent;
        add(this.title, formComponent, buttonComponent);
    }

    public void setTitle(String title) {
        this.title.setText(title);
    }

    public String getTitle() {
        return this.title.getText();
    }
}
