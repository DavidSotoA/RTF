
package com.websystique.springsecurity.dao;

import com.websystique.springsecurity.model.Programacion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;


public class ProgramacionDAOImp implements ProgramacionDAO {

    private JdbcTemplate jdbcTemplate;
    
    public ProgramacionDAOImp(DataSource dataSource)  {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    //@Override
    public void insertar_actualizar(Programacion programacion) {                // de la plantilla, ubico el registro y ejecuto sentencia.
        if(Integer.parseInt(programacion.getIdProgramacion()) > 0){                               // si el objeto ya existia, este campo ya tiene un valor diferente de cero.
                
            String sql = "UPDATE programacion SET hora=? WHERE idProgramacion=?";
            jdbcTemplate.update(sql, programacion.getHora(), programacion.getIdProgramacion());         
        }else{
            //insertar
            String sql = "INSERT INTO programacion (sala, pelicula, hora) VALUES (?,?,?)";
            jdbcTemplate.update(sql, programacion.getSala(), programacion.getPelicula(), programacion.getHora());
        }
    }
    
//    //@Override
//    public void insertar(Programacion programacion) {
//
//        String sql = "INSERT INTO programacion (sala, pelicula, hora) VALUES (?,?,?)";
//        jdbcTemplate.update(sql, programacion.getSala(), programacion.getPelicula(), programacion.getHora());
//    }

    //@Override
    public void eliminar(int programacionID) {
        String sql = "DELETE FROM programacion WHERE idProgramacion=?";
        jdbcTemplate.update(sql, programacionID);
    }

    //@Override
    public Programacion buscar(int programacionID) {

        String sql = "SELECT * FROM programacion WHERE idProgramacion="
                + programacionID;
        return jdbcTemplate.query(sql, new ResultSetExtractor<Programacion>() {

            
            // retorna la consulta en un objeto  (?)
            @Override
            public Programacion extractData(ResultSet rs) throws SQLException, DataAccessException {

                if (rs.next()) {
                    Programacion programacion = new Programacion();
                    programacion.setIdProgramacion(rs.getString("idProgramacion"));
                    programacion.setSala(rs.getString("sala"));
                    programacion.setPelicula(rs.getString("pelicula"));
                    programacion.setHora(rs.getString("hora"));
                    return programacion;
                }

                return null;
            }
        });
    }

    //@Override
    public List<Programacion> listar() {
        String sql = "SELECT * FROM programacion";
        List<Programacion> listaProgramacion = jdbcTemplate.query(sql, new RowMapper<Programacion>() {

            @Override
            public Programacion mapRow(ResultSet rs, int rowNum) 
                throws SQLException {
                
                Programacion unaProgramacion = new Programacion();

                unaProgramacion.setIdProgramacion(rs.getString("idProgramacion"));
                unaProgramacion.setSala(rs.getString("sala"));
                unaProgramacion.setPelicula(rs.getString("pelicula"));
                unaProgramacion.setHora(rs.getString("hora"));
                
                return unaProgramacion;
            }
        });

        return listaProgramacion;
    }

}
