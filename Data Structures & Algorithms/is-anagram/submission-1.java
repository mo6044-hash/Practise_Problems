class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        HashMap<Character, Integer> sChar = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!sChar.containsKey(s.charAt(i))) {
                sChar.put(s.charAt(i), 1);
            } else {
                int freq = sChar.get(s.charAt(i));
                sChar.put(s.charAt(i), ++freq);
            }
        }

        for (int j = 0; j < s.length(); j++) {
            if (sChar.containsKey(t.charAt(j))) {
                int num = sChar.get(t.charAt(j));
                sChar.put(t.charAt(j), --num);
                if (sChar.get(t.charAt(j)) == 0) {
                    sChar.remove(t.charAt(j));
                }
            } else return false;
        }
        return sChar.isEmpty();
    }
}
