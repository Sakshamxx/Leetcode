import java.util.*;

class Solution {

    class Node {
        int product;
        int[] count;

        Node(int k) {
            product = 1 % k;
            count = new int[k];
        }
    }

    int k;
    Node[] tree;

    public int[] resultArray(int[] nums, int k, int[][] queries) {

        this.k = k;

        int n = nums.length;
        tree = new Node[4 * n];

        build(1, 0, n - 1, nums);

        int[] result = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {

            int index = queries[i][0];
            int value = queries[i][1];
            int start = queries[i][2];
            int x = queries[i][3];

            update(1, 0, n - 1, index, value);

            Node res = query(1, 0, n - 1, start, n - 1);

            result[i] = res.count[x];
        }

        return result;
    }

    private void build(int node, int left, int right, int[] nums) {

        tree[node] = new Node(k);

        if (left == right) {

            int value = nums[left] % k;

            tree[node].product = value;
            tree[node].count[value] = 1;

            return;
        }

        int mid = left + (right - left) / 2;

        build(node * 2, left, mid, nums);
        build(node * 2 + 1, mid + 1, right, nums);

        tree[node] = merge(
            tree[node * 2],
            tree[node * 2 + 1]
        );
    }

    private void update(
        int node,
        int left,
        int right,
        int index,
        int value
    ) {

        if (left == right) {

            value %= k;

            tree[node] = new Node(k);
            tree[node].product = value;
            tree[node].count[value] = 1;

            return;
        }

        int mid = left + (right - left) / 2;

        if (index <= mid) {
            update(node * 2, left, mid, index, value);
        } else {
            update(node * 2 + 1, mid + 1, right, index, value);
        }

        tree[node] = merge(
            tree[node * 2],
            tree[node * 2 + 1]
        );
    }

    private Node query(
        int node,
        int left,
        int right,
        int ql,
        int qr
    ) {

        if (ql <= left && right <= qr) {
            return tree[node];
        }

        int mid = left + (right - left) / 2;

        if (qr <= mid) {
            return query(node * 2, left, mid, ql, qr);
        }

        if (ql > mid) {
            return query(node * 2 + 1, mid + 1, right, ql, qr);
        }

        Node leftNode =
            query(node * 2, left, mid, ql, qr);

        Node rightNode =
            query(node * 2 + 1, mid + 1, right, ql, qr);

        return merge(leftNode, rightNode);
    }

    private Node merge(Node left, Node right) {

        Node result = new Node(k);

        result.product =
            (left.product * right.product) % k;

        for (int r = 0; r < k; r++) {

            result.count[r] += left.count[r];

            int newRemainder =
                (left.product * r) % k;

            result.count[newRemainder] += right.count[r];
        }

        return result;
    }
}