package com.company.bst;

import com.company.util.CompareObject;
import com.company.util.Iterable;
import com.company.util.stack.Stack;

import java.util.NoSuchElementException;

/**
 * Created by Igor on 3/13/16.
 */
public class BST<T extends CompareObject<T>> implements Iterable<T> {

    private Node<T> root;
    private int size;

    public BST() {

        root = NullableNode.INSTANCE;
        size = 0;
    }

    public void insert(T object) {

        if (object == null) throw new IllegalArgumentException("Can not insert null");

        root = insertNode(root, object, NullableNode.INSTANCE);
        size++;
    }

    public Boolean isEmpty() {

        return root == null;
    }

    public T search(T key) {

        Node<T> node = searchNode(root, key);
        return (node != null) ? node.getValue() : null;
    }

    public int getSize() {

        return size;
    }

    public int getHeight() {

        return root.getHeight();
    }

    public void inOrder(NodeHandler<T> nodeHandler) {

        inOrder(root, nodeHandler);
    }

    private Node insertNode(Node root, T object, Node previousNode) {

        if (root instanceof NullableNode)
            return new Node(object, NullableNode.INSTANCE, NullableNode.INSTANCE, previousNode);

        int result = root.getValue().compare(object);
        previousNode = root;

        if (result > 0) root.setRight(insertNode(root.getRight(), object, previousNode));
        else if (result < 0) root.setLeft(insertNode(root.getLeft(), object, previousNode));

        return root;
    }

    private Node searchNode(Node root, T key) {

        if (root instanceof NullableNode || root.getValue().compare(key) == 0) return root;
        if (root.getValue().compare(key) > 0) return searchNode(root.getRight(), key);
        return searchNode(root.getLeft(), key);
    }

    private void inOrder(Node<T> root, NodeHandler<T> nodeHandler) {

        if (!(root instanceof NullableNode)) {

            inOrder(root.getLeft(), nodeHandler);
            nodeHandler.handle(root.getValue());
            inOrder(root.getRight(), nodeHandler);
        }
    }

    class NodeIterator implements com.company.util.Iterator<T> {

        private Stack<Node<T>> stack;

        public NodeIterator() {

            stack = new Stack<>();
            initWithSubtree(root);
        }

        @Override
        public boolean hasNext() {

            return stack.isEmpty();
        }

        @Override
        public T next() {

            T valueToReturn = null;

            if (hasNext()) {

                Node<T> nodeToReturn = stack.pop();
                valueToReturn = nodeToReturn.getValue();
                initWithSubtree(nodeToReturn.getRight());
            }

            return valueToReturn;
        }

        private void initWithSubtree(Node<T> root) {

            while (!(root instanceof NullableNode)) {

                stack.push(root);
                root = root.getLeft();
            }
        }
    }

    @Override
    public NodeIterator getIterator() {

        NodeIterator iterator = new NodeIterator();
        return iterator;
    }

    class IteratorNode implements com.company.util.Iterator<T> {

        Node<T> currentNode;
        Node<T> prevNode;

        public IteratorNode() {

            prevNode = NullableNode.INSTANCE;
            initWithSubtree(root);
        }

        @Override
        public boolean hasNext() {
            return !(currentNode instanceof NullableNode);
        }

        @Override
        public T next() {

            if (!hasNext()) throw new NoSuchElementException();

            T valueToReturn = currentNode.getValue();

            prevNode = currentNode;

            if (currentNode.getRight() instanceof NullableNode) currentNode = currentNode.getParent();
            else currentNode = getLeftOfSubtree(currentNode.getRight());

            if (currentNode.getRight() == prevNode) {

                while (currentNode.getRight() == prevNode) {

                    prevNode = currentNode;
                    currentNode = currentNode.getParent();
                }
            }

            return valueToReturn;
        }

        private void initWithSubtree(Node<T> root) {

            currentNode = getLeftOfSubtree(root);
        }

        private Node<T> getLeftOfSubtree(Node<T> root) {

            Node<T> nodeToReturn = root;

            while (!(nodeToReturn.getLeft() instanceof NullableNode)) {

                nodeToReturn = nodeToReturn.getLeft();
            }

            return nodeToReturn;
        }
    }

    public IteratorNode getOtherIterator() {

        IteratorNode iterator = new IteratorNode();
        return iterator;
    }
}

