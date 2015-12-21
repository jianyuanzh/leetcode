package Solution;

/**
 * Created by vincent on 12/21/15.
 */
public class MaxWordProduct {
    public class MaxWordLengthProduct {

        public int maxProduct(String[] words) {
            int[] wordMask = new int[words.length];
            for (int i = 0; i < words.length; i++) {
                wordMask[i] = 0;
            }

            for (int i = 0; i < words.length; i++) {
                String word = words[i];
                for (char c : word.toCharArray()) {
                    wordMask[i] =  wordMask[i] | (1 << (c - 'a'));
                }
            }

            int max = 0;
            for (int i = 0; i < wordMask.length - 1; i++) {
                for (int j = 1; j < wordMask.length; j++) {
                    if ((wordMask[i] !=0) && (wordMask[j] != 0) && (wordMask[i] & wordMask[j]) == 0) {
                        int tmp = words[i].length() * words[j].length();
                        if (max < tmp) {
                            max = tmp;
                        }
                    }
                }
            }

            return max;
        }

        public int maxProduct_timeCosty(String[] words) {

            int product = 0;
            for (int i = 0; i < words.length - 1; i++) {
                for (int j = 1; j < words.length; j++) {
                    if (!shareLetter(words[i], words[j])) {
                        int tmp = words[i].length() * words[j].length();
                        product = product > tmp ? product : tmp;
                    }
                }
            }

            return product;
        }

        private boolean shareLetter(String str1, String str2) {
            boolean str1Longer = str1.length() > str2.length();

            if (str1Longer) {
                for (char c : str2.toCharArray()) {
                    if (str1.contains(c + "")) {
                        return true;
                    }
                }
                return false;
            }
            else {
                for (char c : str1.toCharArray()) {
                    if (str2.contains(c + "")) {
                        return true;
                    }
                }
                return false;
            }

        }
    }
}
