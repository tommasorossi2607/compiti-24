import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner input = new Scanner(System.in);

        Cavallo[] cavalli = new Cavallo[5];
        cavalli[0] = new Cavallo("Fulmine");
        cavalli[1] = new Cavallo("Lampo");
        cavalli[2] = new Cavallo("Rose");
        cavalli[3] = new Cavallo("Astra");
        cavalli[4] = new Cavallo("Rambo");

        System.out.println("=== Imposta la lentezza di ogni cavallo (in millisecondi tra i passi) ===");
        for (Cavallo cavallo : cavalli) {
            System.out.print("Lentezza di " + cavallo.getName() + ": ");
            cavallo.setLentezza(input.nextInt());
        }

        // 🔹 Avvia tutti i cavalli
        System.out.println("\n🏁 La gara sta per iniziare!");
        for (Cavallo cavallo : cavalli) {
            cavallo.start();
        }

        // 🔹 Aspetta un po' prima di far partire il Tilt, così la corsa è già iniziata
        Thread.sleep(500);

        // 🔹 Scegli un cavallo casuale da interrompere durante la corsa
        Random rand = new Random();
        Cavallo cavalloDaInterrompere = cavalli[rand.nextInt(cavalli.length)];

        System.out.println("\n⚠️ Il cavallo scelto casualmente per essere interrotto è: "
                + cavalloDaInterrompere.getName());

        // 🔹 Avvia il thread Tilt che interromperà il cavallo dopo un tempo casuale
        Thread tilt = new Thread(new Tilt(cavalloDaInterrompere));
        tilt.start();

        // 🔹 Aspetta che tutti i cavalli finiscano o cadano
        for (Cavallo cavallo : cavalli) {
            cavallo.join();
        }

        System.out.println("\n=== RISULTATO FINALE ===");
        for (Cavallo cavallo : cavalli) {
            if (cavallo.isCaduto()) {
                System.out.println("❌ " + cavallo.getName() + " è caduto durante la corsa.");
            } else {
                System.out.println("🏁 " + cavallo.getName() + " ha terminato la corsa!");
            }
        }

        System.out.println("\n🏇 Gara terminata!");
    }
}
