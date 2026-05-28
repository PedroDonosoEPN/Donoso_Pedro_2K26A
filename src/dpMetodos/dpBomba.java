package dpMetodos;

import java.util.Scanner;

public class dpBomba {

    public final int ER = -1;
    public final int ESTADO_EXPLOTA_1 = 2; // q2 - "ab"
    public final int ESTADO_EXPLOTA_2 = 3; // q3 - "abc"

    // 0=a, 1=b, 2=c, 3=\n
    final int[][] dpMt = {
    //   a      b      c     \n
      {  1,    ER,    ER,    ER }, // q0
      { ER,     2,    ER,    ER }, // q1  a
      { ER,    ER,     3,     2 }, // q2  ab  -> acepta o sigue con c
      { ER,    ER,    ER,     3 }, // q3  abc -> acepta
    };

    private int dpGetIndex(char c) {
        switch (c) {
            case 'a':  return 0;
            case 'b':  return 1;
            case 'c':  return 2;
            case '\n': return 3;
            default:   return ER;
        }
    }

    // Evalúa letra por letra siguiendo tu diagrama de flujo
    private int dpEvaluarPalabra(String dpPalabra) {
        if (!dpPalabra.endsWith("\n")) dpPalabra += "\n";

        int dpEstado   = 0;
        int dpPosicion = 0;

        while (dpPosicion < dpPalabra.length()) {
            char dpLetra = dpPalabra.charAt(dpPosicion);
            int dpIdx    = dpGetIndex(dpLetra);

            if (dpIdx == ER || dpMt[dpEstado][dpIdx] == ER) {
                return ER;
            }

            dpEstado   = dpMt[dpEstado][dpIdx];
            dpPosicion = dpPosicion + 1;
        }
        return dpEstado;
    }

    public void dpEjecutar(String[][] dpCoordenadas, int dpTotalFilas) {
        Scanner dpScanner = new Scanner(System.in);

        System.out.print("\n[+] Ingrese su cadena de caracteres / palabra: ");
        String dpPalabra = dpScanner.nextLine().trim();

        int dpEstado = dpEvaluarPalabra(dpPalabra);

        System.out.println("\n...");

        if (dpEstado == ESTADO_EXPLOTA_1 || dpEstado == ESTADO_EXPLOTA_2) {
            System.out.println("[+] BOMB-93 : COORDENADAS UCRANIANAS A DESTRUIR:");
            System.out.printf("    %-15s | %-15s%n", "Geoposición", "Tipo Arsenal");

            boolean dpYaMostro09 = false;
            boolean dpYaMostro03 = false;

            // ÚNICO BUCLE FOR PARA IMPRIMIR LAS COORDENADAS SIN DUPLICAR
            for (int dpI = 0; dpI < dpTotalFilas; dpI++) {
                String dpGeo     = dpCoordenadas[dpI][0];
                String dpArsenal = dpCoordenadas[dpI][1];

                if (!dpGeo.equals("Coord-09") && !dpGeo.equals("Coord-03")) continue;
                if (dpGeo.equals("Coord-09") && dpYaMostro09) continue;
                if (dpGeo.equals("Coord-03") && dpYaMostro03) continue;

                int dpEstadoFila = dpEvaluarPalabra(dpArsenal);
                if (dpEstadoFila == ESTADO_EXPLOTA_1 || dpEstadoFila == ESTADO_EXPLOTA_2) {
                    System.out.printf("    %-15s | %-15s%n", dpGeo, dpArsenal);
                    
                    if (dpGeo.equals("Coord-09")) dpYaMostro09 = true;
                    if (dpGeo.equals("Coord-03")) dpYaMostro03 = true;
                }
            }
            
            // ¡ELIMINADO EL SEGUNDO BUCLE QUE CAUSABA LOS DUPLICADOS!

        } else {
            System.out.println("    [!] Error - cadena no reconocida");
        }
    }
}