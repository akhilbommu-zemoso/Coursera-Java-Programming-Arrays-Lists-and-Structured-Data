package Week1;

public class CaesarBreaker {
    public String halfOfString(String message,int start){
        String string="";
        for(int i=start;i<message.length();i+=2) {
            string += message.charAt(i);
        }
        return string;
    }
    public int[] countLetters(String string){
        int[] countsArray = new int[26];
        string = string.toLowerCase();
        for(int i=0;i<string.length();i++) {
            if (Character.isLetter(string.charAt(i))) {
                countsArray[string.charAt(i) - 97] += 1;
            }
        }
        return countsArray;
    }
    public int maxIndex(int[] countsArray){
        int maxValue = Integer.MIN_VALUE;
        int maxValueIndex = -1;
        for(int i=0;i<26;i++){
            if(maxValue < countsArray[i]) {
                maxValue = countsArray[i];
                maxValueIndex = i;
            }
        }
        return maxValueIndex;
    }
    public int getKey(String string){
        int[] countsArray;
        countsArray = countLetters(string);
        int maxValueIndex = maxIndex(countsArray);
        int finalKey = maxValueIndex-4;
        if(finalKey < 0) {
            return 26 + finalKey;
        }
        return finalKey;
    }
    public String decryptTwoKeys(String string){
        String half_string1 = halfOfString(string,0);
        String half_string2 = halfOfString(string,1);
        int key1 = getKey(half_string1);
        int key2 = getKey(half_string2);
        System.out.println("Key1 : "+key1+" Key2 : "+key2);
        return new CaesarCipher().encryptTwoKeys(string,26-key1,26-key2);
    }
    public void testDecrypt() {
        CaesarCipher ceaserCipher = new CaesarCipher();
        String encryptedMessage = ceaserCipher.encrypt("First Legion", 23);
        String decryptedMessage = ceaserCipher.encrypt(encryptedMessage, 26-23);
        System.out.println("Encrypted Message : " + encryptedMessage);
        System.out.println("Decrypted Message : " + decryptedMessage);
        System.out.println(halfOfString("Qbkm Zgis",0));
        System.out.println(getKey("Ranaaadheeer"));
        System.out.println(decryptTwoKeys("Xifqvximt tsdtlxzrx iijirvtl ek Uybi afvbw yehvv xyi gfqdse iekmfrrpzdrxzse fj xyi jzich sw tsdtlxrxzseec xifqvxic, fjkie xmmie zr xyi trwk, xyek klv nsipu rvfyeh yj zw xyvvi-hzqvrjmfrrp eeh ulijxzsew lfa xymekj zr xymj nsipu iiceki xf vetl sklvv eii melvvvrkpp xifqvximt. Xrov dsmmek e tzees xyvfyxl e hfsi-wvrqv rru gprremek e jcmxlk-gekl xyek rzfmuw gfpcmjmfrj nmkl sklvv ezvgprrvw ej kaf vbrqgpvw. Zx wyslpu klvvvjfvv esk jyitimji xyek tsdtlxzrx gvftvvkmvw esslx xyiji kvsdikvzg xymekj rru klvmi zrkiietxzse rvv tsdqfr-tceti eeh mdtfvkeex. Nlzpv klzw mj jxzpc r mecmu rvxydiex, ni afych pzov ks edieh xyek dsjx sw klv xifqvximt hyvwkmfrj giftci gfrtiir xyidwvpmij nmkl lrzv ks hf nmkl lfa xymekj rvv tservgkiu. Mk zw mdtfvkeex xyek ymxlnepw eii wljwmtmvrkpp jxiezkyx eeh wdsfxy ks wltgsix xyi himmmek sw wejx grvj, flx eesklvv ijwvrkmrp tisgiixp, aymtl av lwlecpp kebi jfv kieexvh, zw xyek ymxlnepw eii gfrkmeyfyj, mehviu tservgkmek E xf S, eeh rfx nlwk rtgvfbzqrxvpp. Xyi gfviijtfrumek wlfwmvpu fj gfqgykekmfrrp kvsdikvp zw swxvr vvjvviiu ks ej tsdtlxrxzseec ksgscsxc. R xsfh tfvkmfr sw fyi vjwsixj dep si gcejwzjziu ks fvpfrx ks xymj jysjzich eeh eii himmie sc egtcmtekmfrj zr e zrvzikc sw fxyii wmvpuw, klv gvvhzgkmfr sw klv jxiytxlvv fj jfpuiu gvfxvmew eeh xyi vvgfrjxiytxzse fj llqrr sikrrj sizrx kaf. Xyi lrpcqrvb fj slv afvb zw jrwk rpxsimkldw xyek zqgpvqvrk deklvqrxzgrp qfhvpj ks swjvv mewzkyxj zrks eeh eewniiw xf jytl ulijxzsew.\n"));
    }
    public static void main(String[] args) {
        CaesarBreaker obj = new CaesarBreaker();
        obj.testDecrypt();
    }
}
