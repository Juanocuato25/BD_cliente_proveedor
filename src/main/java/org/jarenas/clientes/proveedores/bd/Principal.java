package org.jarenas.clientes.proveedores.bd;

import org.jarenas.clientes.proveedores.bd.model.Proveedor;
import org.jarenas.clientes.proveedores.bd.model.TipoDocumento;
import org.jarenas.clientes.proveedores.bd.repositorio.ProveedorRepositorioImpl;
import org.jarenas.clientes.proveedores.bd.repositorio.RepositorioPersona;
import org.jarenas.clientes.proveedores.bd.repositorio.RepositorioTipoDocumento;
import org.jarenas.clientes.proveedores.bd.repositorio.TipoDocumentoRepositorioImpl;

import java.util.Date;

public class Principal {
    public static void main(String[] args) {

        RepositorioTipoDocumento<TipoDocumento> rtp = new TipoDocumentoRepositorioImpl();

        RepositorioPersona<Proveedor> repositorioProveedor = new ProveedorRepositorioImpl();

        //rtp.listarTP().forEach(System.out::println);
        //repositorioProveedor.listar().forEach(System.out::println);
        //System.out.println(repositorioProveedor.porId(1L));

        Proveedor p = new Proveedor();
        p.setNombre("Coca Cola");
        p.setCelular(601796511L);
        TipoDocumento tp = new TipoDocumento();
        tp.setId(1L);
        p.setTipoDocumento(tp);
        p.setNumero_documento(30313031L);
        p.setFecha_registro(new Date());
        p.setCorreo("cocacola@outloo.com");
        p.setObservaciones("Dias toma de pedido: Lunes y jueves \n Dias de entrega pedido: Martes y Jueves");

        repositorioProveedor.guardar(p);
        repositorioProveedor.listar().forEach(System.out::println);

    }
}
