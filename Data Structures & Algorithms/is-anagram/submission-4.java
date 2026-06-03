class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] alpha = new int[26];

        for (int i = 0; i < s.length(); i++) {
            int sNum = s.charAt(i) - 'a';
            int tNum = t.charAt(i) - 'a';

            alpha[sNum]++;
            alpha[tNum]--;
        }

        for (int j = 0; j < 26; j++) {
            if (alpha[j] != 0) return false;
        }
        return true;
    }
}
