import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Sede> listaSedes = new ArrayList<>();
        boolean salir = false;

        while (!salir) {
            System.out.println("\n===== MENÚ PRINCIPAL =====");
            System.out.println("1. Gestionar Sucursales");
            System.out.println("2. Gestionar Productos de Sucursal");
            System.out.println("3. Gestionar Pedidos de Mesas");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = sc.nextInt(); sc.nextLine();

            switch (opcion) {
                case 1: menuSedes(sc, listaSedes); break;
                case 2: menuProductos(sc, listaSedes); break;
                case 3: menuPedidos(sc, listaSedes); break;
                case 0: salir = true; System.out.println("Saliendo del sistema..."); break;
                default: System.out.println("Opción inválida.");
            }
        }

        sc.close();
    }

    // ==============================
    // MENÚ SUCURSALES
    // ==============================
    public static void menuSedes(Scanner sc, ArrayList<Sede> listaSedes) {
        boolean volver = false;
        while (!volver) {
            System.out.println("\n--- GESTIONAR SUCURSALES ---");
            System.out.println("1. Crear Sucursal");
            System.out.println("2. Ver Sucursales");
            System.out.println("3. Editar Sucursal");
            System.out.println("4. Eliminar Sucursal");
            System.out.println("0. Volver");
            System.out.print("Seleccione una opción: ");
            int op = sc.nextInt(); sc.nextLine();

            switch (op) {
                case 1:
                    System.out.print("ID Sucursal: "); int id = sc.nextInt(); sc.nextLine();
                    System.out.print("Nombre: "); String nombre = sc.nextLine();
                    System.out.print("Dirección: "); String direccion = sc.nextLine();
                    Sede.crearSede(listaSedes, new Sede(id, nombre, direccion));
                    break;
                case 2: Sede.verSedes(listaSedes); break;
                case 3:
                    System.out.print("ID Sucursal a editar: "); int idEdit = sc.nextInt(); sc.nextLine();
                    System.out.print("Nuevo nombre: "); String nuevoNombre = sc.nextLine();
                    System.out.print("Nueva dirección: "); String nuevaDireccion = sc.nextLine();
                    Sede.editarSede(listaSedes, idEdit, nuevoNombre, nuevaDireccion);
                    break;
                case 4:
                    System.out.print("ID Sucursal a eliminar: "); int idEliminar = sc.nextInt(); sc.nextLine();
                    Sede.eliminarSede(listaSedes, idEliminar);
                    break;
                case 0: volver = true; break;
                default: System.out.println("Opción inválida.");
            }
        }
    }

    // ==============================
    // MENÚ PRODUCTOS POR SUCURSAL
    // ==============================
    public static void menuProductos(Scanner sc, ArrayList<Sede> listaSedes) {
        System.out.print("ID de la Sucursal: ");
        int idSede = sc.nextInt(); sc.nextLine();
        Sede sede = buscarSede(listaSedes, idSede);
        if (sede == null) { System.out.println("Sucursal no encontrada"); return; }

        boolean volver = false;
        while (!volver) {
            System.out.println("\n--- GESTIONAR PRODUCTOS EN " + sede.getNombre() + " ---");
            System.out.println("1. Agregar Helado");
            System.out.println("2. Agregar Malteada");
            System.out.println("3. Agregar Topping");
            System.out.println("4. Ver Productos");
            System.out.println("0. Volver");
            System.out.print("Seleccione una opción: ");
            int op = sc.nextInt(); sc.nextLine();

            switch (op) {
                case 1:
                    System.out.print("ID Helado: "); int idH = sc.nextInt(); sc.nextLine();
                    System.out.print("Precio base: "); float precioH = sc.nextFloat(); sc.nextLine();
                    System.out.print("Sabores (separados por coma): "); String line = sc.nextLine();
                    ArrayList<String> sabores = new ArrayList<>();
                    for (String s : line.split(",")) sabores.add(s.trim());
                    sede.agregarHelado(new Helado(idH, precioH, sabores));
                    break;
                case 2:
                    System.out.print("ID Malteada: "); int idM = sc.nextInt(); sc.nextLine();
                    System.out.print("Precio base: "); float precioM = sc.nextFloat(); sc.nextLine();
                    System.out.print("Sabor: "); String sabor = sc.nextLine();
                    sede.agregarMalteada(new Malteada(idM, precioM, sabor));
                    break;
                case 3:
                    System.out.print("ID Topping: "); int idT = sc.nextInt(); sc.nextLine();
                    System.out.print("Nombre: "); String nombreT = sc.nextLine();
                    System.out.print("Precio: "); float precioT = sc.nextFloat(); sc.nextLine();
                    sede.agregarTopping(new Topping(idT, nombreT, precioT));
                    break;
                case 4: sede.verProductos(); break;
                case 0: volver = true; break;
                default: System.out.println("Opción inválida.");
            }
        }
    }

    // ==============================
    // MENÚ PEDIDOS POR MESA
    // ==============================
    public static void menuPedidos(Scanner sc, ArrayList<Sede> listaSedes) {
        System.out.print("ID de la Sucursal: ");
        int idSede = sc.nextInt(); sc.nextLine();
        Sede sede = buscarSede(listaSedes, idSede);
        if (sede == null) { System.out.println("Sucursal no encontrada"); return; }

        ArrayList<Mesa> listaMesas = new ArrayList<>();
        boolean volver = false;
        while (!volver) {
            System.out.println("\n--- GESTIONAR PEDIDOS EN " + sede.getNombre() + " ---");
            System.out.println("1. Crear Mesa y Pedido");
            System.out.println("2. Agregar Helado a Pedido");
            System.out.println("3. Agregar Malteada a Pedido");
            System.out.println("4. Ver Pedido de Mesa");
            System.out.println("0. Volver");
            System.out.print("Seleccione una opción: ");
            int op = sc.nextInt(); sc.nextLine();

            switch (op) {
                case 1:
                    System.out.print("Número de mesa: "); int numMesa = sc.nextInt(); sc.nextLine();
                    listaMesas.add(new Mesa(numMesa));
                    System.out.println("Mesa " + numMesa + " creada.");
                    break;
                case 2:
                    System.out.print("Número de mesa: "); int numH = sc.nextInt(); sc.nextLine();
                    Mesa mH = buscarMesa(listaMesas, numH);
                    if (mH != null) {
                        System.out.print("ID Helado: "); int idH = sc.nextInt(); sc.nextLine();
                        Helado h = buscarHelado(sede.getHelados(), idH);
                        if (h != null) mH.getPedido().addHelado(h);
                        else System.out.println("Helado no encontrado");
                    } else System.out.println("Mesa no encontrada");
                    break;
                case 3:
                    System.out.print("Número de mesa: "); int numM = sc.nextInt(); sc.nextLine();
                    Mesa mM = buscarMesa(listaMesas, numM);
                    if (mM != null) {
                        System.out.print("ID Malteada: "); int idM = sc.nextInt(); sc.nextLine();
                        Malteada malteada = buscarMalteada(sede.getMalteadas(), idM);
                        if (malteada != null) mM.getPedido().addMalteada(malteada);
                        else System.out.println("Malteada no encontrada");
                    } else System.out.println("Mesa no encontrada");
                    break;
                case 4:
                    System.out.print("Número de mesa: "); int numV = sc.nextInt(); sc.nextLine();
                    Mesa mesa = buscarMesa(listaMesas, numV);
                    if (mesa != null) {
                        System.out.print("Propina: "); float propina = sc.nextFloat(); sc.nextLine();
                        mesa.getPedido().setPropina(propina);
                        mesa.getPedido().verPedido();
                    } else System.out.println("Mesa no encontrada");
                    break;
                case 0: volver = true; break;
                default: System.out.println("Opción inválida");
            }
        }
    }

    // ==============================
    // MÉTODOS AUXILIARES
    // ==============================
    public static Sede buscarSede(ArrayList<Sede> lista, int id) {
        for (Sede s : lista) if (s.getId() == id) return s;
        return null;
    }

    public static Mesa buscarMesa(ArrayList<Mesa> lista, int numero) {
        for (Mesa m : lista) if (m.getNumero() == numero) return m;
        return null;
    }

    public static Helado buscarHelado(ArrayList<Helado> lista, int id) {
        for (Helado h : lista) if (h.getId() == id) return h;
        return null;
    }

    public static Malteada buscarMalteada(ArrayList<Malteada> lista, int id) {
        for (Malteada m : lista) if (m.getId() == id) return m;
        return null;
    }
}