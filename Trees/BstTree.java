package Trees;

import java.util.*;

public class BstTree {
    Node root;

    public BstTree (int value) {
        this.root = new Node();
        root.value = value;
    }

    public void add (int value) {
        Node node = this.root;
        Node parent = this.root;
        Node newNode = new Node();
        newNode.value = value;

        while (node != null) {
            parent = node;
            if (node.value > value) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        if (parent != null) {
            if (parent.value > value) {
                parent.left = newNode;
            } else {
                parent.right = newNode;
            }
        } else {
            this.root = newNode;
        }
    }

    public void preorder () {
        preorder(this.root);
        System.out.println();
    }

    private void preorder (Node node) {
        if (node == null) return;

        node.displayNode();
        preorder(node.left);
        preorder(node.right);
    }

    public void inorder () {
        inorder(this.root);
        System.out.println();
    }

    private void inorder (Node node) {
        if (node == null ) return;

        inorder(node.left);
        node.displayNode();
        inorder(node.right);
    }

    public void postorder () {
        postorder(this.root);
        System.out.println();
    }

    private void postorder (Node node) {
        if (node == null) return;

        postorder(node.left);
        postorder(node.right);
        node.displayNode();
    }

    public void display () {
        display(this.root, 0);
    }

    private void display(Node node, int height) {
        if (node == null) return;

        display(node.right, height + 2);
        for (int i = 0; i < height; i++) {
            System.out.print(" ");
        }
        System.out.print(node.value);
        display(node.left, height + 2);
        System.out.println();
    }

    public int min () {
        Node node = this.root;
        Node help = this.root;
        while (node != null) {
            help = node;
            node = node.left;
        }
        if (help != null) return help.value;
        return -1;
    }

    public int max () {
        Node node = this.root;
        Node help = this.root;
        while (node != null) {
            help = node;
            node = node.right;
        }
        if (help != null) return help.value;
        return -1;
    }

    public boolean find (int value) {
        Node node = this.root;

        while (node != null) {
            if (node.value == value) {
                return true;
            } else if (value < node.value) {
                node = node.left;
            } else {
                node = node.right;
            }
        }

        return false;
    }

    public void delete (int value) {
        Node node = this.root;
        Node prev = this.root;

        while (node != null) {
            if (node.value == value) {
                break;
            } else if (value < node.value) {
                prev = node;
                node = node.left;
            } else {
                prev = node;
                node = node.right;
            }
        }
        if (node == null) return;

        if (node.right == null && node.left == null) {
            if (prev.right == node) prev.right = null;
            else prev.left = null;
            return;
        }

        if (node.right != null && node.left == null) {
            if (prev.left == node) prev.left = node.right;
            else prev.right = node.right;
            return;
        }

        if (node.right == null && node.left != null) {
            if (prev.left == node) prev.left = node.left;
            else prev.right = node.left;
            return;
        }

        Node nodeCopyTemp = node.right;
        Node nodeCopy = node.right;

        while (nodeCopyTemp != null) {
            nodeCopy = nodeCopyTemp;
            nodeCopyTemp = nodeCopyTemp.left;
        }
        delete(nodeCopy.value);
        node.value = nodeCopy.value;

    }

    public boolean check () {
        return check(this.root, Integer.MIN_VALUE);
    }

    private boolean check(Node root, int prev) {
        if (root == null) {
            return true;
        }
        if (!(check(root.left, prev))) return false;

        if (root.value <= prev) return false;
        System.out.print(root.value + " prev: " + prev + " ");

        prev = root.value;

        System.out.println ("new prev: " + prev);

        return check (root.right, prev);
    }

    public int[] predecessorSuccessor(int val) {
        Node root = this.root; // bierzemy korzen drzewa
        Node pre = null;
        Node suc = null;

        while (root != null) {
            if (root.value == val) { // jezeli natrafilismy juz na wartosc, to szukamy
                if (root.left != null) {
                    pre = root.left; // predecessorem jest node, ktory jest najwiekszym nodem lewego dziecka
                    while (pre.right != null) {
                        pre = pre.right;
                    }
                }

                if (root.right != null) { // succesrorem jest node, ktory jest najmniejszym nodem prawego dziecka
                    suc = root.right;
                    while (suc.left != null) {
                        suc = pre.left;
                    }
                }
                if (pre == null) {
                    return new int[]{-1, suc.value};
                } else if (suc == null) {
                    return new int[]{pre.value, -1};
                }
                return new int[]{pre.value, suc.value};
            } else if (val < root.value) {
                suc = root;
                root = root.left;
            } else {
                pre = root;
                root = root.right;
            }
        }

        if (pre == null) {
            return new int[]{-1, suc.value};
        }
        return new int[]{pre.value, -1};

    }

    class Node {
        public int value;
        public Node left;
        public Node right;

        public void displayNode () {
            System.out.print(this.value + " ");
        }
    }
}
