package Week1;

public class WordPlay {
    public static boolean isVowel(char ch){
        if((int)ch < 97){
            ch += 32;
        }
        if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u'){
            return true;
        }
        return false;
    }

    public static String replaceVowels(String phrase, char ch){
        int n = phrase.length();
        for (int i=0;i<n;i++) {
            char c = phrase.charAt(i);
            if(isVowel(c)){
                phrase = phrase.replace(c,ch);
            }
        }
        return phrase;
    }

    public static String emphasize(String phrase,char ch){
        int n = phrase.length();
        char[] phraseArray = phrase.toCharArray();
        for (int i=0;i<n;i++) {
            char c = phrase.charAt(i);
            if(c < 97){
                c += 32;
            }
            if(c != ch){
                continue;
            }
            else{
                if(i%2==0){
                    phraseArray[i]='*';
                }
                else{
                    phraseArray[i]='+';
                }
            }
        }
        phrase = new String(phraseArray);
        return phrase;
    }

    public static void main(String[] args){
        System.out.println(isVowel('F'));
        System.out.println(isVowel('a'));
        System.out.println(replaceVowels("Hello World",'*'));
        System.out.println(emphasize("dna ctgaaactga", 'a'));
        System.out.println(emphasize("Mary Bella Abracadabra",'a'));
    }
}
