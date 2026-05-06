class Solution {
    Set<Integer> colSet = new HashSet<>();
    Set<Integer> diagonal1Set = new HashSet<>();
    Set<Integer> diagonal2Set = new HashSet<>();
    List<List<String>> result = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }

           
           
        }

         backtrack(0, n, board);
         return result;
    }
        private void backtrack(int row, int n, char[][] board) {
            if (row == n) {
                List<String> copy = new ArrayList<>();

                for (char[] ch : board) {
                    copy.add(new String(ch));
                }
                result.add(copy);
                return;
            }

            for (int i = 0; i < n; i++) {
                if (colSet.contains(i) || diagonal1Set.contains(row + i)
                    || diagonal2Set.contains(row - i)) {
                    continue;
                }
                colSet.add(i);
                diagonal1Set.add(row + i);
                diagonal2Set.add(row - i);
                board[row][i] = 'Q';
                backtrack(row + 1, n, board);
    
                board[row][i] = '.';
                colSet.remove(i);
                diagonal1Set.remove(row + i);
                diagonal2Set.remove(row - i);
            }
        }
    }

