import com.carro.Carro;
import com.carro.FactoryCarro;
import com.carro.ModeloCarro;
import com.carro.TipoCombustivel;

public class App {
    public static void main(String[] args) throws Exception {

        Carro suv = FactoryCarro.getCarro(ModeloCarro.SUVFlex);

        System.out.println("Tipos de veiculos:");
        System.out.println(suv);

        System.out.println("\n\n----------------");
        System.out.println("\nAbastencendo carro suv com gasolina");
        suv.abastece(TipoCombustivel.GASOLINA, 15);
        suv.abastece(TipoCombustivel.ALCOOL, 6);
        System.out.println(suv);
        System.out.println("\nViajando com o carro suv");
        suv.viaja(250);
        suv.viaja(150);
        System.out.println(suv);
    }
}
