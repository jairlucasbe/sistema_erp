package com.upgrade.erp.shared.layouts.forms;

import com.upgrade.erp.shared.components.buttons.ButtonComponent;
import com.upgrade.erp.shared.components.forms.FormComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import lombok.Getter;

import com.vaadin.flow.component.html.H1;

public class BaseFormLayout extends VerticalLayout {

    private final H1 title;

    @Getter
    private final ButtonComponent buttonComponent;

    @Getter
    private final FormComponent formComponent;

    public BaseFormLayout() {
        title = new H1();
        buttonComponent = new ButtonComponent();
        formComponent = new FormComponent();
        add(this.title, formComponent, buttonComponent);
    }

    public void setTitle(String title) {
        this.title.setText(title);
    }

    public String getTitle() {
        return this.title.getText();
    }

}
