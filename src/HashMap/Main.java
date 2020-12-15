//package HashMap;
//import java.util.*;
//public class Main {
//    public static void Main(String[] args) {
//
//
//
//        HashMap<Integer,String> map = new HashMap<Integer,String>(){{//초기값 지정
//            put(1,"사과");
//            put(3,"바나나");
//            put(2,"포도");
//        }};
//
//        for (Map.Entry<Integer,String> entry:map.entrySet()) {
//            System.out.println(entry.getKey()+" "+entry.getValue());
//        }
//        for (Integer key:map.keySet()) {
//            System.out.println(key+" "+map.get(key));
//        }
//        Comparator<Integer> comparator=(s1,s2)->s1.compareTo(s2);
//        TreeMap<Integer, String> m = new TreeMap<>(comparator);
//        int bound=5;
//        Random random = new Random();
//        m.put(random.nextInt(bound), "js");
//        m.put(random.nextInt(bound), "d");
//        m.put(random.nextInt(bound), "z");
//        m.put(random.nextInt(bound), "b");
//        m.put(random.nextInt(bound), "k");
//
//        List<Integer> keyList = new ArrayList<>(m.keySet());
//
//        for (Integer key : keyList) {
//            System.out.println("Key: " + key +" Entry:"+m.get(key));
//        }
//
//        List<Integer> valueList = new ArrayList<>(m.values());
//        // valueList.sort((s1,s2)->s1.compareTo(s2));
//        for (Integer value : valueList) {
//            System.out.println("Value: " + value);
//        }
//
//
//        Iterator<Map.Entry<Integer,String>> it = map.entrySet().iterator();
//       while (it.hasNext())
//       {
//           Map.Entry<Integer,String> entry= it.next();
//           System.out.println(entry.getKey() +" "+entry.getValue());
//       }
//entrySet().iterator()
//
//        Map<String, Integer> map = new HashMap<String, Integer>();
//        map.put("a", 3);
//        map.put("b", 12);
//        map.put("c", 54);
//        map.put("d", 51);
//        map.put("e", 8);
//        System.out.println("------------sort 전 -------------");
//        Iterator iterator = map.keySet().iterator();
//        while (iterator.hasNext()) {
//            String temp = (String) iterator.next();
//            System.out.println(temp + " = " + map.get(temp));
//        }
//        Iterator it = sortByValue(map).iterator();
//        System.out.println("------------sort 후 -------------");
//        while (it.hasNext()) {
//            String temp = (String) it.next();
//            System.out.println(temp + " = " + map.get(temp));
//        }
//
//    }
//    public static List sortByValue ( final Map map){
//        List<String> list = new ArrayList();
//        list.addAll(map.keySet());
//        Collections.sort(list, new Comparator() {
//            public int compare(Object o1, Object o2) {
//                Object v1 = map.get(o1);
//                Object v2 = map.get(o2);
//                return ((Comparable) v2).compareTo(v1);
//            }
//        });
//        Collections.reverse(list); // 주석시 오름차순
//        return list;
//    }
//
//
//        while(entries.hasNext()){
//            Map.Entry<Integer, String> entry = entries.next();
//            System.out.println("[Key]:" + entry.getKey() + " [Value]:" +  entry.getValue());
//        }
////[Key]:1 [Value]:사과
////[Key]:2 [Value]:바나나
////[Key]:3 [Value]:포도
//
////keySet().iterator()
//        Iterator<Integer> keys = map.keySet().iterator();
//        while(keys.hasNext()){
//            int key = keys.next();
//            System.out.println("[Key]:" + key + " [Value]:" +  map.get(key));
//
//            }
//    }
//
