package com.example.proyectotommyeduca.modelo;

public class Colegio {
    private int colegio_id;
    private String colegio_nombre;
    private float latitud, longitud;

    public Colegio() {
    }

    public Colegio(int colegio_id, String colegio_nombre, float latitud, float longitud) {
        this.colegio_id = colegio_id;
        this.colegio_nombre = colegio_nombre;
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public int getColegio_id() {
        return colegio_id;
    }

    public void setColegio_id(int colegio_id) {
        this.colegio_id = colegio_id;
    }

    public String getColegio_nombre() {
        return colegio_nombre;
    }

    public void setColegio_nombre(String colegio_nombre) {
        this.colegio_nombre = colegio_nombre;
    }

    public float getLatitud() {
        return latitud;
    }

    public void setLatitud(float latitud) {
        this.latitud = latitud;
    }

    public float getLongitud() {
        return longitud;
    }

    public void setLongitud(float longitud) {
        this.longitud = longitud;
    }

    @Override
    public String toString() {
        return colegio_nombre;
    }
}
