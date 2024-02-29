package org.jarenas.clientes.proveedores.bd.repositorio;

import org.jarenas.clientes.proveedores.bd.model.Proveedor;
import org.jarenas.clientes.proveedores.bd.model.TipoDocumento;
import org.jarenas.clientes.proveedores.bd.util.ConecionBDMysql;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProveedorRepositorioImpl implements RepositorioPersona<Proveedor> {


    private Connection getConnection() throws SQLException {
        return ConecionBDMysql.getConnection();
    }

    @Override
    public List<Proveedor> listar() {
        List<Proveedor> proveedor = new ArrayList<>();

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM proveedores JOIN tipo_documento ON proveedores.fk_tipo_documento = tipo_documento.id_tipo_documento")) {

            while (rs.next()) {
                Proveedor p = crearProveedor(rs);
                proveedor.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return proveedor;
    }

    @Override
    public Proveedor porId(Long id) {
        Proveedor pId = null;

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT proveedores.*, c.nombre_tipo_documento as nombre_tipo_documento FROM proveedores " +
                     "INNER JOIN tipo_documento as c ON(proveedores.fk_tipo_documento = c.id_tipo_documento) WHERE proveedores.idproveedores = ?")) {
            stmt.setLong(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    pId = crearProveedor(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pId;
    }

    @Override
    public void guardar(Proveedor proveedor) {
        String sql;
        if (proveedor.getId() != null && proveedor.getId() > 0) {
            sql = "UPDATE proveedores set nombre_proveedor=?, celular=?, fk-tipo_documento=?, n_documento=?, correo=?, observaciones=? WHERE idproveedores = ?";
        } else {
            sql = "INSERT INTO proveedores(nombre_proveedor, celular, fk_tipo_documento, n_documento, correo, observaciones, fecha_registro) VALUES (?,?,?,?,?,?,?)";
        }
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, proveedor.getNombre());
            stmt.setLong(2, proveedor.getCelular());
            stmt.setLong(3, proveedor.getTipoDocumento().getId());
            stmt.setLong(4, proveedor.getNumero_documento());
            stmt.setString(5, proveedor.getCorreo());
            stmt.setString(6, proveedor.getObservaciones());

            if (proveedor.getId() != null && proveedor.getId() > 0){
                stmt.setLong(7, proveedor.getId());
            }else{
                stmt.setDate(7, new Date(proveedor.getFecha_registro().getTime()));
            }
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    @Override
    public void eliminar(Long id) {

    }

    @Override
    public List cumpleanios() {
        return null;
    }

    private static Proveedor crearProveedor(ResultSet rs) throws SQLException {
        Proveedor proveedor = new Proveedor();

        proveedor.setId(rs.getLong("idproveedores"));
        proveedor.setNombre(rs.getString("nombre_proveedor"));

        proveedor.setNumero_documento(rs.getLong("n_documento"));
        proveedor.setCelular(rs.getLong("celular"));
        proveedor.setCorreo(rs.getString("correo"));
        proveedor.setFecha_registro(rs.getDate("fecha_registro"));
        proveedor.setObservaciones(rs.getString("observaciones"));
        TipoDocumento tipoDocumento = new TipoDocumento();

        tipoDocumento.setId(rs.getLong("fk_tipo_documento"));
        tipoDocumento.setNombre(rs.getString("nombre_tipo_documento"));
        proveedor.setTipoDocumento(tipoDocumento);


        return proveedor;
    }
}
