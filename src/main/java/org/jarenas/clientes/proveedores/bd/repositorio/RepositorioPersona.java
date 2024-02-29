package org.jarenas.clientes.proveedores.bd.repositorio;

import java.sql.SQLException;
import java.util.List;

public interface RepositorioPersona<T> {
    List<T> listar();

    T porId(Long id);

    void guardar(T t);

    void eliminar(Long id);

    List<T> cumpleanios();
}
