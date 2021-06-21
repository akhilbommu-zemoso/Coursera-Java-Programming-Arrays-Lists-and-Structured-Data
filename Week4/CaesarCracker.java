package Week4;

public class CaesarCracker {
    char mostCommon;
    public CaesarCracker() {
        mostCommon = 'e';
    }
    public CaesarCracker(char c) {
        mostCommon = c;
    }

    public int[] countLetters(String message){
        String alphabets = "abcdefghijklmnopqrstuvwxyz";
        int[] frequencies = new int[26];
        for(int i=0; i < message.length(); i++){
            int ind = alphabets.indexOf(Character.toLowerCase(message.charAt(i)));
            if (ind != -1){
                frequencies[ind] += 1;
            }
        }
        return frequencies;
    }

    public int maxIndex(int[] vals){
        int maxInd = 0;
        for(int i=0;i<vals.length;i++){
            if (vals[i] > vals[maxInd]){
                maxInd = i;
            }
        }
        return maxInd;
    }

    public int getKey(String encrypted) {
        int[] frequencies = countLetters(encrypted);
        int maxInd = maxIndex(frequencies);
        int mostCommonPos = mostCommon - 'a';
        int dkey = maxInd - mostCommonPos;
        if (maxInd < mostCommonPos) {
            dkey = 26 - (mostCommonPos - maxInd);
        }
        return dkey;
    }
}
