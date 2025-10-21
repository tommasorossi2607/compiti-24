public class Tilt implements Runnable {

    private final Cavallo cavalloDaInterrompere;


    public Tilt(Cavallo cavalloDaInterrompere) {
        this.cavalloDaInterrompere = cavalloDaInterrompere;
    }

    @Override
    public void run() {
        try {
            // Attende tra 0.5 e 1.5 secondi prima di interrompere
            Thread.sleep(500 + (int)(Math.random() * 1000));
        } catch (InterruptedException e) {
            System.out.println("Tilt interrotto.");
        }

        System.out.println("⚠️ Interrompendo il cavallo " + cavalloDaInterrompere.getName());
        cavalloDaInterrompere.interrupt(); // ✅ ora la variabile è riconosciuta
    }
}
