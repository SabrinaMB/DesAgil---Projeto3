package com.desagil.grupo.ponto.fabioferrao;

import java.util.HashMap;
import java.util.LinkedList;

public class Translator {
    // ESTA CLASSE NÃO PODE SER MODIFICADA! (Hashi)
    private class Node {
        private char value;
        private Node parent;
        private Node leftChild;
        private Node rightChild;

        public Node() {
            this.value = ' ';
            this.parent = null;
            this.leftChild = null;
            this.rightChild = null;
        }
        public Node(char value) {
            this.value = value;
            this.parent = null;
            this.leftChild = null;
            this.rightChild = null;
        }

        public char getValue() {
            return value;
        }
        public Node getParent() {
            return parent;
        }
        public void setParent(Node parent) {
            this.parent = parent;
        }
        public Node getLeftChild() {
            return leftChild;
        }
        public void setLeftChild(Node leftChild) {
            this.leftChild = leftChild;
        }
        public Node getRightChild() {
            return rightChild;
        }
        public void setRightChild(Node rightChild) {
            this.rightChild = rightChild;
        }
    }


    // ESTE CONJUNTO DE ATRIBUTOS NÃO PODE SER MODIFICADO, OU
    // SEJA, NÃO É PERMITIDO ADICIONAR NEM REMOVER ATRIBUTOS! (Hashi)
    private Node root;
    private Node node_q;
    private Node node_w;
    private Node node_e;
    private Node node_r;
    private Node node_t;
    private Node node_y;
    private Node node_u;
    private Node node_i;
    private Node node_o;
    private Node node_p;
    private Node node_a;
    private Node node_s;
    private Node node_d;
    private Node node_f;
    private Node node_g;
    private Node node_h;
    private Node node_j;
    private Node node_k;
    private Node node_l;
    private Node node_z;
    private Node node_x;
    private Node node_c;
    private Node node_v;
    private Node node_b;
    private Node node_n;
    private Node node_m;
    private Node node_1;
    private Node node_2;
    private Node node_3;
    private Node node_4;
    private Node node_5;
    private Node node_6;
    private Node node_7;
    private Node node_8;
    private Node node_9;
    private Node node_0;
    private Node node_null0;
    private Node node_null1;
    private Node node_null2;
    private HashMap<Character, Node> map;

    private Node NodeAtual;


    // ESTE CONSTRUTOR DEVE SER PREENCHIDO
    public Translator() {

        // Criando os Nodes
        root = new Node();
        node_q = new Node('q');
        node_w = new Node('w');
        node_e = new Node('e');
        node_r = new Node('r');
        node_t = new Node('t');
        node_y = new Node('y');
        node_u = new Node('u');
        node_i = new Node('i');
        node_o = new Node('o');
        node_p = new Node('p');
        node_a = new Node('a');
        node_s = new Node('s');
        node_d = new Node('d');
        node_f = new Node('f');
        node_g = new Node('g');
        node_h = new Node('h');
        node_j = new Node('j');
        node_k = new Node('k');
        node_l = new Node('l');
        node_z = new Node('z');
        node_x = new Node('x');
        node_c = new Node('c');
        node_v = new Node('v');
        node_b = new Node('b');
        node_n = new Node('n');
        node_m = new Node('m');
        node_0 = new Node('0');
        node_1 = new Node('1');
        node_2 = new Node('2');
        node_3 = new Node('3');
        node_4 = new Node('4');
        node_5 = new Node('5');
        node_6 = new Node('6');
        node_7 = new Node('7');
        node_8 = new Node('8');
        node_9 = new Node('9');
        node_null0 = new Node();
        node_null1 = new Node();
        node_null2 = new Node();


        // Ligando os Nodes finais
        node_5.setParent(node_h);
        node_4.setParent(node_h);
        node_3.setParent(node_v);
        node_f.setParent(node_u);
        node_2.setParent(node_null0);
        node_l.setParent(node_r);
        node_p.setParent(node_w);
        node_1.setParent(node_j);
        node_6.setParent(node_b);
        node_x.setParent(node_d);
        node_c.setParent(node_k);
        node_y.setParent(node_k);
        node_7.setParent(node_z);
        node_q.setParent(node_g);
        node_8.setParent(node_null1);
        node_9.setParent(node_null2);
        node_0.setParent(node_null2);

        node_family(root, node_e, node_t, root);
        // Left Side of Root
        node_family(node_h, node_5, node_4, node_s);
        node_family(node_v, node_v, node_3, node_s);
        node_family(node_null0, node_null0, node_2, node_u);
        node_family(node_r, node_l, node_r, node_a);
        node_family(node_w, node_p, node_j, node_a);
        node_family(node_j, node_j, node_1, node_w);
        node_family(node_s, node_h, node_v, node_i);
        node_family(node_u, node_f, node_null0, node_i);
        node_family(node_i, node_s, node_u, node_e);
        node_family(node_a, node_r, node_w, node_e);
        node_family(node_e, node_i, node_a, root);

        // Right Side of Root
        node_family(node_b, node_6, node_b, node_d);
        node_family(node_d, node_b, node_x, node_n);
        node_family(node_k, node_c, node_y, node_n);
        node_family(node_z, node_7, node_z, node_g);
        node_family(node_g, node_z, node_q, node_m);
        node_family(node_null1, node_8, node_null1, node_o);
        node_family(node_null2, node_9, node_0, node_o);
        node_family(node_o, node_null1, node_null2, node_m);
        node_family(node_d, node_b, node_x, node_n);
        node_family(node_k, node_c, node_y, node_n);
        node_family(node_n, node_d, node_k, node_t);
        node_family(node_m, node_g, node_o, node_t);
        node_family(node_t, node_n, node_m, root);
    }

    private void node_family(Node I, Node left, Node right, Node parent){
        if (right != I) {
            I.setRightChild(right);
        }
        if (left != I) {
            I.setLeftChild(left);
        }
        if (parent != I) {
            I.setParent(parent);
        }
    }


    public char morseToChar(String code) {
        Node NodeNow = root;
        char[] char_array = code.toCharArray();
        for (int i = 0; i < code.length(); i++){
            if (char_array[i] == '.'){
                if (NodeNow.getLeftChild() != null) {
                    NodeNow = NodeNow.getLeftChild();
                } else {
                    return ' ';
                }
            } else if (char_array[i] == '_'){
                if (NodeNow.getRightChild() != null) {
                    NodeNow = NodeNow.getRightChild();
                } else {
                    return ' ';
                }
            }
        }

        return NodeNow.getValue();
    }

    public char[] childs(String code) {
        Node NodeNow = root;
        char[] char_array = code.toCharArray();
        char[] childs = {' ',' '};
        for (int i = 0; i < code.length(); i++){
            if (char_array[i] == '.'){
                if (NodeNow.getLeftChild() != null) NodeNow = NodeNow.getLeftChild();
            } else if (char_array[i] == '_'){
                if (NodeNow.getRightChild() != null) NodeNow = NodeNow.getRightChild();
            }
        }
        if (NodeNow.getLeftChild() != null) childs[0] = NodeNow.getLeftChild().getValue();
        if (NodeNow.getRightChild() != null) childs[1] = NodeNow.getRightChild().getValue();

        return childs;
    }

    public char DownInBranch(char c){
        if (c == '.'){
            NodeAtual = NodeAtual.getLeftChild();

        } else if (c == '_'){
            NodeAtual = NodeAtual.getRightChild();

        }
        return NodeAtual.getValue();
    }

    public char EndChar (){
        char c = NodeAtual.getValue();
        NodeAtual = root;
        return c;
    }

}
