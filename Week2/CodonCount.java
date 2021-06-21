package Week2;

import java.util.HashMap;

public class CodonCount {
    private HashMap<String ,Integer> hm;
    CodonCount(){
        hm = new HashMap<>();
    }

    public void buildCodonMap(int start,String dna){
        hm.clear();
        for(int i=start;i<dna.length()-3;i+=3){
            String codon = dna.substring(i,i+3);
            int count = 1;
            if(hm.containsKey(codon)) {
                hm.replace(codon, count, count + 1);
            } else {
                hm.put(codon, count);
            }
        }
    }

    public String getMostCommonCodon(){
        String mostCommonCodon = "";
        int mostCommonCodonValue = Integer.MIN_VALUE;
        for (String string:hm.keySet()) {
            int value = hm.get(string);
            if(value > mostCommonCodonValue){
                mostCommonCodonValue = value;
                mostCommonCodon = string;
            }
        }
        return mostCommonCodon;
    }

    public void printCodonCounts(int start,int end){
        System.out.println("Counts of codons between "+start+" and "+end+" inclusive are:" );
        for(String string:hm.keySet()){
            int value = hm.get(string);
            if(value >= start && value <= end) {
                System.out.println(string + " " + value);
            }
        }
    }
    public static void main(String[] args) {
        CodonCount obj = new CodonCount();
        obj.buildCodonMap(0,"CGTTCAAGTTCAA");
        System.out.println(obj.getMostCommonCodon());
        obj.printCodonCounts(1,5);
    }
}
