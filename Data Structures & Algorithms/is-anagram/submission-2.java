class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> sMap = new HashMap<>();
        HashMap<Character, Integer> tMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (sMap.containsKey(s.charAt(i))) {
                int val = sMap.get(s.charAt(i));
                val++;
                sMap.put(s.charAt(i), val);
            }
            else sMap.put(s.charAt(i), 1);
        }
        for (int j = 0; j < t.length(); j++) {
            if (tMap.containsKey(t.charAt(j))) {
                int k = tMap.get(t.charAt(j));
                k++;
                tMap.put(t.charAt(j), k);
            }
            else tMap.put(t.charAt(j), 1);
        }

        return sMap.equals(tMap);
    }
}
