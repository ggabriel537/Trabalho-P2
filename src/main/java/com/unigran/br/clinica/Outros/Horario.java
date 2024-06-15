package com.unigran.br.clinica.Outros;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Horario {
    public static String getHora() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy-HH.mm.ss");
        String formattedDateTime = now.format(formatter);
        return formattedDateTime;
    }
}
