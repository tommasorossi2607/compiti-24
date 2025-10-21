public class Cavallo extends Thread {



    private int lentezza;
    private boolean caduto = false;

    public Cavallo(String name) {
        super(name); // Passa il nome al costruttore di Thread
    }

    public void setLentezza(int lentezza) {
        this.lentezza = lentezza;
    }

    public int getLentezza() {
        return lentezza;
    }

    public boolean isCaduto() {
        return caduto;
    }

    @Override
    public void run() {
        System.out.println("Cavallo " + getName() + " comincia il suo galoppo con priorità: " + getPriority());

        for (int i = 1; i <= 10; i++) {
            try {
                Thread.sleep(lentezza);
            } catch (InterruptedException e) {
                System.out.println("❌ Cavallo " + getName() + " è caduto e non finisce la corsa!");
                caduto = true;
                return;
            }

            System.out.println(getName() + " cavalca - passo: " + i);
        }

        if (!caduto) {
            System.out.println("🏁 Cavallo " + getName() + " ha finito la corsa!");
        }
    }
}
