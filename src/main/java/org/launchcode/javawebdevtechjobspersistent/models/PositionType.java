package org.launchcode.javawebdevtechjobspersistent.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class PositionType extends JobField {

    public PositionType(String value) {
        super(value);
    }

}
//@Entity
//public class PositionType extends JobField{
//
//    @Id
//    @GeneratedValue
//    private int id;
//
//    @NotNull
//    @Size(min=3, max=15)
//    private String name;
//
//    public PositionType() {
//    }
//
//    public PositionType(@NotNull @Size(min = 3, max = 15) String name) {
//        this.name = name;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//}
