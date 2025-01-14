    package com.upgrade.erp.modules.auth.modules.views;

    import org.vaadin.lineawesome.LineAwesomeIconUrl;
    
    import com.upgrade.erp.modules.auth.modules.controllers.dto.CreateModuleDtoRequest;
    import com.upgrade.erp.modules.auth.modules.services.ModuleServiceImpl;
    import com.vaadin.flow.component.button.Button;
    import com.vaadin.flow.component.formlayout.FormLayout;
    import com.vaadin.flow.component.html.H1;
    import com.vaadin.flow.component.notification.Notification;
    import com.vaadin.flow.component.orderedlayout.VerticalLayout;
    import com.vaadin.flow.component.textfield.TextField;
    import com.vaadin.flow.router.Menu;
    import com.vaadin.flow.router.PageTitle;
    import com.vaadin.flow.router.Route;

    @PageTitle("Create Module")
    @Route("create")
    @Menu(order = 1, icon = LineAwesomeIconUrl.ADDRESS_CARD_SOLID)
    public class ModuleCreateView extends VerticalLayout {

        private final ModuleServiceImpl moduleService;

        public ModuleCreateView(ModuleServiceImpl moduleService) {
            this.moduleService = moduleService;
            setClassName("module-create-view");
            setAlignItems(Alignment.CENTER);
            setJustifyContentMode(JustifyContentMode.CENTER);

            H1 title = new H1("Create New Module");

            TextField numberField = new TextField("Number");
            numberField.setRequired(true);

            TextField nameField = new TextField("Name");
            nameField.setRequired(true);

            TextField descriptionField = new TextField("Description");

            TextField isActiveField = new TextField("Is Active");
            isActiveField.setPlaceholder("true/false");

            Button saveButton = new Button("Save", event -> {
                try {
                    CreateModuleDtoRequest request = new CreateModuleDtoRequest(
                        Long.parseLong(numberField.getValue()),
                        nameField.getValue(),
                        descriptionField.getValue(),
                        Boolean.parseBoolean(isActiveField.getValue())
                    );

                    moduleService.createModule(request.toEntity());
                    Notification.show("Module created successfully!", 3000, Notification.Position.MIDDLE);

                    // Clear all fields after saving
                    numberField.clear();
                    nameField.clear();
                    descriptionField.clear();
                    isActiveField.clear();
                } catch (Exception e) {
                    Notification.show("Error: " + e.getMessage(), 3000, Notification.Position.MIDDLE);
                }
            });

            // Add fields to the form layout
            FormLayout formLayout = new FormLayout();
            formLayout.add(numberField, nameField, descriptionField, isActiveField, saveButton);

            add(title, formLayout);
        }
    }
