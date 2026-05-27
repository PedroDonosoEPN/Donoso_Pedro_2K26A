package paqueteMetodos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LectorCSV {

    private String pdRutaArchivo;

    public LectorCSV(String pdRuta) {
        this.pdRutaArchivo = pdRuta;
    }

    public void pdLeerArchivo() {
        System.out.println("\n[+] COORDENADAS UCRANIANAS:");
        System.out.printf("%-10s | %-12s | %-8s | %-8s | %-10s | %-8s | %-8s | %-15s%n",
                "Loading", "Geoposicion", "Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Tipo Arsenal");

        try (BufferedReader pdBr = new BufferedReader(new FileReader(pdRutaArchivo))) {
            String pdLinea;
            boolean pdPrimeraLinea = true;

            while ((pdLinea = pdBr.readLine()) != null) {
                if (pdPrimeraLinea) {
                    pdPrimeraLinea = false;
                    continue;
                }

                String[] pdDatos = pdLinea.split(";", -1);

                pdMostrarLoading();

                System.out.printf("%-10s | %-12s | %-8s | %-8s | %-10s | %-8s | %-8s | %-15s%n",
                        "100%",
                        pdDatos.length > 0 ? pdDatos[0].trim() : "",
                        pdDatos.length > 1 ? pdDatos[1].trim() : "",
                        pdDatos.length > 2 ? pdDatos[2].trim() : "",
                        pdDatos.length > 3 ? pdDatos[3].trim() : "",
                        pdDatos.length > 4 ? pdDatos[4].trim() : "",
                        pdDatos.length > 5 ? pdDatos[5].trim() : "",
                        pdDatos.length > 6 ? pdDatos[6].trim() : "");

            }

        } catch (IOException pdE) {
            System.out.println("[!] Error al leer el archivo: " + pdE.getMessage());
        }
    }

    private void pdMostrarLoading() {
        // ultimo digito cedula 0850195793 es 3 -> impar -> \l/-l
        String[] pdFrames = { "\\", "l", "/", "-", "l" };

        for (int pdI = 0; pdI <= 100; pdI += 10) {
            System.out.print("\r" + pdFrames[(pdI / 10) % pdFrames.length] + " " + pdI + "%   ");
            System.out.flush();
            try {
                Thread.sleep(80);
            } catch (InterruptedException pdEx) {
                Thread.currentThread().interrupt();
            }
        }
        // limpia la linea del loading
        System.out.print("\r            \r");
        System.out.flush();
    }
}