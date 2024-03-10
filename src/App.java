import com.carro.Carro;
import com.carro.FactoryCarro;
import com.carro.ModeloCarro;
import com.carro.TipoCombustivel;

public class App {
    public static void main(String[] args) throws Exception {

        Carro basico = FactoryCarro.getCarro(ModeloCarro.BASICO);

        System.out.println("Tipos de veiculos:");
        System.out.println(basico);

        System.out.println("\n\n----------------");
        System.out.println("\nAbastencendo carro basico com gasolina");
        basico.abastece(TipoCombustivel.GASOLINA, 55);
        System.out.println(basico);
        System.out.println("\nViajando com o carro basico");
        basico.viaja(250);
        basico.viaja(150);
        System.out.println(basico);
    }
}
