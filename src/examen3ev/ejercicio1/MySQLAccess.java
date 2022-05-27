package examen3ev.ejercicio1;

import java.sql.*;

public class MySQLAccess {

    /*
     * Almacenamos la conexión con nuestra bd en
     * un objeto de tipo Connection. La abrimos cuando
     * queremos empezar a operar con la BD y siempre
     * debemos cerrarla al finalizar.
     */
    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    /*
     * Almacena el resultado de las consultas en un dato de
     * tipo ResultSet, que tiene sus propios métodos para trabajar
     * con las tablas y columnas.
     */
    private ResultSet resultSet = null;

    /*
     * Almacenamos los datos de conexión con nuestra BD.
     */
    final private String host = "localhost:3306/examen";
    final private String user = "root";
    final private String passwd = "";

    private void readDataBase() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");

        connect = DriverManager
                .getConnection("jdbc:mysql://" + host + "?"
                        + "user=" + user + "&password=" + passwd );
    }

    public void hacerSelect(String consulta){
        try {
            readDataBase();
            preparedStatement = connect
                    .prepareStatement(consulta);
            resultSet = preparedStatement.executeQuery();
        }catch (Exception e){
            System.out.println(e.toString());
        }finally {
            close();
        }
    }

    private void close() {
        try {
            if (resultSet != null) {
                resultSet.close();
            } if (statement != null) {
                statement.close();
            } if (connect != null) {
                connect.close();
            }
        } catch (Exception e) {}
    }

}
