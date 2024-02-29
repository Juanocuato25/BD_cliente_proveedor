package org.jarenas.clientes.proveedores.bd.model;

import java.util.Date;

public class Persona {
    protected Long id;
    protected String nombre;

    protected Long numero_documento;

    protected Long celular;

    protected String correo;

    protected Date fecha_registro;

    protected TipoDocumento tipoDocumento;

    protected Persona(){

    }

    protected Persona(Long id, String nombre, Long numero_documento, Long celular, String correo, Date fecha_registro, TipoDocumento tipoDocumento) {
        this.id = id;
        this.nombre = nombre;
        this.numero_documento = numero_documento;
        this.celular = celular;
        this.correo = correo;
        this.fecha_registro = fecha_registro;
        this.tipoDocumento = tipoDocumento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getNumero_documento() {
        return numero_documento;
    }

    public void setNumero_documento(Long numero_documento) {
        this.numero_documento = numero_documento;
    }

    public Long getCelular() {
        return celular;
    }

    public void setCelular(Long celular) {
        this.celular = celular;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Date getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(Date fecha_registro) {
        this.fecha_registro = fecha_registro;
    }
}
