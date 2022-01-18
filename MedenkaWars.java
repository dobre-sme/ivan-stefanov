import java.util.Scanner;

public class MedenkaWars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //The Dark Medenka Lord Naskor
        //The White Medenka Lord Vitkor

        //1 medenka - 60 damage

        double naskorDamageDealt = 0;
        double vitkorDamageDealt = 0;
        int naskorAttackCount = 0;
        int vitkorAttackCount = 0;
        double naskorLastDamageAmount = 0;
        double vitkorLastDmgAmount = 0;
        double currentAttackV = 0;
        double currentAttackN = 0;

        String command = scanner.nextLine();

        while(!command.equals("end")){
        String[] data = command.split("\\s+");
            int medenkaCount = Integer.parseInt(data[0]);
            switch (data[1]){
                case "white": // Vitkor attacks
                    if (vitkorAttackCount == 2){
                        vitkorDamageDealt += (medenkaCount * 60) * 2.75;
                        vitkorAttackCount = 0;
                    }
                    currentAttackV = medenkaCount * 60;
                    vitkorDamageDealt += currentAttackV;

                    if (currentAttackV == vitkorLastDmgAmount || vitkorLastDmgAmount == 0){
                        vitkorAttackCount++;
                    }else {
                        vitkorAttackCount = 0;
                    }
                    vitkorLastDmgAmount = currentAttackV;

                    break;
                case "dark":  // Naskor attacks
                    currentAttackN = medenkaCount * 60;
                    if (currentAttackN == naskorLastDamageAmount || naskorLastDamageAmount ==0){
                        naskorAttackCount++;
                    }else {
                        naskorAttackCount = 0;
                    }
                    if (naskorAttackCount == 5){
                        naskorDamageDealt += currentAttackN * 4.5;
                        naskorAttackCount = 1;
                    }else {
                        naskorDamageDealt += currentAttackN;
                        naskorLastDamageAmount = currentAttackN;
                    }


                    break;
            }
            command = scanner.nextLine();
        }

        if (vitkorDamageDealt > naskorDamageDealt){
            System.out.println("Winner - Vitkor");
            System.out.printf("%.0f", vitkorDamageDealt);
        }else {
            System.out.println("Naskor");
            System.out.printf("%.0f", naskorDamageDealt);
        }
    }
}
