package com.upgrade.commons.components.buttons;

import org.springframework.stereotype.Component;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

@Component
public class ButtonComponent extends HorizontalLayout {

    public ButtonComponent() {
        // setSpacing(true);
        // setPadding(true);
    }

    public void addButton(String text, Runnable onClick) {
        Button button = new Button(text);
        button.addClickListener(event -> onClick.run());
        add(button);
    }

    public void clearButtons() {
        removeAll();
    }

    public void addButton(String text, String style, Runnable onClick) {
        Button button = new Button(text);
        button.addClassName(style);
        button.addClickListener(event -> onClick.run());
        add(button);
    }

    public void setButtonsEnabled(boolean enabled) {
        getChildren().filter(component -> component instanceof Button)
            .forEach(component -> ((Button) component).setEnabled(enabled));
    }
}
