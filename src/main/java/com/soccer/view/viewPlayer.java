package com.soccer.view;

import java.util.Enumeration;
import java.util.Scanner;

import com.soccer.Controller;
import com.soccer.model.entity.Player;

public class viewPlayer {
    public static Controller controlador;

    public void start() {
        Scanner scanner = new Scanner(System.in);
        int verificar = 1;
        while (verificar == 1) {
            System.out.println("1. Crear Jugador");
            System.out.println("2. Actualizar Jugador");
            System.out.println("3. Buscar Jugador");
            System.out.println("4. Eliminar Jugador");
            System.out.println("5. Listar todos Jugador");
            System.out.println("6. Salir");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    Player jugador = new Player();
                    String codigoJugador = null;
                    System.out.println("Ingrese el codigo del jugador :");
                    codigoJugador = scanner.nextLine();  // Asignar el código del jugador directamente
                    jugador.setId(codigoJugador);  // Establecer el ID del jugador
                    System.out.println("Ingrese nombre del jugador :");
                    jugador.setNombre(scanner.nextLine());
                    System.out.println("Ingrese apellido del jugador :");
                    jugador.setApellido(scanner.nextLine());
                    System.out.println("Ingrese años del jugador :");
                    jugador.setEdad(scanner.nextInt());
                    System.out.println("Ingrese Dorsal del jugador :");
                    jugador.setDorsal(scanner.nextInt());
                    scanner.nextLine(); // Consume newline
                    System.out.println("Ingrese posicion del jugador :");
                    jugador.setPosicion(scanner.nextLine());
                    controlador.jugadores.put(codigoJugador, jugador);
                    System.out.println("Jugador creado exitosamente.");
                    break;

                case 2:
                    // Actualizar Jugador
                    System.out.println("Ingrese el codigo del jugador a actualizar :");
                    String codigoJugadorA = scanner.nextLine();
                    Player jugadorA = controlador.jugadores.get(codigoJugadorA);
                    if (jugadorA != null) {
                        System.out.println("Ingrese nombre del jugador :");
                        jugadorA.setNombre(scanner.nextLine());
                        System.out.println("Ingrese apellido del jugador :");
                        jugadorA.setApellido(scanner.nextLine());
                        System.out.println("Ingrese años del jugador :");
                        jugadorA.setEdad(scanner.nextInt());
                        System.out.println("Ingrese Dorsal del jugador :");
                        jugadorA.setDorsal(scanner.nextInt());
                        scanner.nextLine(); // Consume newline
                        System.out.println("Ingrese posicion del jugador :");
                        jugadorA.setPosicion(scanner.nextLine());
                        controlador.jugadores.put(codigoJugadorA, jugadorA);
                        System.out.println("Jugador actualizado exitosamente.");
                    } else {
                        System.out.println("Jugador no encontrado.");
                    }
                    break;

                case 3:
                    System.out.println("Ingrese codigo del jugador a buscar :");
                    String codigoP = scanner.nextLine();
                    Player jd = controlador.jugadores.get(codigoP);
                    if (jd != null) {
                        System.out.println("El jugador se llama " + jd.getNombre());
                    } else {
                        System.out.println("Jugador no encontrado.");
                    }
                    break;

                case 4:
                    System.out.println("Ingrese codigo del jugador a eliminar :");
                    String codigoEl = scanner.nextLine();
                    Player je = controlador.jugadores.remove(codigoEl);
                    if (je != null) {
                        System.out.println("El jugador eliminado fue " + je.getNombre());
                    } else {
                        System.out.println("Jugador no encontrado.");
                    }
                    break;

                case 5:
                    // Listar todos los jugadores
                    Enumeration<String> playerKeys = viewPlayer.controlador.jugadores.keys();
                    while (playerKeys.hasMoreElements()) {
                        String playerKey = playerKeys.nextElement();
                        Player player = viewPlayer.controlador.jugadores.get(playerKey);
                        System.out.println("Key: " + playerKey + " Nombre del jugador: " +
                                player.getNombre());
                    }

        
                case 6:
                    verificar = 0;
                    break;

                default:
                    System.out.println("Opción inválida, inténtelo de nuevo.");
            }
        }
    }
}