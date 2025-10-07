import java.util.ArrayList;

/**
 * Clase Topping representa un topping con id, nombre y precio.
 */
public class Topping {
    private int id;
    private String nombre;
    private float precio;

    public Topping(int id, String nombre, float precio) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
    }

    public float getPrecio() { return precio; }

    public int getId() { return id; }

    // ========== CRUD ==========
    public static void crearTopping(ArrayList<Topping> lista, Topping t) {
        lista.add(t);
        System.out.println("Topping agregado.");
    }

    public static void verToppings(ArrayList<Topping> lista) {
        if (lista.isEmpty()) System.out.println("No hay toppings registrados.");
        else for (Topping t : lista)
            System.out.println("ID: " + t.id + " | Nombre: " + t.nombre + " | Precio: $" + t.precio);
    }

    public static void editarTopping(ArrayList<Topping> lista, int id, float nuevoPrecio) {
        for (Topping t : lista) {
            if (t.id == id) { t.precio = nuevoPrecio; System.out.println("Topping actualizado."); return; }
        }
        System.out.println("Topping no encontrado.");
    }

    public static void eliminarTopping(ArrayList<Topping> lista, int id) {
        lista.removeIf(t -> t.id == id);
        System.out.println("Topping eliminado.");
    }
}