package org.jarenas.clientes.proveedores.bd.repositorio;

import org.jarenas.clientes.proveedores.bd.model.TipoDocumento;
import org.jarenas.clientes.proveedores.bd.util.ConecionBDMysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TipoDocumentoRepositorioImpl implements RepositorioTipoDocumento {

    private Connection getConnection() throws SQLException {
        return ConecionBDMysql.getConnection();
    }

    @Override
    public List<TipoDocumento> listarTP() {
        List<TipoDocumento> tp = new ArrayList<>();

        try(Connection conn = getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM tipo_documento")){

            while (rs.next()){
                TipoDocumento tipoDocumento = crearTipoDocumento(rs);
                tp.add(tipoDocumento);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tp;
    }

    private static TipoDocumento crearTipoDocumento(ResultSet rs) throws SQLException {
        TipoDocumento tipoDocumento = new TipoDocumento();
        tipoDocumento.setId(rs.getLong("id_tipo_documento"));
        tipoDocumento.setNombre(rs.getString("nombre_tipo_documento"));
        return tipoDocumento;
    }
}
