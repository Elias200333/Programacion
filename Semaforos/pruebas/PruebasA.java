package pruebas;

import java.util.Scanner;

public class PruebasA {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.println("----------------------------------");
        System.out.println("| BIENVENIDO AL JUEGO DE LA VIDA |");
        System.out.println("----------------------------------");

        System.out.println("1. Metodo Test: ");
        System.out.println("2. Metodo automatico: ");
        int metodo = entrada.nextInt();
        if (metodo == 2) {
            automatico();
        } else if (metodo == 1) {
            test();
        } else {
            System.out.println("ese numero no vale reintentelo");
        }
    }

    public static void automatico() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("introduzca numero de columnas: ");
        int columnas = entrada.nextInt();
        System.out.println("introduzca numero de filas: ");
        int filas = entrada.nextInt();
        String[][] tabla = new String[columnas][filas];
        System.out.println("Generaciones: ");
        int generaciones = entrada.nextInt();
        String[][] tablacopia = new String[columnas][filas];

        if (columnas > 0 && columnas <= 30 && filas > 0 && filas <= 30 && generaciones > 0 && generaciones <= 30) {
            for (int g = 0; g <= generaciones; g++) {
                int contadorActual = 0;
                int contadorvida = 0;
                System.out.println(" ");
                System.out.println("generacion: " + g);
                System.out.println(" ");

                for (int i = 0; i < tabla.length; i++) {
                    for (int x = 0; x < tabla[i].length; x++) {
                        if (g == 0) {
                            int probable = (int) (Math.random() * 101);
                            if (probable <= 20) {
                                tabla[i][x] = " * ";
                                contadorActual++;
                            } else {
                                tabla[i][x] = " . ";
                            }
                            tablacopia = tabla;
                        } else if (tabla[i][x].contains(" * ")) {
                            contadorActual++;
                        } else {

                            //esquina superior izquierda
                            if (i == 0 && x == 0) {
                                int contador = 0;
                                if (tabla[i][x + 1].contains(" * ")) {
                                    contador++;
                                }
                                if (tabla[i + 1][x].contains(" * ")) {
                                    contador++;
                                }
                                if (tabla[i + 1][x + 1].contains(" * ")) {
                                    contador++;
                                }
                                if (contador < 2 || contador > 3 && tabla[i][x].contains(" * ")) {
                                    tablacopia[i][x] = " . ";
                                } else if (contador == 2 || contador == 3 && tabla[i][x].contains(" * ")) {
                                    tablacopia[i][x] = " . ";
                                } else if (contador == 3 && tabla[i][x].contains(" . ")) {
                                    tablacopia[i][x] = " * ";
                                }
                            }

                            //esquina inferior izquierda
                            if (i == tabla.length - 1 && x == 0) {
                                int contador = 0;
                                if (tabla[i][x + 1].contains("*")) {
                                    contador++;
                                }
                                if (tabla[i - 1][x].contains("*")) {
                                    contador++;
                                }
                                if (tabla[i - 1][x + 1].contains("*")) {
                                    contador++;
                                }
                                if (contador < 2 || contador > 3 && tabla[i][x].contains(" * ")) {
                                    tablacopia[i][x] = " . ";
                                } else if (contador == 2 || contador == 3 && tabla[i][x].contains(" * ")) {
                                    tablacopia[i][x] = " . ";
                                } else if (contador == 3 && tabla[i][x].contains(" . ")) {
                                    tablacopia[i][x] = " * ";
                                }
                            }

                            //esquina superior derecha
                            if (i == 0 && x == tabla.length - 1) {
                                int contador = 0;
                                if (tabla[i][x - 1].contains("*")) {
                                    contador++;
                                }
                                if (tabla[i + 1][x].contains("*")) {
                                    contador++;
                                }
                                if (tabla[i + 1][x - 1].contains("*")) {
                                    contador++;
                                }
                                if (contador < 2 || contador > 3 && tabla[i][x].contains(" * ")) {
                                    tablacopia[i][x] = " . ";
                                } else if (contador == 2 || contador == 3 && tabla[i][x].contains(" * ")) {
                                    tablacopia[i][x] = " . ";
                                } else if (contador == 3 && tabla[i][x].contains(" . ")) {
                                    tablacopia[i][x] = " * ";
                                }
                            }

                            //esquina inferior derecha
                            if (i == tabla.length - 1 && x == tabla.length - 1) {
                                int contador = 0;
                                if (tabla[i][x - 1].contains("*")) {
                                    contador++;
                                }
                                if (tabla[i - 1][x].contains("*")) {
                                    contador++;
                                }
                                if (tabla[i - 1][x - 1].contains("*")) {
                                    contador++;
                                }
                                if (contador < 2 || contador > 3 && tabla[i][x].contains(" * ")) {
                                    tablacopia[i][x] = " . ";
                                } else if (contador == 2 || contador == 3 && tabla[i][x].contains(" * ")) {
                                    tablacopia[i][x] = " . ";
                                } else if (contador == 3 && tabla[i][x].contains(" . ")) {
                                    tablacopia[i][x] = " * ";
                                }
                            }

                            //lateral izquierdo
                            if (i != 0 && x == 0 && i < tabla.length - 1) {
                                int contador = 0;
                                if (tabla[i - 1][x].contains("*")) {
                                    contador++;
                                }
                                if (tabla[i - 1][x + 1].contains("*")) {
                                    contador++;
                                }
                                if (tabla[i][x + 1].contains("*")) {
                                    contador++;
                                }
                                if (tabla[i + 1][x + 1].contains("*")) {
                                    contador++;
                                }
                                if (tabla[i + 1][x].contains("*")) {
                                    contador++;
                                }
                                if (contador < 2 || contador > 3 && tabla[i][x].contains(" * ")) {
                                    tablacopia[i][x] = " . ";
                                } else if (contador == 2 || contador == 3 && tabla[i][x].contains(" * ")) {
                                    tablacopia[i][x] = " . ";
                                } else if (contador == 3 && tabla[i][x].contains(" . ")) {
                                    tablacopia[i][x] = " * ";
                                }
                            }

                            //lateral superior
                            if (i == 0 && x != 0 && x < tabla.length - 1) {
                                int contador = 0;
                                if (tabla[i][x - 1].contains("*")) {
                                    contador++;
                                }
                                if (tabla[i + 1][x - 1].contains("*")) {
                                    contador++;
                                }
                                if (tabla[i + 1][x].contains("*")) {
                                    contador++;
                                }
                                if (tabla[i + 1][x + 1].contains("*")) {
                                    contador++;
                                }
                                if (tabla[i][x + 1].contains("*")) {
                                    contador++;
                                }
                                if (contador < 2 || contador > 3 && tabla[i][x].contains(" * ")) {
                                    tablacopia[i][x] = " . ";
                                } else if (contador == 2 || contador == 3 && tabla[i][x].contains(" * ")) {
                                    tablacopia[i][x] = " . ";
                                } else if (contador == 3 && tabla[i][x].contains(" . ")) {
                                    tablacopia[i][x] = " * ";
                                }
                            }

                            //lateral derecho
                            if (i != 0 && i != tabla.length - 1 && x == tabla.length - 1) {
                                int contador = 0;
                                if (tabla[i - 1][x].contains("*")) {
                                    contador++;
                                }
                                if (tabla[i - 1][x - 1].contains("*")) {
                                    contador++;
                                }
                                if (tabla[i][x - 1].contains("*")) {
                                    contador++;
                                }
                                if (tabla[i + 1][x - 1].contains("*")) {
                                    contador++;
                                }
                                if (tabla[i + 1][x].contains("*")) {
                                    contador++;
                                }
                                if (contador < 2 || contador > 3 && tabla[i][x].contains(" * ")) {
                                    tablacopia[i][x] = " . ";
                                } else if (contador == 2 || contador == 3 && tabla[i][x].contains(" * ")) {
                                    tablacopia[i][x] = " . ";
                                } else if (contador == 3 && tabla[i][x].contains(" . ")) {
                                    tablacopia[i][x] = " * ";
                                }
                            }

                            //lateral inferior
                            if (i == tabla.length - 1 && x != 0 && x < tabla.length - 1) {
                                int contador = 0;
                                if (tabla[i][x - 1].contains("*")) {
                                    contador++;
                                }
                                if (tabla[i - 1][x - 1].contains("*")) {
                                    contador++;
                                }
                                if (tabla[i - 1][x].contains("*")) {
                                    contador++;
                                }
                                if (tabla[i - 1][x + 1].contains("*")) {
                                    contador++;
                                }
                                if (tabla[i][x + 1].contains("*")) {
                                    contador++;
                                }
                                if (contador < 2 || contador > 3 && tabla[i][x].contains(" * ")) {
                                    tablacopia[i][x] = " . ";
                                } else if (contador == 2 || contador == 3 && tabla[i][x].contains(" * ")) {
                                    tablacopia[i][x] = " . ";
                                } else if (contador == 3 && tabla[i][x].contains(" . ")) {
                                    tablacopia[i][x] = " * ";
                                }
                            }

                            //centro
                            if (i != 0 && x != 0 && i != tabla.length - 1 && x != tabla.length - 1) {
                                int contador = 0;
                                if (tabla[i - 1][x - 1].contains("*")) {
                                    contador++;
                                }
                                if (tabla[i - 1][x].contains("*")) {
                                    contador++;
                                }
                                if (tabla[i - 1][x + 1].contains("*")) {
                                    contador++;
                                }
                                if (tabla[i][x + 1].contains("*")) {
                                    contador++;
                                }
                                if (tabla[i + 1][x + 1].contains("*")) {
                                    contador++;
                                }
                                if (tabla[i + 1][x].contains("*")) {
                                    contador++;
                                }
                                if (tabla[i + 1][x - 1].contains("*")) {
                                    contador++;
                                }
                                if (tabla[i][x - 1].contains("*")) {
                                    contador++;
                                }
                                if (contador < 2 || contador > 3 && tabla[i][x].contains(" * ")) {
                                    tablacopia[i][x] = " . ";
                                } else if (contador == 2 || contador == 3 && tabla[i][x].contains(" * ")) {
                                    tablacopia[i][x] = " . ";
                                } else if (contador == 3 && tabla[i][x].contains(" . ")) {
                                    tablacopia[i][x] = " * ";
                                }
                            }
                        }
                        System.out.print(tabla[i][x]);
                    }
                    System.out.println();
                }
                System.out.println("numeros: " + contadorActual);
            }
        }
    }


    /**
     * pre: ---
     * Post: modo test
     */
    public static void test() {
        Scanner entrada = new Scanner(System.in);
        String T1 = " * ";
        String T2 = " . ";
        String[][] tabla = {
                {T2, T2, T2, T2, T2},
                {T2, T2, T2, T2, T2},
                {T2, T1, T1, T1, T2},
                {T2, T2, T2, T2, T2},
                {T2, T2, T2, T2, T2},
        };
        String[][] tablacopia = new String[5][5];

        System.out.println("Generaciones: ");
        int generaciones = entrada.nextInt();

        for (int g = 0; g <= generaciones; g++) {
            int contadorvida = 0;
            System.out.println(" ");
            System.out.println("generacion: " + g);
            System.out.println(" ");
            for (int i = 0; i < tabla.length; i++) {
                for (int x = 0; x < tabla[i].length; x++) {
                    System.out.print(tabla[i][x]);
                }
                System.out.println();
            }
            
            System.out.println("________________________________");
            
            for (int i = 0; i < tabla.length; i++) {
                for (int x = 0; x < tabla[i].length; x++) {
                    System.out.print(tablacopia[i][x]);
                }
                System.out.println();
            }
            
            System.out.println("________________________________");

            for (int i = 0; i < tabla.length; i++) {
                for (int x = 0; x < tabla[i].length; x++) {
                    int contadorActual = 0;
                    System.out.print(tabla[i][x]);

                    //esquina superior izquierda
                    if (i == 0 && x == 0) {
                        int contador = 0;
                        if (tabla[i][x + 1].contains("*")) {
                            contador++;
                        }
                        if (tabla[i + 1][x].contains("*")) {
                            contador++;
                        }
                        if (tabla[i + 1][x + 1].contains("*")) {
                            contador++;
                        }
                        if (tabla[i][x].contains("*")) {
                            if (contador < 2 || contador > 3) {
                                tablacopia[i][x] = " . ";
                            } else {
                                tablacopia[i][x] = " * ";
                            }
                        } else if (contador == 3) {
                            tablacopia[i][x] = " * ";
                        }else {
                            tablacopia[i][x]=" . ";
                        }
                    }else if (i == tabla.length - 1 && x == 0) {
                        int contador = 0;
                        if (tabla[i][x + 1].contains("*")) {
                            contador++;
                        }
                        if (tabla[i - 1][x].contains("*")) {
                            contador++;
                        }
                        if (tabla[i - 1][x + 1].contains("*")) {
                            contador++;
                        }
                        if (tabla[i][x].contains("*")) {
                            if (contador < 2 || contador > 3) {
                                tablacopia[i][x] = " . ";
                            } else {
                                tablacopia[i][x] = " * ";
                            }
                        } else if (contador == 3) {
                            tablacopia[i][x] = " * ";
                        }else {
                            tablacopia[i][x]=" . ";
                        }
                    }else if (i == 0 && x == tabla.length - 1) {
                        int contador = 0;
                        if (tabla[i][x - 1].contains("*")) {
                            contador++;
                        }
                        if (tabla[i + 1][x].contains("*")) {
                            contador++;
                        }
                        if (tabla[i + 1][x - 1].contains("*")) {
                            contador++;
                        }
                        if (tabla[i][x].contains("*")) {
                            if (contador < 2 || contador > 3) {
                                tablacopia[i][x] = " . ";
                            } else {
                                tablacopia[i][x] = " * ";
                            }
                        } else if (contador == 3) {
                            tablacopia[i][x] = " * ";
                        }else {
                            tablacopia[i][x]=" . ";
                        }
                    }else if (i == tabla.length - 1 && x == tabla.length - 1) {
                        int contador = 0;
                        if (tabla[i][x - 1].contains("*")) {
                            contador++;
                        }
                        if (tabla[i - 1][x].contains("*")) {
                            contador++;
                        }
                        if (tabla[i - 1][x - 1].contains("*")) {
                            contador++;
                        }
                        if (tabla[i][x].contains("*")) {
                            if (contador < 2 || contador > 3) {
                                tablacopia[i][x] = " . ";
                            } else {
                                tablacopia[i][x] = " * ";
                            }
                        } else if (contador == 3) {
                            tablacopia[i][x] = " * ";
                        }else {
                            tablacopia[i][x]=" . ";
                        }
                    }else if (i != 0 && x == 0 && i < tabla.length - 1) {
                        int contador = 0;
                        if (tabla[i - 1][x].contains("*")) {
                            contador++;
                        }
                        if (tabla[i - 1][x + 1].contains("*")) {
                            contador++;
                        }
                        if (tabla[i][x + 1].contains("*")) {
                            contador++;
                        }
                        if (tabla[i + 1][x + 1].contains("*")) {
                            contador++;
                        }
                        if (tabla[i + 1][x].contains("*")) {
                            contador++;
                        }
                        if (tabla[i][x].contains("*")) {
                            if (contador < 2 || contador > 3) {
                                tablacopia[i][x] = " . ";
                            } else {
                                tablacopia[i][x] = " * ";
                            }
                        } else if (contador == 3) {
                            tablacopia[i][x] = " * ";
                        }else {
                            tablacopia[i][x]=" . ";
                        }
                    }else if (i == 0 && x != 0 && x < tabla.length - 1) {
                        int contador = 0;
                        if (tabla[i][x - 1].contains("*")) {
                            contador++;
                        }
                        if (tabla[i + 1][x - 1].contains("*")) {
                            contador++;
                        }
                        if (tabla[i + 1][x].contains("*")) {
                            contador++;
                        }
                        if (tabla[i + 1][x + 1].contains("*")) {
                            contador++;
                        }
                        if (tabla[i][x + 1].contains("*")) {
                            contador++;
                        }
                        if (tabla[i][x].contains("*")) {
                            if (contador < 2 || contador > 3) {
                                tablacopia[i][x] = " . ";
                            } else {
                                tablacopia[i][x] = " * ";
                            }
                        } else if (contador == 3) {
                            tablacopia[i][x] = " * ";
                        }else {
                            tablacopia[i][x]=" . ";
                        }
                    }else if (i != 0 && i != tabla.length - 1 && x == tabla.length - 1) {
                        int contador = 0;
                        if (tabla[i - 1][x].contains("*")) {
                            contador++;
                        }
                        if (tabla[i - 1][x - 1].contains("*")) {
                            contador++;
                        }
                        if (tabla[i][x - 1].contains("*")) {
                            contador++;
                        }
                        if (tabla[i + 1][x - 1].contains("*")) {
                            contador++;
                        }
                        if (tabla[i + 1][x].contains("*")) {
                            contador++;
                        }
                        if (tabla[i][x].contains("*")) {
                            if (contador < 2 || contador > 3) {
                                tablacopia[i][x] = " . ";
                            } else {
                                tablacopia[i][x] = " * ";
                            }
                        } else if (contador == 3) {
                            tablacopia[i][x] = " * ";
                        }else {
                            tablacopia[i][x]=" . ";
                        }
                    }else if (i == tabla.length - 1 && x != 0 && x < tabla.length - 1) {
                        int contador = 0;
                        if (tabla[i][x - 1].contains("*")) {
                            contador++;
                        }
                        if (tabla[i - 1][x - 1].contains("*")) {
                            contador++;
                        }
                        if (tabla[i - 1][x].contains("*")) {
                            contador++;
                        }
                        if (tabla[i - 1][x + 1].contains("*")) {
                            contador++;
                        }
                        if (tabla[i][x + 1].contains("*")) {
                            contador++;
                        }
                        if (tabla[i][x].contains("*")) {
                            if (contador < 2 || contador > 3) {
                                tablacopia[i][x] = " . ";
                            } else {
                                tablacopia[i][x] = " * ";
                            }
                        } else if (contador == 3) {
                            tablacopia[i][x] = " * ";
                        }else {
                            tablacopia[i][x]=" . ";
                        }
                    }else if (i != 0 && x != 0 && i != tabla.length - 1 && x != tabla.length - 1) {
                        int contador = 0;

                        if (tabla[i - 1][x - 1].contains("*")) {
                            contador++;
                            System.out.println("celula viva 1 en la posicion "+i+", "+x);
                        }

                        if (tabla[i + 1][x + 1].contains("*")) {
                            contador++;
                            System.out.println("celula viva 2 en la posicion "+i+", "+x);
                        }

                        if (tabla[i - 1][x + 1].contains("*")) {
                            contador++;
                            System.out.println("celula viva 3 en la posicion "+i+", "+x);
                        }

                        if (tabla[i + 1][x - 1].contains("*")) {
                            contador++;
                            System.out.println("celula viva 4 en la posicion "+i+", "+x);
                        }

                        if (tabla[i + 1][x].contains("*")) {
                            contador++;
                            System.out.println("celula viva 5 en la posicion "+i+", "+x);
                        }

                        if (tabla[i][x + 1].contains("*")) {
                            contador++;
                            System.out.println("celula viva 6 en la posicion "+i+", "+x);
                        }

                        if (tabla[i - 1][x].contains("*")) {
                            contador++;
                            System.out.println("celula viva 7 en la posicion "+i+", "+x);
                        }

                        if (tabla[i][x - 1].contains("*")) {
                            contador++;
                            System.out.println("celula viva 8 en la posicion "+i+", "+x);
                        }

                        if (tabla[i][x].equals(" * ")) {
                            if (contador < 2 || contador > 3) {
                                tablacopia[i][x] = " . ";
                            } else {
                                tablacopia[i][x] = " * ";
                            }
                        } else if (contador == 3) {
                            tablacopia[i][x] = " * ";
                        }else {
                            tablacopia[i][x]=" . ";
                        }
                    }
                }
                System.out.println();

            }
            
            for (int i = 0; i < tabla.length; i++) {
                for (int x = 0; x < tabla[i].length; x++) {
                    tabla[i][x] = tablacopia[i][x];
                }
                System.out.println();
            }
            
            System.out.println("________________________________");
            
            for (int i = 0; i < tablacopia.length; i++) {
                for (int x = 0; x < tabla[i].length; x++) {
                    System.out.print(tablacopia[i][x]);
                }
                System.out.println();
            }
            System.out.println("________________________________");
        }
    }
}
