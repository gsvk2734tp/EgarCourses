package ru.example.egar.collections;

import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;

import static java.util.stream.Collectors.toList;

public class checkCollections {
    private final static List<Egar> list = new ArrayList<>();
    private final static List<Egar> list2 = new ArrayList<>();

    /* init collections*/
    static {
        for (int i = 0; i < 100_000; i++) {
            Egar egar = new Egar();
            Egar egar2 = new Egar();
            egar.setName((i + "Egar").intern());
            egar.setSize(i);
            egar.setPhone(("Phone" + i).intern());
            egar2.setName((i + "Egar").intern());
            egar2.setSize(i);
            egar2.setPhone(("Phone" + i).intern());
            list.add(egar);
            list2.add(egar2);
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //Stream API
        long n1 = System.currentTimeMillis();
        int n = check(list, list2).size();
        System.out.println("Stream API time = " + (System.currentTimeMillis() - n1) + " ms");
        System.out.println(n);

        //Stream API parallel
        n1 = System.currentTimeMillis();

        n = check2(list, list2).size();
        System.out.println("Stream API parallel = " + (System.currentTimeMillis() - n1) + " ms");
        System.out.println(n);

        //Iterator and FoEach
        n1 = System.currentTimeMillis();
        n = check3(list, list2).size();
        System.out.println("Iterator and FoEach = " + (System.currentTimeMillis() - n1) + " ms");
        System.out.println(n);

        //ForkJoinPool
        n1 = System.currentTimeMillis();
        n = check4(list, list2).size();
        System.out.println("ForkJoinPool = " + (System.currentTimeMillis() - n1) + " ms");
        System.out.println(n);

        //HashSet
        n1 = System.currentTimeMillis();
        n = check5(list, list2).size();
        System.out.println("HashSet = " + (System.currentTimeMillis() - n1) + " ms");
        System.out.println(n);

        //retainAll
        n1 = System.currentTimeMillis();
        n = check6(list, list2).size();
        System.out.println("retainAll = " + (System.currentTimeMillis() - n1) + " ms");
        System.out.println(n);
    }

    private static List<Egar> check(Collection<Egar> l1, Collection<Egar> l2) {
        return l1.stream().filter(l2::contains).collect(toList());
    }

    private static List<Egar> check2(Collection<Egar> l1, Collection<Egar> l2) {
        return l1.stream().parallel().filter(l2::contains).collect(toList());
    }

    private static List<Egar> check3(Collection<Egar> l1, Collection<Egar> l2) {
        final List<Egar> result = new ArrayList<>();
        for (Egar s : l1) {
            if (l2.contains(s)) result.add(s);
        }
        return result;
    }

    private static List<Egar> check4(Collection<Egar> l1, Collection<Egar> l2) throws ExecutionException, InterruptedException {
        final ForkJoinPool customThreadPool = new ForkJoinPool(10);
        return customThreadPool.submit(() -> l1.parallelStream().filter(l2::contains).collect(toList())).get();
    }

    private static List<Egar> check5(Collection<Egar> l1, Collection<Egar> l2) {
        final Set<Egar> result = new HashSet<>(l1);
        final Set<Egar> result2 = new HashSet<>(l2);
        return result.parallelStream().filter(result2::contains).collect(toList());
    }

    private static Set<Egar> check6(Collection<Egar> l1, Collection<Egar> l2) {
        final Set<Egar> result = new HashSet<>(l1);
        final Set<Egar> result2 = new HashSet<>(l2);
        result.retainAll(result2);
        return result;
    }

}
