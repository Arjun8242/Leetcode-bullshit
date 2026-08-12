class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> list=new ArrayList<>();
        HashMap<String, Integer> map=new HashMap<>();

        for(int i=0;i<=s.length()-10;i++){
            map.put(s.substring(i, i+10), map.getOrDefault(s.substring(i, i+10), 0)+1);

            if(map.get(s.substring(i, i+10))==2){
                list.add(s.substring(i, i+10));
            }
        }
        return list;

    }
}