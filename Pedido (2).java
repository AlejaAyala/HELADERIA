/**
 * Clase Pedido representa un pedido de una mesa con helados, malteadas y propina.
 */
import java.util.ArrayList;

public class Pedido {
    private Mesa mesa;
    private ArrayList<Helado> helados;
    private ArrayList<Malteada> malteadas;
    private float propina;

    public Pedido(Mesa mesa) {
        this.mesa = mesa;
        this.helados = new ArrayList<>();
        this.malteadas = new ArrayList<>();
        this.propina = 0;
    }

    public void addHelado(Helado h) { helados.add(h); }
    public void addMalteada(Malteada m) { malteadas.add(m); }
    public void setPropina(float propina) { this.propina = propina; }

    public void verPedido() {
        System.out.println("\nPedido mesa " + mesa.getNumero() + ":");
        for (Helado h : helados) System.out.println("Helado: " + h.getSabores() + " | $" + h.calcularPrecio());
        for (Malteada m : malteadas) System.out.println("Malteada: " + m.getSabor() + " | $" + m.calcularPrecio());
        System.out.println("Propina: $" + propina);
        System.out.println("Total: $" + calcularCuenta());
    }

    public float calcularCuenta() {
        float total = 0;
        for (Helado h : helados) total += h.calcularPrecio();
        for (Malteada m : malteadas) total += m.calcularPrecio();
        return total + propina;
    }
}