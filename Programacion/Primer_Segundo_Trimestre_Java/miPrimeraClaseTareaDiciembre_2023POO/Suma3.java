package miPrimeraClaseTareaDiciembre_2023POO;

public class Suma3 {

	 // Atributo de la clase
    private int id;

    
    // Constructor
    public Suma3(int numero) {
        this.id = numero;
    }

    
    // Getter
    public int devuelveId() {
        return id;
   }
	
	
	
	
	public static void main(String[] args) {
		
		int numero = 23;
        Suma3 s = new Suma3(numero);
        System.out.println(s.devuelveId());
		
		
	}
	
	
	
}
