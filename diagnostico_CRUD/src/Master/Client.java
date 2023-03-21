package Master;

//import java.util.ArrayList;
public class Client {
  private int id;
  private String name;
  private String address;
  
  public Client() {
    this.id = 0;
    this.name = null;
    this.address = null;
  }

  public Client(int id, String name, String address) {
    this.id = id;
    this.name = name;
    this.address = address;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }
}
/*public class Client {
    private int client_number;
    private String client_name;
    //Implementamos un arrayList estatico para llevar el control de clientes
    private static ArrayList<Client> clients = new ArrayList<Client>();

    public Client() {
        this.client_number = 0;
        this.client_name = null;
    }
    public Client(int client_number, String client_name) {
        this.client_number = client_number;
        this.client_name = client_name;
    }

    public int getClientNumber() {
        return this.client_number;
    }

    public void setClientNumber(int client_number) {
        this.client_number = client_number;
    }

    public String getClientName() {
        return this.client_name;
    }

    public void setClientName(String client_name) {
        this.client_name = client_name;
    }

    public void createClient(int client_number, String client_name) {
        Client newClient = new Client(client_number, client_name);
        clients.add(newClient);
    }

    public void readClient(int client_number) {
        for (Client client: clients) {
            if (client.getClientNumber() == client_number) {
                System.out.println("Numero Cliente: " + client.getClientNumber());
                System.out.println("Nombre Cliente: " + client.getClientName());
                return;
            }
        }
        System.out.println("No se hallo al Cliente");
    }

    public void updateClient(int client_number, String new_client_name) {
        for (Client client: clients) {
            if (client.getClientNumber() == client_number) {
                client.setClientName(new_client_name);
                return;
            }
        }
        System.out.println("No se hallo al Cliente");
    }

    public void deleteClient(int client_number) {
        for (int i = 0; i < clients.size(); i++) {
            if (clients.get(i).getClientNumber() == client_number) {
                clients.remove(i);
                return;
            }
        }
        System.out.println("No se hallo al Cliente");
    }
    
    public void findClient(int client_number) {
        for (Client client : clients) {
            if (client.getClientNumber() == client_number) {
                System.out.println("Numero Cliente: " + client.getClientNumber());
                System.out.println("Nombre Cliente: " + client.getClientName());
                return;
            }
        }
        System.out.println("No se hallo al Cliente");
    }
    
    
    public void findAllClients() {
        if (clients.isEmpty()) {
            System.out.println("No se hallaron Clientes");
            return;
        }
        for (Client client : clients) {
            System.out.println("Numero Cliente: " + client.getClientNumber());
            System.out.println("Nombre Cliente: " + client.getClientName());
        }
    }
}*/
