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

    public void hacerSelect(String letra, String palabra, int linea){
        try {
            /*
             * Cargamos el driver MySQL que hemos descargado anteriormente.
             * Cada BD tiene su propio driver, este únicamente es para
             * las BD MysSQL.
             */
            Class.forName("com.mysql.jdbc.Driver");

            // Setup the connection with the DB
            /*
             * Establecemos la conexión con nuestra BD utilizando
             * los datos de conexión que teníamos almacenados
             * anteriormente.
             */
            connect = DriverManager
                    .getConnection("jdbc:mysql://" + host + "?"
                            + "user=" + user + "&password=" + passwd );

            /*
             * Creamos statement para que la BD nos permita realizar
             * consultas
             */
            preparedStatement = connect
                    .prepareStatement("insert into registro(Letra, Palabra, Linea) values (?, ?, ?)");

            /*
             * Cada uno de los "?" de la consulta indica que ahí se sitúa un parámetro que
             * todavía no se ha añadido. Para poder hacerlo, ejecutamos las consultas set con
             * la posición del parametro que estamos colocando y su valor. LAS POSICIONES
             * EMPIEZAN DESDE 1!.
             */
            preparedStatement.setString(1, letra);
            preparedStatement.setString(2, palabra);
            preparedStatement.setInt(3, linea);
            preparedStatement.executeUpdate();
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
