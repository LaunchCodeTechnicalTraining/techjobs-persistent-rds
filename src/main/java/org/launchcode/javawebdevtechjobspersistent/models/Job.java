package org.launchcode.javawebdevtechjobspersistent.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Objects;

@Entity
public class Job {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min=3, max=15)
    private String name;

    @ManyToOne
    private Employer employer;

    // private String positionType;

//    @ManyToMany(mappedBy = "jobs")
//    private List<CoreCompetency> coreCompetencies;

    public Job() {
    }

//    public Job(String name) {
//        this.name = name;
//    }

    // Initialize the id and value fields.
    public Job(String aName, Employer anEmployer) {
        this();
        name = aName;
        employer = anEmployer;
//        positionType = aPositionType;
//        coreCompetencies = someCoreCompetencies;
    }

    // Custom toString method.
//    @Override
//    public String toString(){
//        String output = "";
//        if (name.equals("")){
//            name = "Data not available";
//        }
//        if (location.equals("") || location == null){
//            location = "Data not available";
//        }
//        if (coreCompetency.equals("") || coreCompetency == null){
//            coreCompetency = "Data not available";
//        }
//        if (positionType.equals("") || positionType == null){
//            positionType = "Data not available";
//        }
//
//        output = String.format("\nID: %d\n" +
//                "Name: %s\n" +
//                "Employer: %s\n" +
//                "Location: %s\n" +
//                "Position Type: %s\n" +
//                "Core Competency: %s\n", id, name, employer, location, positionType, coreCompetency);
//        return output;
//    }

    // Custom equals and hashCode methods. Two Job objects are "equal" when their id fields match.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Job)) return false;
        Job job = (Job) o;
        return id == job.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


    // Getters and setters.

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

//    public String getPositionType() {
//        return positionType;
//    }
//
//    public void setPositionType(String positionType) {
//        this.positionType = positionType;
//    }
//
//    public List<CoreCompetency> getCoreCompetencies() {
//        return coreCompetencies;
//    }
//
//    public void setCoreCompetencies(List<CoreCompetency> coreCompetencies) {
//        this.coreCompetencies = coreCompetencies;
//    }
}
