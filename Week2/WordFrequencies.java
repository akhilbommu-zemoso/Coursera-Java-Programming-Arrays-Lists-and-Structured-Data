package Week2;

import edu.duke.FileResource;
import java.util.ArrayList;

public class WordFrequencies {
    private final ArrayList<String> myWords;
    private final ArrayList<Integer> myFreqs;
    WordFrequencies(){
        myWords = new ArrayList<>();
        myFreqs = new ArrayList<>();
    }
    public void findUnique(){
        myWords.clear();
        myFreqs.clear();
        FileResource fileResource = new FileResource("src/testwordfreqs.txt");
        for (String word : fileResource.words()) {
            word = word.toLowerCase();
            if(!myWords.contains(word)) {
                myWords.add(word);
            }
        }

        for (String myWord : myWords) {
            int count = 0;
            for (String word : fileResource.words()) {
                word = word.toLowerCase();
                if (word.equals(myWord))
                    count += 1;
            }
            myFreqs.add(count);
        }
    }
    public int findIndexOfMax(){
        int max = -1,maxValueIndex=-1;
        for(int i=0;i<myFreqs.size();i++){
            if(max < myFreqs.get(i)){
                max = myFreqs.get(i);
                maxValueIndex = i;
            }
        }
        return maxValueIndex;
    }
    public void tester(){
        findUnique();
        System.out.println("Number of unique words: " + myWords.size());
        for(int i=0;i<myWords.size();i++){
            System.out.println(myFreqs.get(i)+" "+myWords.get(i));
        }
        int index = findIndexOfMax();
        System.out.println("The word that occurs most often and its count are : " + myWords.get(index) + " " + myFreqs.get(index));
    }
    public static void main(String[] args) {
        WordFrequencies obj = new WordFrequencies();
        obj.tester();
    }
}
