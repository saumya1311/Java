class TrieNode {
    private TrieNode[] links;
    private final int R = 26;
    private boolean isEnd;

    public TrieNode(){
        links = new TrieNode[26];
    }

    public boolean containsKey(char ch){
        return links[ch - 'a'] != null;
    }

    public TrieNode get(char ch){
        return links[ch - 'a'];
    }

    public void put(char ch, TrieNode node){
        links[ch - 'a'] = node;
    }

    public void setEnd(){
        isEnd = true;
    }

    public boolean isEnd(){
        return isEnd;
    }
}

class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;

        for(int i = 0; i < word.length(); i++){
            char currchar = word.charAt(i);

            if(!node.containsKey(currchar)){
                node.put(currchar, new TrieNode());
            }

            node = node.get(currchar);
        }

        node.setEnd();
    }

    public TrieNode searchPre(String word){
        TrieNode node = root;

        for(int i = 0; i < word.length(); i++){
            char currchar = word.charAt(i);

            if(node.containsKey(currchar)){
                node = node.get(currchar);
            } else {
                return null;
            }
        }

        return node;
    }

    public boolean search(String word) {
        TrieNode node = searchPre(word);
        return node != null && node.isEnd();
    }

    public boolean startsWith(String prefix) {
        TrieNode node = searchPre(prefix);
        return node != null;
    }
}