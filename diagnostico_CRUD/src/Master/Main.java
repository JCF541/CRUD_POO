package Master;

import java.util.Scanner;
//Errores a resolver
//  1. La captura de Strings a través del método Scanner.nextLine() no está capturando el input
//  2. El programa no cuenta con permanencia ya que me estaba encontrando con errores al utilizar un fstream, se implementó un arrayList estático para simular la base de datos
//  3. Falta la implementación adecuada de la relación ManyToOne en (Account:Client), por eso mismo no hay un equivalente de delete:onCASCADE al realizar el borrado de algun objeto
//  4. No hay manejo de errores a través de try-catch, se implementaron estructuras if para controlar el input 
public class Main {
    public static void main(String args[]){
        //Variables de rastreo
        int num_clt, num_acc;
        String nom_clt;
        double bal_acc;
        Scanner sc = new Scanner(System.in);
        Client ref_clt = new Client();
        Account ref_acc = new Account();
        //Variables de control
        int op = 0;
        boolean flag = true;
        
        do{
            System.out.println("CRUD PRUEBA");
            System.out.println("1: Crear Cliente");
            System.out.println("2: Actualizar Cliente");
            System.out.println("3: Eliminar Cliente");
            System.out.println("4: Crear Cuenta");
            System.out.println("5: Actualizar Cuenta");
            System.out.println("6: Eliminar Cuenta");
            System.out.println("\n");
            
            op = sc.nextInt();
            switch(op){
                case 1 -> {
                    System.out.println("Capture el nombre de cliente");
                    nom_clt = sc.nextLine();
                    sc.nextLine();
                    System.out.println("Capture el numero de cliente");
                    num_clt = sc.nextInt();
                    //ref_clt.createClient(num_clt, nom_clt);
                    System.out.println("Nuevo Cliente" + nom_clt + " creado exitosamente");
                    System.out.println("\n");
                }
                case 2 -> {
                    System.out.println("Capture el numero de cliente a actualizar");
                    num_clt = sc.nextInt();
                    System.out.println("Capture el nuevo nombre del cliente");
                    nom_clt = sc.nextLine();
                    sc.nextLine();
                    //ref_clt.updateClient(num_clt, nom_clt);
                    System.out.println("Cliente " + num_clt + "actualizado exitosamente");
                    System.out.println("\n");
                }
                case 3 -> {
                    System.out.println("Capture el numero de cliente a eliminar");
                    num_clt = sc.nextInt();
                    //ref_clt.deleteClient(num_clt);
                    System.out.println("Cliente " + num_clt + " eliminado exitosamente");
                    System.out.println("\n");
                }
                case 4 -> {
                    System.out.println("Capture el numero de cuenta");
                    num_acc = sc.nextInt();
                    System.out.println("Capture el balance inicial de la cuenta");
                    bal_acc = sc.nextDouble();
                    System.out.println("Capture el numero de cliente asociado");
                    num_clt = sc.nextInt();
                    //ref_acc.createAccount(num_acc, bal_acc, num_clt);
                    System.out.println("Cuenta creada exitosamente");
                    System.out.println("\n");
                }
                case 5 -> {
                    System.out.println("Capture el numero de cuenta a modificar");
                    num_acc = sc.nextInt();
                    System.out.println("Capture el nuevo balance");
                    bal_acc = sc.nextDouble();
                    //ref_acc.updateAccount(num_acc, bal_acc);
                    System.out.println("Balance de cuenta " + num_acc + " actualizado exitosamente");
                    System.out.println("\n");
                }
                case 6 -> {
                    System.out.println("Capture el numero de cuenta a modificar");
                    num_acc = sc.nextInt();
                    //ref_acc.deleteAccount(num_acc);
                    System.out.println("Cuenta " + num_acc + " eliminada exitosamente");
                    System.out.println("\n");
                }
                default -> flag = false;
            }
        }while(flag == true);
        
        //ref_clt.findAllClients();
        //ref_acc.findAllAccounts();
        
    }
}
