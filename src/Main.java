import java.util.Scanner;


public class Main {


    /**punto di inizio dell'applicazione
     * thread padre
     */
public static void main(String[] args){

    Scanner input = new Scanner(System.in);

Cavallo fulmine= new Cavallo("Fulmine");
Cavallo lampo= new Cavallo("Lampo");
Cavallo rose = new Cavallo("Rose");
Cavallo astra = new Cavallo("Astra");
Cavallo rambo= new Cavallo("Rambo");


//rose.setPriority(Thread.MIN_PRIORITY);
//astra.setPriority(Thread.MAX_PRIORITY);

System.out.println("Inserisci la lentezza di fulmine");
int tmp=input.nextInt();
fulmine.setLentezza(tmp);



    System.out.println("Inserisci la lentezza di lampo");
    tmp=input.nextInt();
    lampo.setLentezza(tmp);


    System.out.println("Inserisci la lentezza di rose");
   tmp=input.nextInt();
    rose.setLentezza(tmp);


    System.out.println("Inserisci la lentezza di astra");
    tmp=input.nextInt();
    astra.setLentezza(tmp);

    System.out.println("Inserisci la lentezza di rambo");
    tmp=input.nextInt();
    rambo.setLentezza(tmp);

    fulmine.start();
    lampo.start();
    rose.start();
    astra.start();
    rambo.start();

    }
}