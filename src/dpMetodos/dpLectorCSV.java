package dpMetodos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class dpLectorCSV {

    private String dpRutaArchivo;
    private String[][] dpCoordenadas;
    private int dpTotalFilas;

    public dpLectorCSV(String dpRuta) {
        this.dpRutaArchivo = dpRuta;
        this.dpCoordenadas = new String[100][2];
        this.dpTotalFilas  = 0;
    }

    public void dpLeerArchivo() {
        System.out.println("\n[+] COORDENADAS UCRANIANAS:");
        System.out.printf("%-10s | %-12s | %-8s | %-8s | %-10s | %-8s | %-8s | %-15s%n",
                "Loading", "Geoposicion", "Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Tipo Arsenal");

        try (BufferedReader dpBr = new BufferedReader(new FileReader(dpRutaArchivo))) {
            String dpLinea;
            boolean dpPrimeraLinea = true;

            while ((dpLinea = dpBr.readLine()) != null) {
                if (dpPrimeraLinea) {
                    dpPrimeraLinea = false;
                    continue;
                }

                String[] dpDatos = dpLinea.split(";", -1);
                dpMostrarLoading();

                System.out.printf("%-10s | %-12s | %-8s | %-8s | %-10s | %-8s | %-8s | %-15s%n",
                        "100%",
                        dpDatos.length > 0 ? dpDatos[0].trim() : "",
                        dpDatos.length > 1 ? dpDatos[1].trim() : "",
                        dpDatos.length > 2 ? dpDatos[2].trim() : "",
                        dpDatos.length > 3 ? dpDatos[3].trim() : "",
                        dpDatos.length > 4 ? dpDatos[4].trim() : "",
                        dpDatos.length > 5 ? dpDatos[5].trim() : "",
                        dpDatos.length > 6 ? dpDatos[6].trim() : "");

                // guarda geoposicion y tipo arsenal
                dpCoordenadas[dpTotalFilas][0] = dpDatos.length > 0 ? dpDatos[0].trim() : "";
                dpCoordenadas[dpTotalFilas][1] = dpDatos.length > 6 ? dpDatos[6].trim() : "";
                dpTotalFilas++;
            }

        } catch (IOException dpE) {
            System.out.println("[!] Error al leer el archivo: " + dpE.getMessage());
        }
    }

    private void dpMostrarLoading() {
        String[] dpFrames = { "\\", "l", "/", "-", "l" };
        for (int dpI = 0; dpI <= 100; dpI += 10) {
            System.out.print("\r" + dpFrames[(dpI / 10) % dpFrames.length] + " " + dpI + "%   ");
            System.out.flush();
            try {
                Thread.sleep(80);
            } catch (InterruptedException dpEx) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.print("\r            \r");
        System.out.flush();
    }

    public String[][] dpGetCoordenadas() { return dpCoordenadas; }
    public int dpGetTotalFilas()         { return dpTotalFilas; }
}