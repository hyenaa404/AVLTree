/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author nhsuonggggggg
 * @param <T>
 */
public class AVLTree<T extends Comparable<T>> {

    AVLNode root;

    public AVLTree() {
        root = null;
    }

    public int height(AVLNode n) {
        if (n == null) {
            return 0;
        }

        return n.getHeight();
    }

    public int max(int a, int b) {
        return (a > b) ? a : b;
    }

    AVLNode rightRotate(AVLNode father) {   // rorate with left child

        AVLNode leftChild = father.getLeft();
        father.setLeft(leftChild.getRight());

        if (father.getLeft() != null) {
            father.getLeft().setParent(father);
        }
        leftChild.setRight(father);
        father.setParent(leftChild);

        return leftChild;
    }

    AVLNode leftRotate(AVLNode father) {   // rorate with right child
        AVLNode rightChild = father.getRight();
        father.setRight(rightChild.getLeft());

        if (father.getRight() != null) {
            father.getRight().setParent(father);
        }

        rightChild.setLeft(father);
        father.setParent(rightChild);

        
        return rightChild;
    }

    public AVLNode doubleRotateLeftRight(AVLNode father) {   // left rotate child, right rotate node    (rotate with left child)
        AVLNode a = leftRotate(father.getLeft());
        father.setLeft(a);
        a.setParent(father);
        AVLNode rs = rightRotate(father);

        return rs;
    }

    public AVLNode doubleRotateRightLeft(AVLNode father) {  // right rotate child, left rotate node    (rotate with right child)
        AVLNode b = rightRotate(father.getRight());
        father.setRight(b);
        b.setParent(father);
        AVLNode rs = leftRotate(father);

        return rs;
    }

    public int getBalance(AVLNode n) {
        if (n == null) {
            return 0;
        }

        return height(n.getRight()) - height(n.getLeft());
    }

    public void insert(T x) {
        if (root == null) {
            root = new AVLNode(x, null, null, null);
            return;
        }
        AVLNode<T> f, p;
        p = root;
        f = null;
        while (p != null) {
            if (x.compareTo(p.getData()) == 0) {
                System.out.println(" The key " + x + " already exists, no insertion");
                return;
            }
            f = p;
            if (x.compareTo(p.getData()) < 0) {
                p = p.getLeft();
            } else {
                p = p.getRight();
            }
        }
        if (x.compareTo(f.getData()) < 0) {
            f.setLeft(new AVLNode(x, null, null, f));
        } else {
            f.setRight(new AVLNode(x, null, null, f));
        }

        updateHeight(root);
        checkAndRotate(f);
    }

    private void checkAndRotate(AVLNode<T> node) {

        AVLNode<T> newNode = null;
        if (node != null) {

            boolean isRotate = false;
            AVLNode<T> parent = null;
            boolean isRightChild = false;
            if (node != root) {
                parent = node.getParent();
                isRightChild = true;
                if (parent.getLeft() == node) {

                    isRightChild = false;

                }
            }

            int balance = getBalance(node);
            if (balance < -1) {
                // Cây mất cân bằng về bên trái
                if (getBalance(node.getLeft()) <= 0) {
                    newNode = rightRotate(node);
                } else {
                    newNode = doubleRotateLeftRight(node);
                }
                isRotate = true;
            } else if (balance > 1) {
                // Cây mất cân bằng về bên phải
                if (getBalance(node.getRight()) >= 0) {
                    newNode = leftRotate(node);
                } else {
                    // Double rotate: right rotate child, then left rotate node
                    newNode = doubleRotateRightLeft(node);
                }
                isRotate = true;
            }
            if (isRotate) {
                if (parent != null && newNode != null) {
                    if (isRightChild) {
                        parent.setRight(newNode);
                        newNode.setParent(parent);
                    } else {
                        parent.setLeft(newNode);
                        newNode.setParent(parent);
                    }
                } else {
                    root = newNode;
                }
                updateHeight(root);
            }
            if (node != root) {
                checkAndRotate(parent);
            }
        }
    }

    private void updateHeight(AVLNode<T> node) {
        if (node != null) {

            updateHeight(node.getLeft());
            updateHeight(node.getRight());

            int leftHeight = height(node.getLeft());
            int rightHeight = height(node.getRight());

            node.setHeight(1 + max(leftHeight, rightHeight));

        }
    }

    public AVLNode<T> search(AVLNode<T> p, T x) {
        if (p == null) {
            return (null);
        }
        if (x.compareTo(p.getData()) == 0) {
            return (p);
        }
        if (x.compareTo(p.getData()) < 0) {
            return (search(p.getLeft(), x));
        } else {
            return (search(p.getRight(), x));
        }

    }

    public void inOrderTraversal(AVLNode<T> p) {
        if (p == null) {
            return;
        }
        inOrderTraversal(p.getLeft());
        visit(p);
        inOrderTraversal(p.getRight());
    }

    public void visit(AVLNode<T> p) {
        p.getData().toString();
        System.out.println("height: " + p.getHeight());
    }

    public AVLNode<T> getRoot() {
        return root;
    }

    public void deleteByCopying(T key) {
        root = AVLTree.this.deleteByCopying(root, key);
    }

    private AVLNode<T> deleteByCopying(AVLNode<T> p, T key) {
        if (p == null) {
            return null;
        }

        if (key.compareTo(p.getData()) < 0) {
            p.setLeft(AVLTree.this.deleteByCopying(p.getLeft(), key));
        } else if (key.compareTo(p.getData()) > 0) {
            p.setRight(AVLTree.this.deleteByCopying(p.getRight(), key));
        } else {

            if (p.getLeft() == null) {
                return p.getRight();
            } else if (p.getRight() == null) {
                return p.getLeft();
            }

            AVLNode<T> left = p.getLeft();
            AVLNode<T> right = p.getRight();
            AVLNode<T> min = findMin(p.getRight());
            p = new AVLNode<T>(min.getData(), null, null, p.getParent());
            p.setRight(AVLTree.this.deleteByCopying(right, min.getData()));
            p.setLeft(left);
        }
        updateHeight(root);
        checkAndRotate(p);

        return p;
    }

    private AVLNode<T> findMin(AVLNode<T> node) {
        while (node.getLeft() != null) {
            node = node.getLeft();
        }
        return node;
    }

}
