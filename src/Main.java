import java.util.Scanner;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Cavallo[] cavalli = new Cavallo[5];
        cavalli[0] = new Cavallo("Fulmine");
        cavalli[1] = new Cavallo("Lampo");
        cavalli[2] = new Cavallo("Rose");
        cavalli[3] = new Cavallo("Astra");
        cavalli[4] = new Cavallo("Rambo");

        for (Cavallo cavallo : cavalli) {
            System.out.println("Inserisci la lentezza di " + cavallo.getName());
            int tmp = input.nextInt();
            cavallo.setLentezza(tmp);
        }

        // Seleziona un cavallo casuale da interrompere
        Random rand = new Random();
        int indexCavalloDaInterrompere = rand.nextInt(cavalli.length);
        Cavallo cavalloDaInterrompere = cavalli[indexCavalloDaInterrompere];

        System.out.println("⚠️ Il cavallo che potrebbe cadere è: " + cavalloDaInterrompere.getName());

        // Avvia il thread "Tilt" che interrompe il cavallo selezionato dopo un po'
        Thread tilt = new Thread(new Tilt(cavalloDaInterrompere));
        tilt.start();

        // Avvia tutti i cavalli
        for (Cavallo cavallo : cavalli) {
            cavallo.start();
        }
    }
}
