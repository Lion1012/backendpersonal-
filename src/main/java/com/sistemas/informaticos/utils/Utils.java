package com.sistemas.informaticos.utils;

public class Utils {
    public static String cuentapalabra(String palabra) {
        int cuentavocal = 0, cuentaconsonante = 0;
        palabra = palabra.toLowerCase();
        for (int i = 0; i < palabra.length(); i++) {
            char letra = palabra.charAt(i);
            if (letra == 'a' || letra == 'e' || letra == 'i' || letra == 'o' || letra == 'u') {
                cuentavocal++;
            } else if ((letra >= 'a' && letra <= 'z')) {
                cuentaconsonante++;
            }
        }
        return "numero de vocales " + cuentavocal + " numero de consonantes " + cuentaconsonante;
    }
public static String transformame(String palabrita){
    return palabrita.toUpperCase();
}
    
}
