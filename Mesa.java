/**
 * Clase Mesa representa una mesa de la heladería con número y pedido asociado.
 */
public class Mesa {
    private int numero;
    private Pedido pedido;

    public Mesa(int numero) {
        this.numero = numero;
        this.pedido = new Pedido(this);
    }

    public int getNumero() { return numero; }
    public void setNumero(int numero) { this.numero = numero; }

    public Pedido getPedido() { return pedido; }
}