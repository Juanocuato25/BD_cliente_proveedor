package org.jarenas.clientes.proveedores.bd.model;

import java.sql.Date;

public class Proveedor extends Persona {

    private String observaciones;

    public Proveedor() {
    }

    public Proveedor(String observaciones, Long id, String nombre, Long numero_documento, Long celular, String correo, Date fecha_registro, TipoDocumento tipoDocumento) {
        super(id, nombre, numero_documento, celular, correo, fecha_registro, tipoDocumento);
        this.observaciones = observaciones;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    @Override
    public String toString() {
        return "Proveedor{" +
                ", Id= " + id +
                ", Nombre= '" + nombre + '\'' +
                ", Tipo Documento "+ tipoDocumento.toString() +
                ", Numero_documento = " + numero_documento +
                ", Celular = " + celular +
                ", Correo = '" + correo + '\'' +
                ", Fecha registro = " + fecha_registro +
                ", Observaciones = '" + observaciones + '\'' + '}';
    }
}
