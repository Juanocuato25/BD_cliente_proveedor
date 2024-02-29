package org.jarenas.clientes.proveedores.bd.model;

import java.sql.Date;

public class Cliente extends Persona {

    private Date fecha_nacimiento;

    public Cliente() {
    }

    public Cliente(Date fecha_nacimiento, Long id, String nombre, Long numero_documento, Long celular, String correo, Date fecha_registro, TipoDocumento tipoDocumento) {
        super(id, nombre, numero_documento, celular, correo, fecha_registro,tipoDocumento);
        this.fecha_nacimiento = fecha_nacimiento;
    }


    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                ", id=" + id +
                ", nombre='" + nombre + '\'' +
                ", numero_documento=" + numero_documento +
                ", celular=" + celular +
                ", correo='" + correo + '\'' +
                ", fecha_registro=" + fecha_registro +
                "fecha_nacimiento=" + fecha_nacimiento + '}';
    }
}