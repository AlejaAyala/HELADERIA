import java.util.ArrayList;

/**
 * Clase Sede representa una sucursal de heladería con productos y mesas.
 */
public class Sede {
    private int id;
    private String nombre;
    private String direccion;
    private ArrayList <Helado> helados;
    private ArrayList <Malteada> malteadas;
    private ArrayList <Topping> toppings;

    public Sede(int id, String nombre, String direccion) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.helados = new ArrayList<>();
        this.malteadas = new ArrayList<>();
        this.toppings = new ArrayList<>();
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getDireccion() { return direccion; }

    public ArrayList<Helado> getHelados() { return helados; }
    public ArrayList<Malteada> getMalteadas() { return malteadas; }
    public ArrayList<Topping> getToppings() { return toppings; }

    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    // CRUD de sucursales
    public static void crearSede(ArrayList<Sede> lista, Sede s) {
        lista.add(s); System.out.println("Sucursal agregada.");
    }

    public static void verSedes(ArrayList<Sede> lista) {
        if (lista.isEmpty()) System.out.println("No hay sucursales registradas.");
        else for (Sede s : lista)
            System.out.println("ID: " + s.id + " | Nombre: " + s.nombre + " | Dirección: " + s.direccion);
    }

    public static void editarSede(ArrayList<Sede> lista, int id, String nuevoNombre, String nuevaDireccion) {
        for (Sede s : lista) {
            if (s.id == id) { s.nombre = nuevoNombre; s.direccion = nuevaDireccion; System.out.println("Sucursal actualizada."); return; }
        }
        System.out.println("Sucursal no encontrada.");
    }

    public static void eliminarSede(ArrayList<Sede> lista, int id) {
        lista.removeIf(s -> s.id == id);
        System.out.println("Sucursal eliminada.");
    }

    // Gestionar productos por sucursal
    public void agregarHelado(Helado h) { helados.add(h); }
    public void agregarMalteada(Malteada m) { malteadas.add(m); }
    public void agregarTopping(Topping t) { toppings.add(t); }

    public void verProductos() {
        System.out.println("\nProductos de " + nombre + ":");
        System.out.println("Helados:");
        for (Helado h : helados) System.out.println("ID: " + h.getId() + " | Sabores: " + h.getSabores() + " | Precio: $" + h.calcularPrecio());
        System.out.println("Malteadas:");
        for (Malteada m : malteadas) System.out.println("ID: " + m.getId() + " | Sabor: " + m.getSabor() + " | Precio: $" + m.calcularPrecio());
        System.out.println("Toppings:");
        for (Topping t : toppings) System.out.println("ID: " + t.getId() + " | Precio: $" + t.getPrecio());
    }
}