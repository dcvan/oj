public class Solution {
    public void solve(char[][] board) {
        if (board.length == 0)
            return;
        int M = board.length;
        int N = board[0].length;
        char[][] result = new char[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                result[i][j] = 'X';
            }
        }

        Queue<Node> queue = new LinkedList<Node>();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (i != 0 && j != 0 && i != M - 1 && j != N - 1)
                    continue;
                if (board[i][j] != 'O' || result[i][j] == 'O')
                    continue;
                board[i][j] = 'X';
                result[i][j] = 'O';
                queue.offer(new Node(i, j));
                while (!queue.isEmpty()) {
                    Node node = queue.poll();
                    if (node.x - 1 >= 0 && board[node.x - 1][node.y] == 'O') {
                        board[node.x - 1][node.y] = 'X';
                        result[node.x - 1][node.y] = 'O';
                        queue.offer(new Node(node.x - 1, node.y));
                    }
                    if (node.y - 1 >= 0 && board[node.x][node.y - 1] == 'O') {
                        board[node.x][node.y - 1] = 'X';
                        result[node.x][node.y - 1] = 'O';
                        queue.offer(new Node(node.x, node.y - 1));
                    }
                    if (node.x + 1 < M && board[node.x + 1][node.y] == 'O') {
                        board[node.x + 1][node.y] = 'X';
                        result[node.x + 1][node.y] = 'O';
                        queue.offer(new Node(node.x + 1, node.y));
                    }
                    if (node.y + 1 < N && board[node.x][node.y + 1] == 'O') {
                        board[node.x][node.y + 1] = 'X';
                        result[node.x][node.y + 1] = 'O';
                        queue.offer(new Node(node.x, node.y + 1));
                    }
                }
            }
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = result[i][j];
            }
        }
    }
}

class Node {
    int x;
    int y;
    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}