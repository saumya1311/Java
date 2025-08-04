class Solution {
    public String minWindow(String s, String t) {
        if(s.length()==0 || t.length()==0 || s.length()<t.length()) {
            return "";
        }
        
        Map<Character,Integer> mapT=new HashMap<>();
        Map<Character,Integer> mapSubstring= new HashMap<>();

        for(int i=0;i<t.length();i++){
            char c=t.charAt(i);
            mapT.put(c,mapT.getOrDefault(c,0)+1);
        }

        int l=0,r=0;
        int fr=0;
        int [] ans={-1,0,0};

        while(r<s.length()){
            char c=s.charAt(r);
            mapSubstring.put(c, mapSubstring.getOrDefault(c, 0) + 1);

            if(mapT.containsKey(c) && mapSubstring.get(c).intValue()==mapT.get(c).intValue()){
                fr++;
            }

            while(l<=r && fr==mapT.size()){
               // s.charAt(l);

                if(ans[0]==-1 || r-l+1<ans[0]){
                    ans[0]=r-l+1;
                    ans[1]=l;
                    ans[2]=r;
                }
                char ch=s.charAt(l);
                mapSubstring.put(ch,mapSubstring.get(ch)-1);
                if(mapT.containsKey(ch) && mapSubstring.get(ch).intValue()<mapT.get(ch).intValue()){
                    fr--;
                }
                l++;
            }
            r++;
        }
        return ans[0]==-1?"":s.substring(ans[1],ans[2]+1);
    }
}