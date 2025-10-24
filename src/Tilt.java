public class Tilt implements Runnable {
    private final Cavallo cavalloDaInterrompere;

    public Tilt(Cavallo cavalloDaInterrompere) {
        this.cavalloDaInterrompere = cavalloDaInterrompere;
    }

    @Override
    public void run() {
        try {
            // Aspetta un tempo casuale breve per interrompere "a metà corsa"
            Thread.sleep(200 + (int)(Math.random() * 600));
        } catch (InterruptedException e) {
            System.out.println("Tilt interrotto prima di agire.");
            return;
        }

        System.out.println("💥 Tilt: interrompo il cavallo " + cavalloDaInterrompere.getName() + "!");
        cavalloDaInterrompere.interrupt();
    }
}
