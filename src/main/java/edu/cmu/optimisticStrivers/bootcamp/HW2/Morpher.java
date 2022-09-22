package edu.cmu.optimisticStrivers.bootcamp.HW2;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName: Morpher
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/9/9 1:37 PM
 * @Version 1.0
 */

public class Morpher {
    public static class Morph {
        String root;
        String pos;
        String tense;
        String number;
        String gender;

        public Morph() {
        }

        public Morph(String root_word) {
            root = root_word;
        }

        @Override
        public String toString() {
            return root + "+" + pos + "-" + tense + "-" + number + "-" + gender;
        }
    }


    public static void main(String[] args) {
//        System.out.println(morph("uroory")); // 1
//        System.out.println(morph("iicle")); //1
//        System.out.println(morph("yclept")); // ???
//        System.out.println(morph("yclepty")); // 1
//        System.out.println(morph("yclept")); //
        System.out.println(morph("ycloptu")); //


    }


    public static Morph morph(String word) {
        String pos = "";
//        Tense, gender, and number are not used if the part of speech is preposition or conjunction.
        String tense = "";
        String gender = "";
        String number = "";
        String root = "";
        Set<String> vowels = new HashSet<String>(List.of(new String[]{"a", "e", "i", "o", "u"})) {
        };

        String reg = "^(a{1,2}|yu|[uyaeui]|[a-z])(.*)(u|y|[a-z])$";
        Pattern pattern = Pattern.compile(reg);


        Map<String, String> posMap = new HashMap<String, String>() {{
            put("u", "V");
            put("y", "ADJ");
            put("yu", "ADV");
            put("a", "R");
            put("aa", "C");
            put("e", "PN");
            put("i", "PN");
            put("o", "PN");
        }};
        Map<String, String> tenseMap = new HashMap<String, String>() {{
            put("y", "FUT");
            put("u", "PAST");
        }};

        Map<String, String> genderMap = new HashMap<>() {{
            put("e", "N"); //neuter
            put("i", "F"); //feminine
            put("o", "M"); //masculine
        }};

        Matcher matcher = pattern.matcher(word);
        if (matcher.find()) {
            //POS
            String prefix = matcher.group(1);
            if (posMap.containsKey(prefix)) {
                pos = posMap.get(prefix);
            } else {
                pos = "N";
            }
            //TENSE
            String suffix = matcher.group(3);
            if (tenseMap.containsKey(suffix)) {
                tense = tenseMap.get(suffix);
            } else {
                tense = "PRES";
            }

            String stem = "";
//            The stem always starts and ends with a consonant (letter other than 'a', 'e', 'i', 'o', or 'u').
            for (int i = 0; i < word.length(); i++) {
                if (!vowels.contains(String.valueOf(word.charAt(i)))) {
                    stem += word.charAt(i);
                    for (int j = i + 1; j < word.length(); j++) {
                        stem += word.charAt(j);
                        if (!vowels.contains(String.valueOf(word.charAt(i)))) {
                            break;
                        }
                    }
                    break;
                }
            }

//            if(pos.equals("ADV") || pos.equals("ADJ")) stem = matcher.group(2)+matcher.group(3);
            if (!tenseMap.containsKey(suffix)) stem = stem + matcher.group(3);
            if (pos.equals("PN"))
//                stem = matcher.group(1) + matcher.group(2);  //这句很关键 因为Pronoun的stem 还是 root 但是 没有suffix
                stem = suffix + stem;// ???
            if (pos.equals("PN")) { //如果是一个 pronoun 代词
                gender = genderMap.get(prefix);
            } else {
                for (int i = 0; i < stem.length(); i++) {  //这里也可以正则去找
                    if (genderMap.containsKey(String.valueOf(stem.charAt(i)))) {
                        gender = genderMap.get(String.valueOf(stem.charAt(i)));
                        break;
                    }
                }
            }

            for (int i = 0; i < stem.length(); i++) {  //这里也可以正则去找
                if (vowels.contains(String.valueOf(stem.charAt(i)))) {
                    if (i + 1 < stem.length() && stem.charAt(i + 1) == stem.charAt(i)) {
                        number = "P";
                    } else {
                        number = "S";
                    }
                    break;
                }
            }

            //root
            if (pos.equals("R") || pos.equals("C")) {
                root = word;
                tense = "";
                gender = "";
                number = "";
                //所以 只有 root 和 POS
            } else if (pos.equals("PN")) {  //pronouns
                if (word.length() > 1 && word.charAt(0) == word.charAt(1)) {
                    root = "e" + word.substring(2); //跳过1
                } else {
                    root = "e" + word.substring(1);
                }
            } else {
                System.out.println("stem  : " + stem);
                for (int i = 0; i < stem.length(); i++) {
                    if (genderMap.containsKey(String.valueOf(stem.charAt(i)))) { //vowels也可以
                        if (i + 1 < stem.length() && stem.charAt(i) == stem.charAt(i + 1)) {
                            root += "e";
                            i = i + 1; //???? i+2
                            continue;
                        } else {
                            root += "e";
                            i = i + 1;
                        }
                    }
                    System.out.println(stem.charAt(i));
                    root += stem.charAt(i);
                }
            }
        }

        Morph morph = new Morph();
        morph.root = root;
        morph.pos = pos;
        if (!(pos.equals("R") || pos.equals("C"))) {
            morph.tense = tense;
            morph.gender = gender;
            morph.number = number;
        }

        return morph;

    }


}

