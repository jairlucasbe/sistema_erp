package com.upgrade.erp.shared.components;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.splitlayout.SplitLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility;

@Route("split-layout-basic")
public class SplitLayoutBasic extends Div {

    public SplitLayoutBasic() {
        // Crear las divisiones Master y Detail
        Div master = new Div();
        Div detail = new Div();

        // Asignar clases de Lumo para personalización de estilos
        master.addClassNames(LumoUtility.Background.CONTRAST_5, LumoUtility.Padding.SMALL);
        detail.addClassNames(LumoUtility.Background.CONTRAST_30, LumoUtility.Padding.SMALL);

        // Configurar el SplitLayout
        SplitLayout splitLayout = new SplitLayout(master, detail);
        splitLayout.setMaxHeight("280px");
        splitLayout.setSizeFull(); // Asegura que ocupa todo el espacio disponible

        // Agregar el SplitLayout al contenedor principal
        add(splitLayout);
    }
}