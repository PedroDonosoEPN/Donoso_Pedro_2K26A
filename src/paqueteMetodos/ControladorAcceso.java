package paqueteMetodos;

import java.util.Scanner;

public class ControladorAcceso {

    private validadorUsuarios pdValUser;
    private validadorContrasena pdValPass;
    private Scanner pdScanner;
    private String pdRol;
    private String pdNombre;
    private String pdCedula;

    public ControladorAcceso() {
        pdValUser  = new validadorUsuarios();
        pdValPass  = new validadorContrasena();
        pdScanner  = new Scanner(System.in);
        pdRol      = null;
        pdNombre   = null;
        pdCedula   = null;
    }

    public boolean pdAutenticar() {
        int pdIntentos = 3;

        while (pdIntentos > 0) {
            System.out.print("\n[+] Usuario: ");
            String pdInputUser = pdScanner.nextLine().trim();

            System.out.print("[+] Contraseña: ");
            String pdInputPass = pdScanner.nextLine().trim();

            int pdEstadoUser = pdValUser.pdValidar(pdInputUser);
            int pdEstadoPass = pdValPass.pdValidar(pdInputPass);

            boolean pdPassOk = (pdEstadoPass == pdValPass.ESTADO_ACCEPT);

            if (pdEstadoUser == pdValUser.ESTADO_ALUMNO && pdPassOk) {
                pdRol    = "alumno";
                pdNombre = "Pedro Donoso";
                pdCedula = "0850195793"; // 
                pdMostrarAcceso();
                return true;

            } else if (pdEstadoUser == pdValUser.ESTADO_PROFESOR && pdPassOk) {
                pdRol    = "profesor";
                pdNombre = "Patricio Paccha";
                pdCedula = "pat_mic";
                pdMostrarAcceso();
                return true;

            } else {
                pdIntentos--;
                System.out.println("[!] Donoso eres un intruso...");
                if (pdIntentos > 0) {
                    System.out.println("[!] Intentos restantes: " + pdIntentos);
                }
            }
        }

        System.out.println("\n[!] Accesos agotados. Cerrando sistema...");
        System.exit(0);
        return false;
    }

    private void pdMostrarAcceso() {
        System.out.println("\n[+] ACCESO:");
        System.out.println("    " + pdCedula + " - " + pdNombre);
    }

    public String pdGetRol()    { return pdRol; }
    public String pdGetNombre() { return pdNombre; }
    public String pdGetCedula() { return pdCedula; }
}