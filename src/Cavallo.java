/**
 * Questa classe è il nostro primo thread e consentirà la simulazione di un cavallo
 * in corsa parallelamente con altri della stessa specie
 * @author rossi
 * @version 1.0
 */
public class Cavallo extends Thread {

    private final String name;
    private int lentezza;

    public Cavallo(String name) {
        super();
        this.name = name;
    }

    /**
     * Metodo per impostare la lentezza (in millisecondi)
     */
    public void setLentezza(int lentezza) {
        this.lentezza = lentezza;
    }

    public int getLentezza() {
        return lentezza;
    }

    /**
     * Override del metodo run
     */
    @Override
    public void run() {
        System.out.println("Cavallo " + name + " comincia il suo galoppo con priorità: " + getPriority());

        for (int i = 1; i <= 10; i++) {
            try {
                sleep(lentezza);
            } catch (InterruptedException e) {
                System.out.println("Cavallo " + name + " è stato interrotto.");
            }

            System.out.println(name + " cavalca - passo: " + i);
        }

        System.out.println("Cavallo " + name + " ha finito la corsa!");
    }
}
