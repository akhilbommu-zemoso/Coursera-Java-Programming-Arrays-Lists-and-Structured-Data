package Week2;

import edu.duke.FileResource;
import java.util.ArrayList;

public class CharactersInPlay {
    private ArrayList<String> characterName = new ArrayList<String>();
    private ArrayList<Integer> characterCount = new ArrayList<Integer>();

    public void update(String person){
        int index = characterName.indexOf(person);
        if (index == -1) {
            characterName.add(person);
            characterCount.add(1);
        }
        else {
            int freq = characterCount.get(index);
            characterCount.set(index,freq+1);
        }
    }

    public void findAllCharacters() {
        characterName.clear();
        characterCount.clear();
        FileResource Resource = new FileResource("src/macbethSmall.txt");
        for (String line: Resource.lines()){
            if (line.contains(".")) {
                int idx = line.indexOf(".");
                String possible_name = line.substring(0,idx);
                update(possible_name);
            }
        }
    }

    public void charactersWithNumParts(int num1, int num2) {
        for (int i=0;i<characterCount.size();i++) {
            if (characterCount.get(i) >= num1 && characterCount.get(i)<= num2) {
                System.out.println( characterName.get(i) +"  "+characterCount.get(i));
            }
        }
    }

    public void tester() {
        findAllCharacters();
        for (int i=0;i<characterCount.size();i++) {
            if (characterCount.get(i) > 1) {
                System.out.println(characterName.get(i) + "  " + characterCount.get(i));
            }
        }
        charactersWithNumParts(1, 3);
    }

    public static void main(String[] args) {
        CharactersInPlay obj = new CharactersInPlay();
        obj.tester();
    }
}
