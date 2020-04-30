package Course.inheritance4.hertz;

import java.util.*;

public class MyDemo {
//    cleanString
////            getWords
////    countUniqueWords
////            collectWordCount
////    main

    public static void main(String[] args) {
        List<String> words=getwords("libraryOfBabylon.txt");
        System.out.println(words.size());
        System.out.println(countUniqueWords2(words));
        List<String> targets = new LinkedList <>();
        targets.add("which");
        targets.add("these");
        System.out.println(collectWordCount2(words, targets));
    }
    private static Map<String,Integer> collectWordCount2(List<String> w, List<String> targets){
        Map<String,Integer> targetmap = new HashMap<String,Integer>();
        for(String str: targets){
            targetmap.put(str,0);
        }
        for(String wsep:w){
            if(targetmap.containsKey(wsep)){
                int oldvalue = targetmap.get(wsep);
                targetmap.put(wsep,oldvalue+1);
            }
        }
        return targetmap;
    }
    private static Set<String> countUniqueWords2(List <String> words) {
        Set<String> unique = new HashSet <>();
        for(String srt: words){
            unique.add(srt);
        }
        return unique;
    }

    private static List<String> getwords(String s) {
        In in = new In(s);
        List<String> words = new ArrayList <>();
//        List<String> w = new LinkedList <>();
        while(!in.isEmpty()){
            String nextWord = cleanString2(in.readString());
            words.add(nextWord);
        }
        return words;
    }

    private static String cleanString2(String readString) {
//        return readString.toLowerCase().replaceAll("[^a-z]","");
        return readString;
    }

}
