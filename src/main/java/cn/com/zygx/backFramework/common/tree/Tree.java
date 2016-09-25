package cn.com.zygx.backFramework.common.tree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/**
 * 该树形结构是针对easyui进行的封装，换做一种机构需要做相应的变更
 * @author wangyi
 * @date 2016-7-15 下午2:48:13 
 */
public class Tree {

	private List<Node> nodes=new ArrayList<Node>();
	
	private Node root=null;
	
	public Tree(List<Node> nodes,Node root){
		this.nodes=nodes;
		this.root=root;
	}
	
	
	public Node build(){
		buildTree(root);
		return root;
	} 
	
	private void buildTree(Node parent){
		Node node=null;
		for(Iterator<Node> ite=nodes.iterator();ite.hasNext();){
			node=ite.next();
			if(Objects.equals(node.getParentId(), parent.getId())){
				parent.getChildren().add(node);
				buildTree(node);
			}
		}
	}
	
	
	
}
