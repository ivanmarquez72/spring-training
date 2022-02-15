import Concurrency2.Synchro;
import concurrency1.*;

import java.util.concurrent.*;

public class Inicio {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        Callable1 cal = new Callable1();

        TimeOuts1 tim = new TimeOuts1();

        InvolkeAll1 inv = new InvolkeAll1();

        InvolkeAny1 inv1 = new InvolkeAny1();

        Scheduled sche = new Scheduled();

        Synchro syn = new Synchro();

        syn.ejemplo();

        syn.ejemplo2();

        syn.incremenSync();



    }
}
