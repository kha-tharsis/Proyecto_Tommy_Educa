package cl.santotomas.tomyeduca.modelo;

public class Video {
    private int video_id;
    private String titulo;
    private String codigo;
    private String descripcion;

    public Video(int video_id, String titulo, String codigo, String descripcion) {
        this.video_id = video_id;
        this.titulo = titulo;
        this.codigo = codigo;
        this.descripcion = descripcion;
    }

    public Video() {

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
