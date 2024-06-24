package com.soccer.view;
import java.util.Enumeration;
import java.util.Scanner;
import com.soccer.Controller;
import com.soccer.model.entity.Doctor;

public class viewDoctor {


    public static Controller controlador;

    public void start() {
        Enumeration names;
        String key;
        names = controlador.doctores.keys();
        while (names.hasMoreElements()) {
            key = (String) names.nextElement();
            System.out.println("Key: " + key + " Nombre del doctor: " +
                    controlador.doctores.get(key).getNombre());
        }
        Scanner scanner = new Scanner(System.in);
        int verificar=1;
        while (verificar==1) {
            System.out.println("1. Crear Doctor");
            System.out.println("2. Actualizar Doctor");
            System.out.println("3. Buscar Doctor");
            System.out.println("4. Eliminar Doctor");
            System.out.println("5. Listar todos los Doctor");
            System.out.println("6. Salir");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    Doctor doctor = new Doctor();
                    String codigoDoctor = null;
                    System.out.println("Ingrese el codigo del doctor :");
                    codigoDoctor = doctor.setId(scanner.nextLine());                   
                    System.out.println("Ingrese nombre del doctor :");
                    doctor.setNombre(scanner.nextLine());
                    System.out.println("Ingrese apellido del doctor :");
                    doctor.setApellido(scanner.nextLine());
                    System.out.println("Ingrese años del doctor :");
                    doctor.setEdad(scanner.nextInt());
                    System.out.println("Ingrese años de experiencia del doctor :");
                    doctor.setExpYear(scanner.nextInt());
                    scanner.nextLine();
                    System.out.println("Ingrese titulo del doctor :");
                    doctor.setTitulo(scanner.nextLine());
                  
                    controlador.doctores.put(codigoDoctor, doctor);
                    break;

                case 2:

                    break;

                case 3:
                    Doctor doc = new Doctor();
                    System.out.println("nombre del doctor" + doc.getNombre());
                    System.out.println("Ingrese codigo del doctor a buscar :");
                    String codigoP = scanner.nextLine();
                    doc = controlador.doctores.get(codigoP);
                    System.out.println("EL doctor se llama " + doc.getNombre());
                    break;
                case 4:
                    Doctor docE = new Doctor();

                    System.out.println("Ingrese codigo del doctor a eliminar :");
                    String codigoEl = scanner.nextLine();
                    docE = controlador.doctores.remove(codigoEl);
                    System.out.println("El doctor elimnado fue " + docE.getNombre());
                    break;

                case 5:
                    Enumeration names1;
                    String key1;
                    names1 = controlador.doctores.keys();
                    while (names1.hasMoreElements()) {
                        key1 = (String) names1.nextElement();
                        System.out.println("Key: " + key1 + " Nombre del doctor: " +
                                controlador.doctores.get(key1).getNombre());
                    }
                    break;

                case 6:
                verificar=0;
                    break;

                default:
                    System.out.println("Opcion invalida, intentelo de nuevo.");
            }
        }
    }
}
