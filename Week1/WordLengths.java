package Week1;

import edu.duke.FileResource;

public class WordLengths {
    public void countWordLengths(FileResource fileResource, int[] counts){
        int i;
        for (String word:fileResource.words()) {
            i = word.length();
            int length = i;
            if(!Character.isLetter(word.charAt(0))) {
                i -= 1;
            }
            if(!Character.isLetter(word.charAt(length-1))){
                i -= 1;
            }
            counts[i] += 1;
        }
        for(int j=1;j<counts.length;j++){
            System.out.println(j + " " + counts[j]);
        }
    }

    public void testCountWordLengths(){
        FileResource fr = new FileResource("src/smallHamlet.txt");
        int[] counts = new int[31];
        int maxValue = -1,maxIndex = -1;
        countWordLengths(fr,counts);
        for(int i=1;i<31;i++) {
            System.out.print("Words of length ");
            System.out.println(i+ ":" + counts[i]);
            if(counts[i] > maxValue){
                maxValue = counts[i];
                maxIndex = i;
            }
        }
        System.out.println("Index of Max Elements: "+maxIndex);
    }

    public static void main(String[] args) {
        WordLengths obj = new WordLengths();
        obj.testCountWordLengths();
    }
}
