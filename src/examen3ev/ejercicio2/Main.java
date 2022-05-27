package examen3ev.ejercicio2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        leerFichero("src/examen3ev/ejercicio2/Divorcios.csv");
    }

    public static void leerFichero(String nombre){
        File file = new File(nombre);
        ArrayList<Tupla> lista = new ArrayList<Tupla>();
        try {
            Scanner f = new Scanner(file);
            /*
             * Recorremos el fichero linea por linea.
             */

            f.nextLine();

            while(f.hasNextLine()) {
                String linea = f.nextLine();

                String[] palabras = linea.split(";");

                boolean separacion = false;
                if (palabras[1].equalsIgnoreCase("Si")){
                    separacion = true;
                }

                String[] nombrePos1 = palabras[0].split(" ");
                String nombreLocalidad = "";

                if (nombrePos1.length > 2){
                    for (int i = 1; i < nombrePos1.length; i++){
                        nombreLocalidad+=nombrePos1[i]+" ";
                    }
                }else {
                    nombreLocalidad = nombrePos1[1];
                }

                int numeroTotal = 0;
                try {
                    numeroTotal = Integer.parseInt(palabras[3].replaceAll("\\.", ""));
                }catch (Exception e){}

                lista.add(new Tupla(nombreLocalidad, separacion, palabras[2], numeroTotal));
            }
            /*
             * Se libera el fichero que estamos leyendo.
             */
            f.close();
        } catch (FileNotFoundException e) {
            System.out.println("El fichero " + nombre + " no ha podido ser abierto.");
        }

        obtenerTotalDivorciosPorAnoYelTipo(lista, "2019", true);
        obtenerTotalDivorciosPorAnoYelTipo(lista, "2018", false);
        obtenerLocalidadConMayoresDivorcios(lista, 2013, 2019);
    }

    public static void obtenerTotalDivorciosPorAnoYelTipo(ArrayList<Tupla> lista, String ano, boolean tipo){
        int total = 0;
        for (Tupla dato: lista){
            if (dato.getAno().equals(ano) && dato.isSeparacionPrevia() == tipo){
                total+=dato.getTotal();
            }
        }

        String respuesta = "El número total de divorcios ";
        if (tipo)
            respuesta+="CON";
        else {
            respuesta+="SIN";
        }
        respuesta+=" separación previa en el año "+ano+" son "+total+".";

        System.out.println(respuesta);
    }

    public static void obtenerLocalidadConMayoresDivorcios(ArrayList<Tupla> lista, int anoInicio, int anoFinal){
        ArrayList<Tupla> orden = new ArrayList<Tupla>();

        for (Tupla dato : lista){
            if (Integer.parseInt(dato.getAno()) >=  anoInicio &&
                    Integer.parseInt(dato.getAno()) <=  anoFinal){
                boolean noEncontrado = true;

                for (Tupla ordenado : orden){
                    if (ordenado.getNombre().equals(dato.getNombre())){
                        noEncontrado = false;

                        ordenado.setTotal(ordenado.getTotal()+dato.getTotal());
                        break;
                    }
                }

                if (noEncontrado){
                    orden.add(dato);
                }
            }
        }

        int i = 1;
        Tupla mayor = null;
        for (Tupla organizacion : orden){
            if (mayor == null || mayor.getTotal() < organizacion.getTotal()){
                mayor = organizacion;
            }
        }

        System.out.println("La localidad con mayores divorcios entre "+anoInicio+" y "+anoFinal+
                            " es en "+mayor.getNombre()+", con un total de "+mayor.getTotal());
    }
}
