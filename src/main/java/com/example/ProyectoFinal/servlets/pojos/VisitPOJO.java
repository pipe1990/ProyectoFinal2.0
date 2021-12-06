package com.example.ProyectoFinal.servlets.pojos;


/**
 * POJO base class, for Visits to a vet
 */
public class VisitPOJO {

    private Integer visit_id;

    private String created_at;

    private String type;

    private String description;

    private Integer vet_id;

    private Integer pet_id;
    /**
     * Constructor Method
     */
    public VisitPOJO() {

    }

    /**
     * Second constructor method  of VisitPOJO with params
     * @param visit_id: Integer
     * @param created_id: String
     * @param type: String
     * @param description: String
     * @param vet_id: Integer
     * @param pet: Integer
     */
    public VisitPOJO(Integer visit_id, String created_id, String type, String description, Integer vet_id, Integer pet) {
        this.visit_id = visit_id;
        this.created_at = created_id;
        this.type = type;
        this.description = description;
        this.vet_id = vet_id;
        this.pet_id = pet;
    }

    public Integer getVisit_id() {
        return visit_id;
    }

    public void setVisit_id(Integer visit_id) {
        this.visit_id = visit_id;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getVet_id() {
        return vet_id;
    }

    public void setVet_id(Integer vet_id) {
        this.vet_id = vet_id;
    }

    public Integer getPet_id() {
        return pet_id;
    }

    public void setPet_id(Integer pet_id) {
        this.pet_id = pet_id;
    }
}