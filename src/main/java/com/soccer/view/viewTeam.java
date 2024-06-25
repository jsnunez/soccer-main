package com.soccer.view;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Scanner;

import com.soccer.Controller;
import com.soccer.model.entity.Coach;
import com.soccer.model.entity.Doctor;
import com.soccer.model.entity.Player;
import com.soccer.model.entity.Team;

public class viewTeam {
    public static Controller controlador;

    public void start() {

        Scanner scanner = new Scanner(System.in);
        int verificar = 1;
        while (verificar == 1) {
            System.out.println("1. Crear Equipo");
            System.out.println("2. Actualizar Integrantes del equipo");
            System.out.println("3. Buscar Equipo");
            System.out.println("4. Eliminar Equipo");
            System.out.println("5. Listar todos Equipos");
            System.out.println("6. Listar todos integrantes del equipo");
            System.out.println("7. Salir");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    Team equipo = new Team();

                    String codigoEquipo = null;
                    String codigoJugador = null;

                    String codigoCoach = null;
                    String codigoDoctor = null;
                    System.out.println("Ingrese el codigo del equipo :");
                    codigoEquipo = scanner.nextLine();

                    // Verificar si el código del equipo ya existe
                    if (controlador.equipos.containsKey(codigoEquipo)) {
                        System.out.println("El código del equipo ya existe. Por favor, intente con otro código.");
                    } else {
                        System.out.println("Ingrese Nombre del equipo :");
                        equipo.setNombre(scanner.nextLine());
                        System.out.println("Ingrese la ciudad :");
                        equipo.setCiudad(scanner.nextLine());
                        controlador.equipos.put(codigoEquipo, equipo);
                        System.out.println("Equipo creado exitosamente.");
                    }
                    break;

                case 2:

                    Enumeration<String> teamKeyse = controlador.equipos.keys();
                    while (teamKeyse.hasMoreElements()) {
                        String teamKeye = teamKeyse.nextElement();
                        System.out.println("Key: " + teamKeye + " Nombre del equipo: " +
                                controlador.equipos.get(teamKeye).getNombre());
                    }
                    System.out.println("Ingrese el codigo del equipo :");
                    codigoEquipo = scanner.nextLine();
                    Team equipoEditar = controlador.equipos.get(codigoEquipo);
                    if (equipoEditar != null) {
                        System.out.println("1. Agregar jugador al equipo :");
                        System.out.println("2. Agregar entrenador al equipo :");
                        System.out.println("3. Agregar doctor al equipo :");
                        int selEquipo = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                        switch (selEquipo) {
                            case 1:
                                Enumeration<String> playerKeys = viewPlayer.controlador.jugadores.keys();
                                while (playerKeys.hasMoreElements()) {
                                    String playerKey = playerKeys.nextElement();
                                    Player player = viewPlayer.controlador.jugadores.get(playerKey);
                                    System.out.println("Key: " + playerKey + " Nombre del jugador: " +
                                            player.getNombre());
                                }
                                System.out.println("Ingrese el codigo del jugador :");
                                codigoJugador = scanner.nextLine();

                                Player jugadorAgregar = viewPlayer.controlador.jugadores.get(codigoJugador);
                                if (jugadorAgregar != null) {

                                    equipoEditar.setLstJugadores(viewPlayer.controlador.jugadores.get(codigoJugador));

                                    equipo = controlador.equipos.get(codigoEquipo);
                                    System.out.println(equipo.getNombre());
                                    for (Player n : equipo.getLstJugadores()) {
                                        System.out.println("+---------------------+");
                                        System.out.println("Nombre: " + n.getNombre());
                                        System.out.println("Edad: " + n.getEdad());
                                        System.out.println("+---------------------+");
                                    }

                                    System.out.println("El Jugador fue agregado correctamente");

                                } else {
                                    System.out.println("El Jugador seleccionado no existe");
                                }
                                break;

                            case 2:
                                Enumeration<String> coachKeys = viewCoach.controlador.entrenadores.keys();
                                while (coachKeys.hasMoreElements()) {
                                    String coachKey = coachKeys.nextElement();
                                    Coach coach = viewCoach.controlador.entrenadores.get(coachKey);
                                    System.out.println("Key: " + coachKey + " Nombre del jugador: " +
                                            coach.getNombre());
                                }

                                System.out.println("Ingrese el codigo del Entrenador :");
                                codigoCoach = scanner.nextLine();

                                Coach coachAgregar = viewCoach.controlador.entrenadores.get(codigoCoach);
                                if (coachAgregar != null) {

                                    equipoEditar.setLstEntrenadores(viewCoach.controlador.entrenadores.get("001"));

                                    equipo = controlador.equipos.get("001");
                                    System.out.println(equipo.getNombre());
                                    for (Coach n : equipo.getLstEntrenadores()) {
                                        System.out.println("+---------------------+");
                                        System.out.println("Nombre: " + n.getNombre());
                                        System.out.println("Edad: " + n.getEdad());
                                        System.out.println("+---------------------+");
                                    }

                                    System.out.println("El Entrenador fue agregado correctamente");
                                } else {
                                    System.out.println("El Entrenador seleccionado no existe");
                                }
                                break;

                            case 3:

                                Enumeration<String> docKeys = viewDoctor.controlador.doctores.keys();
                                while (docKeys.hasMoreElements()) {
                                    String docKey = docKeys.nextElement();
                                    Doctor doc = viewDoctor.controlador.doctores.get(docKey);
                                    System.out.println("Key: " + docKey + " Nombre del jugador: " +
                                            doc.getNombre());
                                }
                                System.out.println("Ingrese el codigo del Doctor :");
                                codigoDoctor = scanner.nextLine();

                                Coach docAgregar = viewCoach.controlador.entrenadores.get(codigoDoctor);
                                if (docAgregar != null) {

                                    equipoEditar.setLstMasajistas(viewDoctor.controlador.doctores.get("001"));

                                    equipo = controlador.equipos.get("001");
                                    System.out.println(equipo.getNombre());
                                    for (Doctor n : equipo.getLstMasajistas()) {
                                        System.out.println("+---------------------+");
                                        System.out.println("Nombre: " + n.getNombre());
                                        System.out.println("Edad: " + n.getEdad());
                                        System.out.println("+---------------------+");
                                    }

                                    System.out.println("El Entrenador fue agregado correctamente");
                                } else {
                                    System.out.println("El Entrenador seleccionado no existe");
                                }
                                break;
                            case 4:
                                break;

                        }

                        System.out.println("Equipo actualizado exitosamente.");
                    } else {
                        System.out.println("Equipo no encontrado.");
                    }
                    break;

                case 3:
                    System.out.println("Ingrese codigo del equipo :");
                    codigoEquipo = scanner.nextLine();
                    Team eq = controlador.equipos.get(codigoEquipo);
                    if (eq != null) {
                        System.out.println("Nombre del equipo: " + eq.getNombre());
                    } else {
                        System.out.println("Equipo no encontrado.");
                    }
                    break;

                case 4:
                    System.out.println("Ingrese codigo del equipo :");
                    codigoEquipo = scanner.nextLine();
                    Team eqr = controlador.equipos.remove(codigoEquipo);
                    if (eqr != null) {
                        System.out.println("El equipo eliminado fue: " + eqr.getNombre());
                    } else {
                        System.out.println("Equipo no encontrado.");
                    }
                    break;

                case 5:
                    Enumeration<String> teamKeys = controlador.equipos.keys();

                    while (teamKeys.hasMoreElements()) {
                        String teamKey = teamKeys.nextElement();
                        System.out.println("Key: " + teamKey + " Nombre del equipo: " +
                                controlador.equipos.get(teamKey).getNombre());
                    }

                    break;

                case 6:
Team equipoJugadores = new Team();

System.out.println("Ingrese codigo del equipo :");
codigoEquipo = scanner.nextLine();
equipoJugadores = controlador.equipos.get(codigoEquipo);

System.out.println("Jugadores del equipo");
                for (Player n : equipoJugadores.getLstJugadores()) {
                    System.out.println("+---------------------+");
                    System.out.println("Nombre: " + n.getNombre());
                    System.out.println("Edad: " + n.getEdad());
                    System.out.println("+---------------------+");
                }
                System.out.println("Entrenadores del equipo");
                for (Coach n : equipoJugadores.getLstEntrenadores()) {
                    System.out.println("+---------------------+");
                    System.out.println("Nombre: " + n.getNombre());
                    System.out.println("Edad: " + n.getEdad());
                    System.out.println("+---------------------+");
                }

                System.out.println("Masajistas del equipo");
                for (Doctor n : equipoJugadores.getLstMasajistas()) {
                    System.out.println("+---------------------+");
                    System.out.println("Nombre: " + n.getNombre());
                    System.out.println("Edad: " + n.getEdad());
                    System.out.println("+---------------------+");
                }
                    // Enumeration<String> playerKeys = viewPlayer.controlador.jugadores.keys();
                    // while (playerKeys.hasMoreElements()) {
                    // String playerKey = playerKeys.nextElement();
                    // Player player = viewPlayer.controlador.jugadores.get(playerKey);
                    // System.out.println("Key: " + playerKey + " Nombre del jugador: " +
                    // player.getNombre());
                    // }
                    break;

                case 7:
                    verificar = 0;
                    break;

                default:
                    System.out.println("Opción inválida, inténtelo de nuevo.");
            }
        }
    }
}
