package com.upgrade.server.entities;



import com.vaadin.flow.component.template.Id;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Version;

@MappedSuperclass
public abstract class AbstracEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idgenerator")
    @SequenceGenerator(name = "idgenerator", initialValue =  1000)
    private Long id;

    @Version 
    private int vesrion;

    public Long getId(){
        return id;
    }

    public void setId (Long id){
            this.id = id;
    }

    public int getVersion(){
        return vesrion;
    }

@Override
public int hashCode(){
    if (getId() !=  null) {
        return getId().hashCode();
    }
    return super.hashCode();
}

@Override 
public boolean equals(Object obj){
    if (!(obj instanceof AbstracEntity that)) {
        return false;    
    }if (getId() != null){
        return getId().equals(that.getId());
    }
    return super.equals(that);
 }
 
}


