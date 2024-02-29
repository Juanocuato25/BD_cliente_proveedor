package org.jarenas.clientes.proveedores.bd.repositorio;

import org.jarenas.clientes.proveedores.bd.model.Cliente;
import org.jarenas.clientes.proveedores.bd.model.TipoDocumento;
import org.jarenas.clientes.proveedores.bd.util.ConecionBDMysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ClienteRepositorioImpl implements RepositorioPersona<Cliente> {

    private Connection getConnection() throws SQLException {
        return ConecionBDMysql.getConnection();
    }

    @Override
    public List<Cliente> listar() {
        List<Cliente> clientes = new ArrayList<>();
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM clientes JOIN tipo_documento  ON clientes.fk_tipo_documento = tipo_documento.id_tipo_documento")){

            while (rs.next()){
                Cliente c = crearCliente(rs);
                clientes.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clientes;
    }

    @Override
    public Cliente porId(Long id) {
        return null;
    }

    @Override
    public void guardar(Cliente cliente) {

    }

    @Override
    public void eliminar(Long id) {

    }

    @Override
    public List<Cliente> cumpleanios() {
        List<Cliente> clientes = new ArrayList<>();
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * " +
                     "FROM clientes JOIN tipo_documento ON clientes.fk_tipo_documento = tipo_documento.id_tipo_documento " +
                     "WHERE DATE_FORMAT(fecha_nacimiento, '%m-%d') BETWEEN DATE_FORMAT(CURRENT_DATE, '%m-%d') " +
                     "AND DATE_FORMAT(DATE_ADD(CURRENT_DATE, INTERVAL 5 DAY), '%m-%d');")){

            while (rs.next()){
                Cliente c = crearCliente(rs);
                clientes.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clientes;

    }

    private static Cliente crearCliente(ResultSet rs) throws SQLException {
        Cliente cliente = new Cliente();

        cliente.setId(rs.getLong("id_cliente"));
        cliente.setNombre(rs.getString("nombre_cliente"));
        cliente.setCelular(rs.getLong("celular"));

        TipoDocumento tipoDocumento = new TipoDocumento();

        tipoDocumento.setId(rs.getLong("fk_tipo_documento"));
        tipoDocumento.setNombre(rs.getString("nombre_tipo_documento"));

        cliente.setTipoDocumento(tipoDocumento);
        cliente.setNumero_documento(rs.getLong("n_documento"));
        cliente.setCelular(rs.getLong("celular"));
        cliente.setCorreo(rs.getString("correo"));
        cliente.setFecha_nacimiento(rs.getDate("fecha_nacimiento"));
        cliente.setFecha_registro(rs.getDate("fecha_registro"));


        return cliente;
    }


}
