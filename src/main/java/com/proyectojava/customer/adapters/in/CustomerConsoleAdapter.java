package com.proyectojava.customer.adapters.in;

import java.util.Optional;
import java.util.Scanner;

import com.proyectojava.customer.application.CustomerService;
import com.proyectojava.customer.domain.models.Customer;
import com.proyectojava.documenttype.domain.models.Documenttype;

public class CustomerConsoleAdapter {
    private final CustomerService customerService;

    public CustomerConsoleAdapter(CustomerService customerService) {
        this.customerService = customerService;
    }

    public void startCustomer() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println(
                    "\n\n1. Crear Cliente\n2. Actualizar informacion de Cliente\n3. Buscar Cliente\n4. Eliminar Cliente\n5. Listar todas las Clientes\n6. Volver\n\n");
            System.out.println("Ingresa una opcion");
            int opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Ingresa el Id del cliente: ");
                    String id = sc.next();
                    sc.nextLine();

                    System.out.println("Ingresa el nombre del cliente: ");
                    String name = sc.nextLine();

                    System.out.println("Ingresa la edad del cliente: ");
                    int edad = sc.nextInt();

                    System.out.println("Ingresa el id del documento: ");
                    int document = sc.nextInt();

                    Optional<Documenttype> optionalDocument = customerService.findDocument(document);
                    if(optionalDocument.isPresent()){
                        Customer custom = new Customer(id, name, edad, document);
                    customerService.createCustomer(custom);
                    System.out.println("\n\n Cliente creado exitosamente!!");
                    }else{
                        System.out.println("Error: El documento "+ document + " no existe.");
                    }
                    
                    break;
                case 2:
                    System.out.println("Ingresa el id del cliente a actualizar: ");
                    String upID = sc.next();

                    System.out.println("Ingresa el nuevo nombre del cliente: ");
                    String upname = sc.next();

                    System.out.println("Ingresa edad del cliente actualizada:");
                    int upEdad = sc.nextInt();

                    System.out.println("Ingresa nuevo id del documento del cliente: ");
                    int upDocument = sc.nextInt();

                    Customer custom1 = new Customer(upID, upname, upEdad, upDocument);
                    customerService.updateCustomer(custom1);

                    System.out.println("\n\n Cliente actualizado correctamente!!");
                    break;
                case 3:
                    System.out.println("Ingresa el id del cliente a buscar: ");
                    String findID = sc.next();

                    Optional<Customer> custom3 = customerService.findCustomerById(findID);
                    custom3.ifPresentOrElse(
                            c -> System.out.println("Id: " + c.getId_cliente() + ", Nombre: " + c.getNombre_cliente()
                                    + ", Edad: " + c.getEdad_cliente() + ", ID_documento: " + c.getId_documento()),
                            () -> System.out.println("No se encontro el cliente"));
                    break;
                case 4:
                    System.out.println("Ingresa el id del cliente a eliminar: ");
                    String deleteId = sc.next();

                    customerService.deleteCustomer(deleteId);
                    System.out.println("\n\n Cliente eliminado correctamente!!");
                    break;
                case 5:
                    System.out.println("CLIENTES");
                    customerService.findAllCustomer().forEach(lc -> {
                        System.out.println("Id: " + lc.getId_cliente() + ", Nombre: " + lc.getNombre_cliente() + ", Edad: " + lc.getEdad_cliente() + ", ID_documento: "  + lc.getId_documento());
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
