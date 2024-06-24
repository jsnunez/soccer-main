package com.soccer;

import java.util.Scanner;

import com.soccer.model.entity.Coach;
import com.soccer.model.entity.Doctor;
import com.soccer.model.entity.Player;
import com.soccer.model.entity.Team;
import com.soccer.view.viewCoach;
import com.soccer.view.viewDoctor;
import com.soccer.view.viewPlayer;
import com.soccer.view.viewTeam;

public class Main {
    public static void main(String[] args) {
        Controller controlador = new Controller();

        viewTeam.controlador = controlador;
        viewPlayer.controlador = controlador;
        viewDoctor.controlador = controlador;
        viewCoach.controlador = controlador;

        viewTeam vt = new viewTeam();
        viewPlayer vp = new viewPlayer();
        viewDoctor vd = new viewDoctor();
        viewCoach vc = new viewCoach();

        Scanner sc = new Scanner(System.in);
            
            Team equipo= new Team("medellin","medellin");
            controlador.equipos.put("001",equipo);
            equipo= new Team("bucaros","bucaramn");
            controlador.equipos.put("002",equipo);
            Player jugador= new Player("001", "pepito", "XXXX", 25, 11, "Medio");
            controlador.jugadores.put("001",jugador);

              jugador= new Player("002", "sebastian", "XXXX", 45, 11, "Medio");
              controlador.jugadores.put("002",jugador);
            Doctor doctor = new Doctor("001","pedro","lopez" , 33,"internista", 10);
            controlador.doctores.put("001", doctor);
            Coach entrenador = new Coach("001","camilo" , "ruiz", 45, 001);
            controlador.entrenadores.put("001",entrenador);

            // equipo = ctrlTeams.equipos.get("001");
            // System.out.println(equipo.getNombre());
            // System.out.println(equipo.getLstJugadores().get(0).getNombre());

        while (true) {
            System.out.println("1. Equipos");
            System.out.println("2. Jugadores");
            System.out.println("3. Coach");
            System.out.println("4. Doctores");
            System.out.println("5. Salir");

            int opcion;
            try {
                opcion = sc.nextInt();
            } catch (Exception e) {
                System.out.println("Por favor, ingrese un número válido.");
                sc.nextLine(); // clear the buffer
                continue;
            }

            switch (opcion) {
                case 1:
                    vt.start();
                    break;
                case 2:
                    vp.start();
                    break;
                case 3:
                    vc.start();
                    break;
                case 4:
                    vd.start();
                    break;
                case 5:
                    System.out.println("Cerrando el programa");
                    sc.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción inválida, inténtelo de nuevo.");
            }
        }
    }
}
