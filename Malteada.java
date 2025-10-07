import java.util.ArrayList;

/**
 * Clase Malteada representa una malteada con id, precio base, sabor y recargo por leche especial.
 */
public class Malteada {
    private int id;
    private float precioBase;
    private String sabor;
    private float adicionalLeche = 500;
    private ArrayList<Topping> toppings = new ArrayList<>();

    public Malteada(int id, float precioBase, String sabor) {
        this.id = id;
        this.precioBase = precioBase;
        this.sabor = sabor;
    }

    public void addTopping(Topping topping) { toppings.add(topping); }

    public float calcularPrecio() {
        float total = precioBase + adicionalLeche;
        for (Topping t : toppings) total += t.getPrecio();
        return total;
    }

    public String getSabor() { return sabor; }

    public int getId() { return id; }

    // ========== CRUD ==========
    public static void crearMalteada(ArrayList<Malteada> lista, Malteada m) {
        lista.add(m);
        System.out.println("Malteada agregada.");
    }

    public static void verMalteadas(ArrayList<Malteada> lista) {
        if (lista.isEmpty()) System.out.println("No hay malteadas registradas.");
        else for (Malteada m : lista)
            System.out.println("ID: " + m.id + " | Precio: $" + m.precioBase + " | Sabor: " + m.sabor);
    }

    public static void editarMalteada(ArrayList<Malteada> lista, int id, float nuevoPrecio) {
        for (Malteada m : lista) {
            if (m.id == id) { m.precioBase = nuevoPrecio; System.out.println("Malteada actualizada."); return; }
        }
        System.out.println("Malteada no encontrada.");
    }

    public static void eliminarMalteada(ArrayList<Malteada> lista, int id) {
        lista.removeIf(m -> m.id == id);
        System.out.println("Malteada eliminada.");
    }
}