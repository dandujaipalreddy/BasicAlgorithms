package basic.ds.trees;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dreddy on 12/16/2016.
 */
public class TreeNode<T> {
    public T data;
    public List<TreeNode> children;

    public TreeNode(T data) {
        this.data = data;
        children = new ArrayList<>();
    }

    public void addChild(TreeNode<T> child) {
        this.children.add(child);
    }
}
