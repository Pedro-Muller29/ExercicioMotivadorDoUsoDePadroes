import com.carro.Carro;
import com.carro.FactoryCarro;
import com.carro.ModeloCarro;
import com.carro.TipoCombustivel;

public class App {
    public static void main(String[] args) throws Exception {

        Carro economico = FactoryCarro.getCarro(ModeloCarro.ECONO);

        System.out.println("Tipos de veiculos:");
        System.out.println(economico);

        // Só para demonstrar o funcionamento do Econo
        for (int i = 0; i < 101; i ++) {
            System.out.println("\n\n----------------");
            System.out.println("\nAbastencendo carro economico com gasolina");
            economico.abastece(TipoCombustivel.GASOLINA, 55);
            System.out.println(economico);

            System.out.println("\nViajando com o carro economico");
            economico.viaja(561);
            System.out.println(economico);
        }
    }
}
