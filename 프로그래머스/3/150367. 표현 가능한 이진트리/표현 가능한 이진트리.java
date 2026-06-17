class Solution {
    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];

        for (int i = 0; i < numbers.length; i++)
            answer[i] = validate(numbers[i]) ? 1 : 0;

        return answer;
    }

    private boolean validate(long number) {
        // 입력 값을 이진수로 전환
        String tree = Long.toBinaryString(number);

        // 완전이진트리일 경우, 포화이진트리로 수정
        int treeSize = 1;
        int i = 1;
        StringBuilder dummyNodes = new StringBuilder();
        
        while (treeSize < tree.length()) treeSize += Math.pow(2, i++);
        for (int j = 0; j < treeSize - tree.length(); j++) dummyNodes.append('0');
        tree = dummyNodes.toString() + tree;
        
        return preOrder(0, tree.length() - 1, tree);
    }

    private boolean preOrder(int l, int r, String tree) {
        int mid = (l + r) / 2;
        
        // 리프 노드 도달
        if (l == r) return true;

        // 더미 노드 아래에 진짜 노드가 있을 경우
        if (tree.charAt(mid) == '0') {
            char nextRNode = tree.charAt((l + mid - 1) / 2);
            char nexLRNode = tree.charAt((mid + 1 + r) / 2);
            if (nextRNode == '1' || nexLRNode == '1') return false;
        }

        return preOrder(l, mid - 1, tree) && preOrder(mid + 1, r, tree);
    }
} 
