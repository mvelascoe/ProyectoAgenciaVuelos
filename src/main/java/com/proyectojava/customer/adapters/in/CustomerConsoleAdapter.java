package com.proyectojava.customer.adapters.in;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.proyectojava.customer.application.CustomerService;
import com.proyectojava.customer.domain.models.Customer;
import com.proyectojava.documenttype.domain.models.Documenttype;
import com.proyectojava.generalConsole.in.GeneralConsoleAdapter;
public class CustomerConsoleAdapter {
    private final CustomerService customerService;

    public CustomerConsoleAdapter(CustomerService customerService) {
        this.customerService = customerService;
    }

    public void startCustomer() throws ParseException {
        Scanner sc = new Scanner(System.in);
        GeneralConsoleAdapter MP = new GeneralConsoleAdapter(); 
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
                    List<Documenttype> documents = customerService.findAllDocument();

                    System.out.println("-------------------------------------------------");
                    System.out.printf("%-15s %-40s%n", "ID_documento", "Nombre_documento ");
                    System.out.println("--------------------------------------------------");
                    
                    for (Documenttype doc : documents) {
                        System.out.printf("%-10s %-30s%n", doc.getId_documento(), doc.getNombre_documento());
                    }
                    System.out.println("\nIngresa el id del documento: ");
                    int document = sc.nextInt();

                    Optional<Documenttype> optionalDocument = customerService.findDocument(document);
                    if (optionalDocument.isPresent()) {
                        Customer custom = new Customer(id, name, edad, document);
                        customerService.createCustomer(custom);
                        System.out.println("\n**************************************");
                        System.out.println("*    Cliente creado exitosamente     *");
                        System.out.println("**************************************\n");
                    } else {
                        System.out.println("Error: El documento " + document + " no existe.");
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

                    System.out.println("\n*************************************");
                    System.out.println("* Cliente actualizado correctamente *");
                    System.out.println("*************************************\n");

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
                    System.out.println("\n**********************************");
                    System.out.println("* Cliente eliminado exitosamente *");
                    System.out.println("**********************************\n");
                    
                    break;
                case 5:
                    System.out.println(" #######   ##      #######  #######  ##  ###  #######  #######  #######");
                    System.out.println("##  ###   ##        ###    ##       ### ###    ###    ##       ##");
                    System.out.println("##  ###   ##        ###    ##       #######    ###    ##       ####### ");
                    System.out.println("##       ###        ###    #######  ## ####    ###    #######       ##");
                    System.out.println("##   ##  ###        ###    ###      ##  ###    ###    ###      ###  ## ");
                    System.out.println("##   ##  ###        ###    # #      ##  ###    ###    # #      ###  ## ");
                    System.out.println("#######  ######   #######  #######  ##  ###    ###    #######  ####### ");
                    customerService.findAllCustomer().forEach(lc -> {
                        System.out.println("Id: " + lc.getId_cliente() + ", Nombre: " + lc.getNombre_cliente()
                                + ", Edad: " + lc.getEdad_cliente() + ", ID_documento: " + lc.getId_documento());
                    });
                    break;
                case 6:
                    System.out.println("Volviendo al menu principal... Adios");
                    MP.showSalesAgentMenu(sc);
                    break;
                default:
                    System.out.println("Opcion invalida. Intentalo de nuevo");
                    break;
            }
        }

    }

}
