
class TrieNode {
    Map<Character, TrieNode> children;
    boolean isEnd;

    public TrieNode() {
        children = new HashMap<>();
        isEnd = false;
    }
}

class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            if (!curr.children.containsKey(c)) {
                curr.children.put(c, new TrieNode());
            }
            curr = curr.children.get(c);
        }
        curr.isEnd = true;
    }
}

class Solution {
    List<String> res;

    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        TrieNode root = trie.root;
        res = new ArrayList<>();
        int m = board.length;
        int n = board[0].length;

        for (String word : words) {
            trie.insert(word);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(i, j, root, "", board);
            }
        }

        return res;
    }

    private void dfs(int i, int j, TrieNode node, String path, char[][] board) {
        if (node.isEnd) {
            res.add(path);
            node.isEnd = false; 
        }

        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] == '#') {
            return;
        }

        char temp = board[i][j];
        if (!node.children.containsKey(temp)) {
            return;
        }

        node = node.children.get(temp);
        board[i][j] = '#';  // mark the cell as visited

        dfs(i + 1, j, node, path + temp, board);
        dfs(i - 1, j, node, path + temp, board);
        dfs(i, j + 1, node, path + temp, board);
        dfs(i, j - 1, node, path + temp, board);

        board[i][j] = temp;  // unmark the cell
    }
}
