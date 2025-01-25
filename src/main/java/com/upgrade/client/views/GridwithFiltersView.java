package com.upgrade.client.views;

import org.vaadin.lineawesome.LineAwesomeIconUrl;

import com.upgrade.server.entities.SamplePerson;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Ordenes de Venta")
@Route("Persons")
@Menu (order = 0, icon = LineAwesomeIconUrl.FIRE_EXTINGUISHER_SOLID)
@Uses (Icon.class)
public class GridwithFiltersView extends Div {
        private Grid<SamplePerson> grid;
        //private Filters filters; -> para filtrar los datos
        //private final SamplePersonService -> para importar todos los datos

        public GridwithFiltersView(){ //-> filtrar datos
                VerticalLayout layout =  new VerticalLayout(createGrid());
                layout.setSizeFull();
                layout.setPadding(false);
                layout.setSpacing(false);
                add(layout);
        } 
       
       //private HorizontalLayout createLayoutHorizontal(){} -> para filtros

       private Component createGrid(){
            grid = new Grid<>(SamplePerson.class,false);
            grid.addColumn("firstName").setAutoWidth(true);
            grid.addColumn("lastName").setAutoWidth(true);
            grid.addColumn("email").setAutoWidth(true);
            grid.addColumn("phone").setAutoWidth(true);
            grid.addColumn("dateOfBirth").setAutoWidth(true);
            grid.addColumn("occupation").setAutoWidth(true);
            grid.addColumn("role").setAutoWidth(true);
            
            return grid;
           
       }
}
