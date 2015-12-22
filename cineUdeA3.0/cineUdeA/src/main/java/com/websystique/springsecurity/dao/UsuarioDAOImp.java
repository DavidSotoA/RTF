
package com.websystique.springsecurity.dao;

import com.websystique.springsecurity.model.Usuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;


public class UsuarioDAOImp implements UsuarioDAO {

    private JdbcTemplate jdbcTemplate;

    public UsuarioDAOImp(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void saveOrUpdate(Usuario usuario) {                                   // implementacion del POJO para guardar o actualizar 
        // insert
        String sql = "INSERT INTO users(apellidos,cedula,contrasena,correoElectronico,"
                + "direccion,enabled,nombre,puntos,tarjetaDeCredito,telefono)\n"
                + "VALUES (?,?,?,?,?,?,?,?,?,?);";
        jdbcTemplate.update(sql, usuario.getApellidos(), usuario.getCedula(), 
                usuario.getContrasena(), usuario.getCorreoElectronico(), usuario.getDireccion(), 
                true, usuario.getNombre(), usuario.getPuntos(), usuario.getTarjetaDeCredito(), 
                usuario.getTelefono());
    }

    public void delete(String cedula) {
        String sql = "DELETE FROM users WHERE cedula=?";
        jdbcTemplate.update(sql, cedula);
    }

    public Usuario get(String cedula) {                                         // implementacion del POJO para consultar
        String sql = "SELECT * FROM users WHERE cedula='"+cedula+"'";
        return jdbcTemplate.query(sql, new ResultSetExtractor<Usuario>() {

            @Override
            public Usuario extractData(ResultSet rs) throws SQLException,
                    DataAccessException {
                if (rs.next()) {
                    Usuario contact = new Usuario();
                    contact.setApellidos(rs.getString("apellidos"));
                    contact.setCedula(rs.getString("cedula"));
                    contact.setCorreoElectronico(rs.getString("correoElectronico"));
                    contact.setDireccion(rs.getString("direccion"));
                    contact.setNombre(rs.getString("nombre"));
                    contact.setPuntos(rs.getString("puntos"));
                    contact.setTelefono("telefono");
                    contact.setTarjetaDeCredito(rs.getString("tarjetaDeCredito"));
                    return contact;
                }
                return null;
            }
        });
    }

}
