class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            int val = 1;
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                val = map.get(c);
                val++;
            }
            map.put(c, val);
        }

        for (int j = 0; j < t.length(); j++) {
            char b = t.charAt(j);
            if (!map.containsKey(b)) {return false;}
            else {
                int k = map.get(b);
                k--;
                map.put(b, k);
                if (k < 0) return false;
            }
        }
        return true;
    }
}
