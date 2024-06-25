package com.proyectojava.utility;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Optional;
import java.util.Scanner;
import java.util.function.Supplier;

public class Validations {
    private static Scanner scanner;
    

    public Validations() {
        this.scanner = new Scanner(System.in);
    }

    public int validarInt(String mensaje) {
        int dato;
        while (true) {
            System.out.println(mensaje);
            try {
                dato = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.print("Debe ingresar un dato valido, ");
            }
        }
        return dato;
    }

    public String campObligatorio(String message) {
        System.out.print(message);
        String value;
        while (true) {
            value = scanner.nextLine();
            if (value.isBlank()) {
                System.out.print("Este es un campo obligatorio, " + message.toLowerCase());
            } else {
                break;
            }
        }
        return value;
    }

    public String caracteres(String message, int lenght) {
        String value;
        while (true) {
            value = this.campObligatorio(message);
            if (value.length() > lenght) {
                System.out.print("Error, ");
            } else {
                break;
            }
        }
        return value;
    }

    public String stringNull(String message) {
        System.out.print(message);
        return scanner.nextLine();
    }

    public static <T> T transformAndValidateObj(Supplier<Optional<T>> supplier) {
        T objetoSeleccionado = null;
        while (true) {
            Optional<T> objetoOpcional = supplier.get();
            if (objetoOpcional.isPresent()) {
                return objetoSeleccionado = objetoOpcional.get();
            } else {
                System.out.println("El id no existe");
            }
        }
    }

    public static <T> String validateExist(String message, Validator<T> validator) {
        Validations validations = new Validations();
        while (true) {
            String input = validations.caracteres(message, 5);
            Optional<T> validationResult = (Optional<T>) validator.validate(input.toUpperCase());
            if (validationResult.isPresent()) {
                System.out.println("El id ingresado ya existe");
            } else {
                System.out.println("Id valido");
                return input;
            }
        }
    }


    public Date validarFecha(String mensaje) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        Date fecha = null;

        while (fecha == null) {
            System.out.print(mensaje);
            String input = scanner.nextLine();
            try {
                java.util.Date utilDate = dateFormat.parse(input);
                fecha = new Date(utilDate.getTime());
            } catch (ParseException e) {
                System.out.println("Fecha inválida. Formato correcto: YYYY-MM-DD.");
            }
        }
        return fecha;
    }

    public double validarDouble(String mensaje) {
        double dato;
        while (true) {
            System.out.println(mensaje);
            try {
                dato = Double.parseDouble(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.print("Debe ingresar un dato válido, ");
            }
        }
        return dato;
    }
}
