package com.soccer.view;

import java.util.Enumeration;
import java.util.Scanner;

import com.soccer.Controller;
import com.soccer.model.entity.Coach;

public class viewCoach {
    public static Controller controlador;

    public void start() {
        Scanner scanner = new Scanner(System.in);
        int verificar = 1;
        while (verificar == 1) {
            System.out.println("1. Crear Coach");
            System.out.println("2. Actualizar Coach");
            System.out.println("3. Buscar Coach");
            System.out.println("4. Eliminar Coach");
            System.out.println("5. Listar todos los Coach");
            System.out.println("6. Salir");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    Coach jugador = new Coach();
                    String codigoCoach = null;
                    System.out.println("Ingrese el codigo del jugador :");
                    codigoCoach = jugador.setId(scanner.nextLine());
                    System.out.println("Ingrese nombre del jugador :");
                    jugador.setNombre(scanner.nextLine());
                    System.out.println("Ingrese apellido del jugador :");
                    jugador.setApellido(scanner.nextLine());
                    System.out.println("Ingrese años del jugador :");
                    jugador.setEdad(scanner.nextInt());
                    System.out.println("Ingrese años de experiencia del jugador :");
                    jugador.setIdFederacion(scanner.nextInt());
                    scanner.nextLine();
                    controlador.entrenadores.put(codigoCoach, jugador);
                    break;

                case 2:

                    break;

                case 3:
                    Coach doc = new Coach();
                    System.out.println("nombre del jugador" + doc.getNombre());
                    System.out.println("Ingrese codigo del jugador a buscar :");
                    String codigoP = scanner.nextLine();
                    doc = controlador.entrenadores.get(codigoP);
                    System.out.println("EL jugador se llama " + doc.getNombre());
                    break;
                case 4:
                    Coach docE = new Coach();

                    System.out.println("Ingrese codigo del jugadro a eliminar :");
                    String codigoEl = scanner.nextLine();
                    docE = controlador.entrenadores.remove(codigoEl);
                    System.out.println("El jugador elimnado fue " + docE.getNombre());
                    break;

                case 5:
                    Enumeration names1;
                    String key1;
                    names1 = controlador.jugadores.keys();
                    while (names1.hasMoreElements()) {
                        key1 = (String) names1.nextElement();
                        System.out.println("Key: " + key1 + " Nombre del jugador: " +
                                controlador.jugadores.get(key1).getNombre());
                    }
                    break;

                case 6:
                    verificar = 0;
                    break;

                default:
                    System.out.println("Opcion invalida, intentelo de nuevo.");
            }
        }
    }
}
