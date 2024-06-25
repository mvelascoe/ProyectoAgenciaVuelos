package com.proyectojava.rols.adapters.in;

import java.util.Optional;
import java.util.Scanner;

import com.proyectojava.rols.application.RolsService;
import com.proyectojava.rols.domain.models.Rols;

public class RolsConsoleAdapter {
    private final RolsService rolsService;

    public RolsConsoleAdapter(RolsService rolsService) {
        this.rolsService = rolsService;
    }

    public void startRols(){
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("1. Crear rol\n2. Actualizar informacion de rol\n3. Buscar rol\n4. Eliminar rol\n5. Listar todos los roles\n6. Volver\n\n");
            System.out.println("Ingresa una opcion");
            int opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Ingresa el nombre del rol: ");
                    String name = sc.next();

                    Rols newRol = new Rols(name);
                    rolsService.createRol(newRol);
                    break;
                case 2:
                    System.out.println("Ingrese el ID del rol: ");
                    int updateID = sc.nextInt();

                    System.out.println("Ingresa el nuevo nombre: ");
                    String updateName = sc.next();

                    Rols updateRols = new Rols(updateID,updateName);
                    rolsService.updateRol(updateRols);
                    break;
                case 3:
                    System.out.println("Ingresa el ID del rol a buscar: ");
                    int findId = sc.nextInt();

                    Optional<Rols> rol = rolsService.findRolById(findId);
                    rol.ifPresentOrElse(r -> System.out.println("Id: " + r.getId_rol() + ", Nombre: " + r.getNombre_rol()),
                    () -> System.out.println("Rol no encontrado"));
                    break;
                case 4:
                System.out.println("Ingrese el ID del rol a eliminar");
                int deleteId = sc.nextInt();
                rolsService.deleteRol(deleteId);
                break;
                case 5:
                System.out.println("ROLES");
                rolsService.findAllRols().forEach(ro ->{
                    System.out.println("Id: " + ro.getId_rol() + ", Nombre: " + ro.getNombre_rol());
                });
                    break;
                case 6:
                System.out.println("Volviendo al menu principal... Adios");
                    break;
                default:
                System.out.println("Opcion invalida. Intentalo de nuevo");
                sc.close();
                    break;
            }
        }
    }
}
