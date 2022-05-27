package examen3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLAccessPrueba {

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
    }

    public String hacerSelect(String consulta){
        try {
            readDataBase();
            preparedStatement = connect
                    .prepareStatement(consulta);
            System.out.println("QUERY ---> "+consulta);
            resultSet = preparedStatement.executeQuery();

            System.out.println(resultSet.getMetaData().getColumnCount());
            System.out.println(resultSet.getMetaData().toString());
            String resultados = "";

            System.out.println("eyyyyy");

            System.out.println(resultSet.getString(1));

            System.out.println("si no aparece nada, es nulo");
            for (int i = 0; i < resultSet.getMetaData().getColumnCount(); i++){
                resultados+= resultSet.getMetaData().getColumnName(i)+"/;/";
                resultados+="\n";
            }
        }catch (Exception e){
            System.out.println(e.toString());
        }finally {
            close();
        }
        return "";
    }

    /**
     * Pre: ---
     * Post: muestra por pantalla el nombre de la tabla sobre la que se ha ejecutado
     * 		la consulta, seguido de todas sus columnas.
     */
    /*
    private void writeMetaData(ResultSet resultSet) throws SQLException {
        System.out.println("The columns in the table are: ");
        System.out.println("Table: " + resultSet.getMetaData().getTableName(1));
        for  (int i = 1; i<= resultSet.getMetaData().getColumnCount(); i++){
            System.out.println("Column " +i  + " "+ resultSet.getMetaData().getColumnName(i));
        }
    }
    */

    /**
     * Pre: ---
     * Post: muestra por pantalla el contenido almacenado en [resultSet].
     */
    private void writeResultSet(ResultSet resultSet) throws SQLException {
        /*
         * Mientras resultSet contenga más usuarios, seguimos avanzando
         * de manera similar a los ficheros de texto.
         */
        while (resultSet.next()) {
            /*
             * Podemos seleccionar la columna de la que queremos leer el dato
             * poniendo su nombre, o también indicando su número de columna...
             * siempre empezando desde 1!
             * 				EJ: resultSet.getSTring(2);
             */
            int id = resultSet.getInt(1);
            String username = resultSet.getString(2);
            String password = resultSet.getString(3);
            System.out.println("\tID: " + id);
            System.out.println("\tUsername: " + username);
            System.out.println("\tPassword: " + password);
        }
    }

    /**
     * Pre: ---
     * Post: cerramos todas las conexiones abiertas, el resultSet
     * 		y el statement. Si no se cierran correctamente, puede
     * 		ocurrir que las consultas no devuelvan el resultado esperado.
     * 		Además, si dejamos muchas conexiones a la BD abiertas
     * 		podemos llegar a saturarla y no aceptará más conexiones.
     */



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
