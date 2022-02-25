package mx.com.digitalchallengers.setejercicio;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class HashSetEjercicio {
    Set<Producto> mandado = new TreeSet<>();
    Producto m = new Producto("Pan", 6);
    Producto n = new Producto("Leche", 2);
    Producto o = new Producto("Manzanas", 5);
    Producto p = new Producto("Brocoli", 2);
    Producto q = new Producto("Carne", 2);
    Producto r = new Producto("Fresas", 2);
    Producto s = new Producto("Mango", 2);
    Producto t = new Producto("Zanahorias", 2);
    Producto u = new Producto("Elotes", 2);

    public HashSetEjercicio() {
    }

    public void mandadoHashSet() {
        HashSet<Producto> mandado = new HashSet();
        mandado.add(m);
        mandado.add(n);
        mandado.add(o);
        mandado.add(p);
        mandado.add(q);
        // Doble inserción de Objeto/referencia q
        mandado.add(q);
        //mandado.stream().sorted();
        // Imprimir contenido de HashSet
        // Aunque son insertados 6 elementos, el HashSet solo contiene 5
        // Lo anterior se debe a que un Set no permite elementos duplicados (q)
        System.out.println(" - Lista de mandado con " + mandado.size() + " elementos");
        System.out.println();
        // Definir Iterator para extraer/imprimir valores
        //List<Set.Producto> sortMandado = new ArrayList<Set.Producto>(mandado);
        //mandado.stream().sorted();

        for (Iterator it = mandado.iterator(); it.hasNext(); ) {
            Producto x = (Producto) it.next();
            System.out.println(x.getNombre() + " : " + x.getCantidad());
        }
        // No es posible eliminar elementos por indice
        // Un HashSet no ofrece este mecanismo, solo eliminación por valor de Objeto
        // Eliminar todos los valores del ArrayList
        mandado.clear();
        System.out.println(" - Lista de mandado final con " + mandado.size() + " elementos");
        System.out.println();
        System.out.println("------------------");
    }

    public void ordenerSetNumeros() {
        HashSet<Integer> number = new HashSet<>();
        // Using add() method
        number.add(6);
        number.forEach(System.out::println);
        System.out.println();
        number.add(3);
        number.forEach(System.out::println);
        System.out.println();
        number.add(4);
        number.forEach(System.out::println);
        System.out.println();
        for (int x : number) {
            System.out.print(x + " ");
        }
        // converting HashSet to arraylist
        ArrayList<Integer> al = new ArrayList<>(number);
        // sorting the list and then printing
        Collections.sort(al);
        System.out.println();
        System.out.println("Sorted list: ");
        for (int x : al) {
            System.out.print(x + " ");
        }
        System.out.println();
        HashSet<Integer> hs = new HashSet<>();
        System.out.println("---------");
        // Using add() method to add elements to hs
        hs.add(20);
        hs.add(4);
        hs.add(15);
        // before sorting hs
        hs.forEach(System.out::println);
        System.out.println(); // extra line
        // after sorting hs
        hs.stream().sorted().forEach(System.out::println); // yes
        System.out.println("-------------");
    }

    public void ordnerTreeSetNumeros() {
        HashSet<Integer> number2 = new HashSet<>();
        // Using add() method
        number2.add(3);
        number2.forEach(System.out::println);
        System.out.println();
        number2.add(6);
        number2.forEach(System.out::println);
        System.out.println();
        number2.add(4);
        number2.forEach(System.out::println);
        // TreeSet gets the value of hashSet
        TreeSet myTreeSet = new TreeSet();
        myTreeSet.addAll(number2);
        System.out.println(myTreeSet);
        System.out.println();
        System.out.println("-------------");
        System.out.println();
    }

    public void productoTreeSet() {
        System.out.println("------TreeSet--------");

        mandado.add(m);
        mandado.add(n);
        mandado.add(o);
        mandado.add(p);
        mandado.add(q);
        mandado.add(r);
        mandado.add(s);
        mandado.add(t);
        mandado.add(u);
        // Doble inserción de Objeto/referencia q
        mandado.add(q);
        System.out.println(" - Lista de mandado con " + mandado.size() + " elementos");
        for (Iterator it = mandado.iterator(); it.hasNext(); ) {
            Producto x = (Producto) it.next();
            System.out.println(x.getNombre() + " : " + x.getCantidad());
        }
    }

    public void productoHashSet() {
        System.out.println("-----HashSet------");
        mandado =new HashSet<>();
        mandado.add(m);
        mandado.add(n);
        mandado.add(o);
        mandado.add(p);
        mandado.add(q);
        mandado.add(r);
        mandado.add(s);
        mandado.add(t);
        mandado.add(u);
        System.out.println(" - Lista de mandado con "+mandado.size()+" elementos");
        for(
        Iterator it = mandado.iterator(); it.hasNext();)

        {
        Producto x = (Producto) it.next();
        System.out.println(x.getNombre() + " : " + x.getCantidad());
    }
        mandado.clear();
        System.out.println(" - Lista de mandado con "+mandado.size()+" elementos");
        System.out.println();


    }

    public void productoLinkedSet() {
        System.out.println("-----LinkedhashSet-------");
        mandado = new LinkedHashSet<>();
        mandado.add(m);
        mandado.add(n);
        mandado.add(o);
        mandado.add(p);
        mandado.add(q);
        mandado.add(q);
        System.out.println(" - Lista de mandado con " + mandado.size() + " elementos");
        for(Iterator it = mandado.iterator(); it.hasNext();) {
            Producto x = (Producto)it.next();
            System.out.println(x.getNombre() + " : " + x.getCantidad());
        }
        mandado.clear();
        System.out.println(mandado.isEmpty());

        System.out.println("-----LinkedhashSet Diferente Orden-------");
        mandado.add(r);
        mandado.add(s);
        mandado.add(q);
        mandado.add(t);
        mandado.add(m);
        mandado.add(n);
        mandado.add(o);
        mandado.add(u);
        System.out.println(" - Lista de mandado con " + mandado.size() + " elementos");
        for(Iterator it = mandado.iterator(); it.hasNext();) {
            Producto x = (Producto)it.next();
            System.out.println(x.getNombre() + " : " + x.getCantidad());
        }
        System.out.println("Removemos: " + mandado.remove(q) );
        System.out.println(" - Lista de mandado con " + mandado.size() + " elementos");
        System.out.println("------LinkedHashset dewspues de remover");
        for(Iterator it = mandado.iterator(); it.hasNext();) {
            Producto x = (Producto)it.next();
            System.out.println(x.getNombre() + " : " + x.getCantidad());
        }
        System.out.println("Removemos: " + mandado.remove(q) );
    }

    public void futbolMap(){
        Map<String, Integer> map = new HashMap<>();
        //llave - valor
        map.put("One", 1);
        map.put("Two", 2);
        map.put("Three", 3);
        System.out.println(map);
        System.out.println(map);
        map.clear();
        HashMap<String, Integer> map2 = new HashMap<>();
        map2.put("One", 1);
        map2.put("Two", 2);
        map2.put("Three", 3);
        //System.out.println(map);

        Map<Integer, String> map3 = new HashMap<Integer, String>();
        map3.put(1, "Casillas");
        map3.put(15, "Ramos");
        map3.put(3, "Pique");
        map3.put(5, "Puyol");
        map3.put(11, "Capdevila");
        map3.put(14, "Xabi Alonso");
        map3.put(16, "Busquets");
        map3.put(8, "Xavi Hernandez");
        map3.put(18, "Pedrito");
        map3.put(6, "Iniesta");
        map3.put(7, "Villa");
        Iterator it = map3.keySet().iterator();
        while(it.hasNext()){
            Integer key = (Integer) it.next();
            System.out.println("Clave: " + key + " -> Valor: " + map.get(key));
        }
    }

    public void futbolTree(){
        Map<Integer, String> treeMap = new TreeMap<Integer, String>();
        treeMap.put(1, "Casillas");
        treeMap.put(15, "Ramos");
        treeMap.put(3, "Pique");
        treeMap.put(5, "Puyol");
        treeMap.put(11, "Capdevila");
        treeMap.put(14, "Xabi Alonso");
        treeMap.put(16, "Busquets");
        treeMap.put(8, "Xavi Hernandez");
        treeMap.put(18, "Pedrito");
        treeMap.put(6, "Iniesta");
        treeMap.put(7, "Villa");
        // Imprimimos el Map con un Iterador que ya hemos instanciado anteriormente
        Iterator it = treeMap.keySet().iterator();
        while(it.hasNext()){
            Integer key = (Integer) it.next();
            System.out.println("Clave: " + key + " -> Valor: " + treeMap.get(key));
        }
    }
}
