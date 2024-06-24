package com.soccer.view;

import java.util.Enumeration;
import java.util.Scanner;

import com.soccer.Controller;
import com.soccer.model.entity.Player;
import com.soccer.model.entity.Team;

public class viewotro {

    public static Controller controlador;
    public static Controller controlador1;

    public void start() {

        Scanner scanner = new Scanner(System.in);
        int verificar = 1;
        while (verificar == 1) {
            System.out.println("1. Crear Equipo");
            System.out.println("2. Actualizar Equipo");
            System.out.println("3. Buscar Equipo");
            System.out.println("4. Eliminar Equipo");
            System.out.println("5. Listar todos Equipos");
            System.out.println("6. Listar todos Jugadores");
            System.out.println("7. Salir");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    Team equipo = new Team();
                    String codigoEquipo = null;
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
                    System.out.println("Ingrese el codigo del equipo :");
                    codigoEquipo = scanner.nextLine();
                    Team equipoEditar = controlador.equipos.get(codigoEquipo);
                    if (equipoEditar != null) {
                        System.out.println("Ingrese Nombre del equipo :");
                        equipoEditar.setNombre(scanner.nextLine());
                        System.out.println("Ingrese la ciudad :");
                        equipoEditar.setCiudad(scanner.nextLine());
                        controlador.equipos.put(codigoEquipo, equipoEditar);
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
                    Enumeration<String> teamKeys = viewTeam.controlador.equipos.keys();
                    while (teamKeys.hasMoreElements()) {
                        String teamKey = teamKeys.nextElement();
                        System.out.println("Key: " + teamKey + " Nombre del equipo: " +
                        viewTeam.controlador.equipos.get(teamKey).getNombre());
                    }
                    break;

                case 6:
                    
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
