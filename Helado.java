import java.util.ArrayList;

/**
 * Clase Helado representa un helado con id, precio base, sabores y toppings.
 */
public class Helado {
    private int id;
    private float precioBase;
    private ArrayList<String> sabores;
    private ArrayList<Topping> toppings;

    public Helado(int id, float precioBase, ArrayList<String> sabores) {
        this.id = id;
        this.precioBase = precioBase;
        this.sabores = sabores;
        this.toppings = new ArrayList<>();
    }

    public void addTopping(Topping topping) { toppings.add(topping); }

    public float calcularPrecio() {
        float total = precioBase;
        for (Topping t : toppings) total += t.getPrecio();
        return total;
    }

    public ArrayList<String> getSabores() { return sabores; }

    public int getId() { return id; }

    // ========== CRUD ==========
    public static void crearHelado(ArrayList<Helado> lista, Helado h) {
        lista.add(h);
        System.out.println("Helado agregado.");
    }

    public static void verHelados(ArrayList<Helado> lista) {
        if (lista.isEmpty()) System.out.println("No hay helados registrados.");
        else for (Helado h : lista)
            System.out.println("ID: " + h.id + " | Precio: $" + h.precioBase + " | Sabores: " + h.sabores);
    }

    public static void editarHelado(ArrayList<Helado> lista, int id, float nuevoPrecio) {
        for (Helado h : lista) {
            if (h.id == id) { h.precioBase = nuevoPrecio; System.out.println("Helado actualizado."); return; }
        }
        System.out.println("Helado no encontrado.");
    }

    public static void eliminarHelado(ArrayList<Helado> lista, int id) {
        lista.removeIf(h -> h.id == id);
        System.out.println("Helado eliminado.");
    }
}