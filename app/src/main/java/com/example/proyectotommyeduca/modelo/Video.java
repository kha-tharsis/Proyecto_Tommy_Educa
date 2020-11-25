package com.example.proyectotommyeduca.modelo;

public class Video {
    private int video_id;
    private String titulo;
    private int colegio_id_fk;
    private String codigo;
    private String descripcion;

    public Video(int video_id, String titulo, int colegio_id_fk, String codigo, String descripcion) {
        this.video_id = video_id;
        this.titulo = titulo;
        this.colegio_id_fk = colegio_id_fk;
        this.codigo = codigo;
        this.descripcion = descripcion;
    }

    public int getVideo_id() {
        return video_id;
    }

    public void setVideo_id(int video_id) {
        this.video_id = video_id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getColegio_id_fk() {
        return colegio_id_fk;
    }

    public void setColegio_id_fk(int colegio_id_fk) {
        this.colegio_id_fk = colegio_id_fk;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
