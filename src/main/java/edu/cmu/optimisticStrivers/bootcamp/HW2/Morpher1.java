package edu.cmu.optimisticStrivers.bootcamp.HW2;

class Morpher1 {

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

    public static Morph morph(String word) {
        Morph morph = new Morph();
        if (word.charAt(0) == 'u') {
            morph.pos = "V";
            morph = process(morph, word.substring(1));
        } else if (word.charAt(0) == 'y') {
            if (word.charAt(1) == 'u') {
                morph.pos = "ADV";
                morph = process(morph, word.substring(2));
            } else {
                morph.pos = "ADJ";
                morph = process(morph, word.substring(1));
            }
        } else if (word.charAt(0) == 'i' || word.charAt(0) == 'o' || word.charAt(0) == 'e') {
            morph.pos = "PN";
            process(morph, word);
        } else if (word.charAt(0) == 'a') {
            if (word.charAt(1) == 'a') {
                morph.pos = "C";
            } else {
                morph.pos = "R";
            }
            morph.root = word;
        } else {
            morph.pos = "N";
            process(morph, word);
        }
        return morph;
    }

    public static Morph process(Morph morph, String word) {
        switch (word.charAt(word.length() - 1)) {
            case 'u':
                morph.tense = "PAST";
                word = word.substring(0, word.length() - 1);
                break;
            case 'y':
                morph.tense = "FUT";
                word = word.substring(0, word.length() - 1);
                break;
            default:
                morph.tense = "PRES";
        }
        return replace(morph, word);
    }

    public static Morph replace(Morph morph, String word) {
        if (word.contains("i")) {
            morph.gender = "F";
            morph.number = word.contains("ii") ? "P" : "S";
        } else if (word.contains("o")) {
            morph.gender = "M";
            morph.number = word.contains("oo") ? "P" : "S";
        } else {
            morph.gender = "N";
            morph.number = word.contains("ee") ? "P" : "S";
        }
        word = word.replace("ee", "e");
        word = word.replace("ii", "e");
        word = word.replace("oo", "e");
        word = word.replace("i", "e");
        word = word.replace("o", "e");
        morph.root = word;
        return morph;
    }

    public static Morph replaceVowel(Morph morph, String word) {
        if(word.contains("i")){
            morph.gender="F";
            morph.number=word.contains("ii")?"P":"S";
            word=word.replace("ii","e");
            word=word.replace("i","e");
        } else if(word.contains("o")){
            morph.gender="M";
            morph.number=word.contains("oo")?"P":"S";

        } else{
            morph.gender="N";
            morph.number=word.contains("ee")?"P":"S";
            word=word.replace("ee","e");
        }
        morph.root=word;
        return morph;
    }
}