package OrderedList;

public class AVL {
    static class AVLNode{
        public int key;
        public Object value;
        public AVLNode left;
        public AVLNode right;
        public int height = 1;

        public AVLNode(int key, Object value) {
            this.key = key;
            this.value = value;
        }
    }

    private int height(AVLNode node){
        if(node == null){
            return 0;
        }
        return node.height;
    }

    private void updateHeight(AVLNode node){
        if(node == null){
            return;
        }
        node.height = Integer.max(height(node.left), height(node.right)) + 1;
    }

    //balance factor
    private int bf(AVLNode node){
        return height(node.left)-height(node.right);
    }

    private AVLNode rotateRight(AVLNode node){
        AVLNode yellow = node.left;
        AVLNode green = yellow.right;
        node.left = green;
        yellow.right = node;
        updateHeight(node);
        updateHeight(yellow);
        return yellow;
    }

    private AVLNode rotateLeft(AVLNode node){
        AVLNode yellow = node.right;
        AVLNode green = yellow.left;
        node.right = green;
        yellow.left = node;
        updateHeight(node);
        updateHeight(yellow);
        return yellow;
    }

    private AVLNode balance(AVLNode node){
        if(node == null){
            return null;
        }
        int bf = bf(node);
        if(bf > 1){
            int leftBf = bf(node.left);
            if(leftBf < -1){
                node.left = rotateLeft(node.left);
                return rotateRight(node);
            }else{
                return rotateRight(node);
            }
        }else if(bf < -1){
            int rightBf = bf(node.right);
            if(rightBf > 1){
                node.right = rotateRight(node.right);
                return rotateLeft(node);
            }
        }
        return node;
    }

    private AVLNode root;

    public AVLNode put(int key, Object value){
        return doPut(root, key, value);
    }


    private AVLNode doPut(AVLNode node, int key, Object value){
        if(node == null){
            return new AVLNode(key, value);
        }
        if(node.key == key){
            node.value = value;
        }
        if(key < node.key){
            node.left = doPut(node.left, key, value);
        }else{
            node.right = doPut(node.right, key, value);
        }

        //TODO 这里需要看下递归续 下面两句不好理解
        updateHeight(node);
        return balance(node);
    }

    public AVLNode remove(int key){
        return doRemove(root, key);
    }

    private AVLNode doRemove(AVLNode node, int key){
        if(node == null){
            return null;
        }
        if(key < node.key){
            node.left = doRemove(node.left, key);
        }else if(key > node.key){
            node.right = doRemove(node.right, key);
        }else{
            if(node.left == null && node.right == null){
                return null;
            }else if(node.left != null && node.right == null){
                node = node.left;
            }else if(node.left == null && node.right != null){
                node = node.right;
            }else{
                //后继节点替换 被删除节点
                AVLNode s = node.right;
                while(s.left != null){
                    s = s.left;
                }
                s.right = doRemove(node.right, s.key);
                s.left = node.left;//不能调换这两句顺序 因为上面要对 s 进行删除
                node = s;
            }
        }
        updateHeight(node);
        return balance(node);
    }

}
