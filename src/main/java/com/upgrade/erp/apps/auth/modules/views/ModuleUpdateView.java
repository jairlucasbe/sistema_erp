package com.upgrade.erp.apps.auth.modules.views;

import org.vaadin.lineawesome.LineAwesomeIconUrl;

import com.upgrade.erp.apps.auth.modules.services.ModuleServiceImpl;
import com.upgrade.erp.shared.layouts.forms.BaseFormLayout;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Update Module")
@Route("update")
@Menu(order = 2, icon = LineAwesomeIconUrl.ACCUSOFT)
public class ModuleUpdateView extends BaseFormLayout {

    public ModuleUpdateView(ModuleServiceImpl moduleService) {
        super.setTitle("Update Module");
        this.buildFormComponent();
        super.getButtonComponent().addButton("Save", null);
        super.getButtonComponent().addButton("Delete",null);
    }

    private void buildFormComponent(){
        super.getFormComponent().addTextField("Number", "Enter module number");
        super.getFormComponent().addTextField("Name", "Enter module name");
        super.getFormComponent().addTextField("Description", "Enter module description");
        super.getFormComponent().addTextField("Is Active", "true/false");
    }
}
