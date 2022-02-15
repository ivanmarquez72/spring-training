package Set1;

public class MainSet {
    
        //HashSet
        /*
        Set.Producto m = new Set.Producto("Pan", 6);
        Set.Producto n = new Set.Producto("Leche", 2);
        Set.Producto o = new Set.Producto("Manzanas", 5);
        Set.Producto p = new Set.Producto("Brocoli", 2);
        Set.Producto q = new Set.Producto("Carne", 2);

        HashSet<Set.Producto> mandado = new HashSet();
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
        /*
        Pan : 6
        Carne : 2
        Manzanas : 5
        Leche : 2
        Brocoli : 2


        for(Iterator it = mandado.iterator(); it.hasNext();) {
            Set.Producto x = (Set.Producto)it.next();
            System.out.println(x.nombre + " : " + x.cantidad);
        }

        // No es posible eliminar elementos por indice
        // Un HashSet no ofrece este mecanismo, solo eliminación por valor de Objeto

        // Eliminar todos los valores del ArrayList
        mandado.clear();
        System.out.println(" - Lista de mandado final con " + mandado.size() + " elementos");

        System.out.println();
        System.out.println("------------------");
        */
        /*
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
        for(int x: al) {
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

        /*Map<String, Integer> map = new HashMap<>();
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

        Map<Integer, String> map = new HashMap<Integer, String>();
        map.put(1, "Casillas");
        map.put(15, "Ramos");
        map.put(3, "Pique");
        map.put(5, "Puyol");
        map.put(11, "Capdevila");
        map.put(14, "Xabi Alonso");
        map.put(16, "Busquets");
        map.put(8, "Xavi Hernandez");
        map.put(18, "Pedrito");
        map.put(6, "Iniesta");
        map.put(7, "Villa");

        Iterator it = map.keySet().iterator();
        while(it.hasNext()){
            Integer key = (Integer) it.next();
            System.out.println("Clave: " + key + " -> Valor: " + map.get(key));
        }

        System.out.println();

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
        it = treeMap.keySet().iterator();
        while(it.hasNext()){
            Integer key = (Integer) it.next();
            System.out.println("Clave: " + key + " -> Valor: " + treeMap.get(key));
        }


        List<String> list = new ArrayList<String>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        list.add("f");

        System.out.println("Tamaño de lista: " + list.size());
        System.out.println(list.get(3));

        */

        //Set
        /*
        Set.Producto m = new Set.Producto("Pan", 6);
        Set.Producto n = new Set.Producto("Leche", 2);
        Set.Producto o = new Set.Producto("Manzanas", 5);
        Set.Producto p = new Set.Producto("Brocoli", 2);
        Set.Producto q = new Set.Producto("Carne", 2);
        Set.Producto r = new Set.Producto("Fresas", 2);
        Set.Producto s = new Set.Producto("Mango", 2);
        Set.Producto t = new Set.Producto("Zanahorias", 2);
        Set.Producto u = new Set.Producto("Elotes", 2);

        System.out.println("------TreeSet--------");
        Set<Set.Producto> mandado = new TreeSet<>();
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

        for(Iterator it = mandado.iterator(); it.hasNext();) {
            Set.Producto x = (Set.Producto)it.next();
            System.out.println(x.nombre + " : " + x.cantidad);
        }
        mandado.clear();
        System.out.println(" - Lista de mandado con " + mandado.size() + " elementos");
        System.out.println();

        System.out.println("-----HashSet------");
        mandado = new HashSet<>();
        mandado.add(m);
        mandado.add(n);
        mandado.add(o);
        mandado.add(p);
        mandado.add(q);
        mandado.add(r);
        mandado.add(s);
        mandado.add(t);
        mandado.add(u);

        System.out.println(" - Lista de mandado con " + mandado.size() + " elementos");

        for(Iterator it = mandado.iterator(); it.hasNext();) {
            Set.Producto x = (Set.Producto)it.next();
            System.out.println(x.nombre + " : " + x.cantidad);
        }
        mandado.clear();
        System.out.println(" - Lista de mandado con " + mandado.size() + " elementos");
        System.out.println();

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
            Set.Producto x = (Set.Producto)it.next();
            System.out.println(x.nombre + " : " + x.cantidad);
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
            Set.Producto x = (Set.Producto)it.next();
            System.out.println(x.nombre + " : " + x.cantidad);
        }

        System.out.println("Removemos: " + mandado.remove(q) );

        System.out.println(" - Lista de mandado con " + mandado.size() + " elementos");
        System.out.println("------LinkedHashset dewspues de remover");

        for(Iterator it = mandado.iterator(); it.hasNext();) {
            Set.Producto x = (Set.Producto)it.next();
            System.out.println(x.nombre + " : " + x.cantidad);
        }

        System.out.println("Removemos: " + mandado.remove(q) );
        */
    
}
