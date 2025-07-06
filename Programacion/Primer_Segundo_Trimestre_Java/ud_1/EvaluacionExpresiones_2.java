package ud_1;

public class EvaluacionExpresiones_2 {
	
    public static void main(String[] args) {
    	
        // 1. 24 % 5
        int resultado1 = 24 % 5;
        System.out.println("Resultado 1: " + resultado1);

        // 2. 7 / 2 + 2.5
        double resultado2 = 7.0 / 2 + 2.5;
        System.out.println("Resultado 2: " + resultado2);

        // 3. 10.8 / 2 + 2
        double resultado3 = 10.8 / 2 + 2;
        System.out.println("Resultado 3: " + resultado3);

        // 4. (4 + 6) * 3 + 2 * (5 - 1)
        int resultado4 = (4 + 6) * 3 + 2 * (5 - 1);
        System.out.println("Resultado 4: " + resultado4);

        // 5. 5 / 2 + 17 % 3
        int resultado5 = 5 / 2 + 17 % 3;
        System.out.println("Resultado 5: " + resultado5);

        // 6. 7 >= 5 OR 27 <> 8
        boolean resultado6 = 7 >= 5 || 27 != 8;
        System.out.println("Resultado 6: " + resultado6);

        // 7. (45 <= 7) OR NOT (5 >= 7)
        boolean resultado7 = (45 <= 7) || !(5 >= 7);
        System.out.println("Resultado 7: " + resultado7);

        // 8. 27 % 4 + 15 / 4
        double resultado8 = 27 % 4 + 15 / 4.0;
        System.out.println("Resultado 8: " + resultado8);

        // 9. 37 / 4 * 4 - 2
        int resultado9 = 37 / 4 * 4 - 2;
        System.out.println("Resultado 9: " + resultado9);

        // 10. (25 >= 7) AND NOT (7 <= 2)
        boolean resultado10 = (25 >= 7) && !(7 <= 2);
        System.out.println("Resultado 10: " + resultado10);

        // 11. ('H' < 'J') AND ('9' <> '7')
        boolean resultado11 = ('H' < 'J') && ('9' != '7');
        System.out.println("Resultado 11: " + resultado11);

        // 12. 25 > 20 AND 13 > 5
        boolean resultado12 = 25 > 20 && 13 > 5;
        System.out.println("Resultado 12: " + resultado12);

        // 13. 10 + 4 < 15 - 3 OR 2 * 5 + 1 > 14 - 2 * 2
        boolean resultado13 = (10 + 4 < 15 - 3) || (2 * 5 + 1 > 14 - 2 * 2);
        System.out.println("Resultado 13: " + resultado13);

        // 14. 4 * 2 <= 8 OR 2 * 2 < 5 AND 4 > 3 + 1
        boolean resultado14 = (4 * 2 <= 8) || (2 * 2 < 5 && 4 > 3 + 1);
        System.out.println("Resultado 14: " + resultado14);

        // 15. 10 <= 2 * 5 AND 3 < 4 OR NOT (8 > 7) AND 3 * 2 <= 4 * 2 - 1
        boolean resultado15 = (10 <= 2 * 5) && (3 < 4) || !(8 > 7) && (3 * 2 <= 4 * 2 - 1);
        System.out.println("Resultado 15: " + resultado15);
        
    }
}
