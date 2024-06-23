package com.proyectojava.revisions.domain.models;

import java.sql.Date;

public class Revisions {
    private int id_revision;
    private Date fecha_revision;
    private int id_avion;

    public Revisions() {
    }

    public Revisions(int id_revision, Date fecha_revision, int id_avion) {
        this.id_revision = id_revision;
        this.fecha_revision = fecha_revision;
        this.id_avion = id_avion;
    }

    public int getId_revision() {
        return id_revision;
    }

    public void setId_revision(int id_revision) {
        this.id_revision = id_revision;
    }

    public Date getFecha_revision() {
        return fecha_revision;
    }

    public void setFecha_revision(Date fecha_revision) {
        this.fecha_revision = fecha_revision;
    }

    public int getId_avion() {
        return id_avion;
    }

    public void setId_avion(int id_avion) {
        this.id_avion = id_avion;
    }
    
    
}
