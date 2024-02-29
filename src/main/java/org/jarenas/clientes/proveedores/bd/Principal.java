package org.jarenas.clientes.proveedores.bd;

import org.jarenas.clientes.proveedores.bd.model.Cliente;
import org.jarenas.clientes.proveedores.bd.model.Proveedor;
import org.jarenas.clientes.proveedores.bd.model.TipoDocumento;
import org.jarenas.clientes.proveedores.bd.repositorio.*;

import java.util.Date;

public class Principal {
    public static void main(String[] args) {

        RepositorioTipoDocumento<TipoDocumento> rtp = new TipoDocumentoRepositorioImpl();

        RepositorioPersona<Proveedor> repositorioProveedor = new ProveedorRepositorioImpl();

        //rtp.listarTP().forEach(System.out::println);
        //repositorioProveedor.listar().forEach(System.out::println);
        //System.out.println(repositorioProveedor.porId(1L));


        /*Proveedor p = new Proveedor();
        p.setNombre("Coca Cola");
        p.setCelular(601796511L);
        TipoDocumento tp = new TipoDocumento();
        tp.setId(1L);
        p.setTipoDocumento(tp);
        p.setNumero_documento(30313031L);
        p.setFecha_registro(new Date());
        p.setCorreo("cocacola@outloo.com");
        p.setObservaciones("Dias toma de pedido: Lunes y jueves Dias de entrega pedido: Martes y Jueves");

        repositorioProveedor.guardar(p);
        repositorioProveedor.listar().forEach(System.out::println);

        repositorioProveedor.eliminar(3L);
        repositorioProveedor.listar().forEach(System.out::println);*/

        RepositorioPersona<Cliente> repositorioPersona = new ClienteRepositorioImpl();

        //repositorioPersona.listar().forEach(System.out::println);
        //repositorioPersona.cumpleanios().forEach(System.out::println);

       /* Cliente c = new Cliente();
        c.setNombre("Helena");
        c.setCelular(315876543L);
        TipoDocumento tp = new TipoDocumento();
        tp.setId(1L);
        c.setTipoDocumento(tp);
        c.setNumero_documento(109876533L);
        c.setFecha_registro(new Date());
        c.setCorreo("helena@outlook.com");
        c.setFecha_nacimiento("1985-03-01");
        repositorioPersona.guardar(c);*/
        repositorioPersona.listar().forEach(System.out::println);
        System.out.println("-------------------------Cumpleañeros-------------------------------");
        repositorioPersona.cumpleanios().forEach(System.out::println);




    }
}
