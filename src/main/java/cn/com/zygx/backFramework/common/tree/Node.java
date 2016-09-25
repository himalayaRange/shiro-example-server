package cn.com.zygx.backFramework.common.tree;

import java.util.ArrayList;

import java.util.List;

/**
 * 基于Ztree定义的节点属性
 * 
 * @author wangyi
 * @date 2016-7-15 下午2:49:43 
 */
public class Node  extends NodeAttribute implements Comparable<Node>{

	private static final long serialVersionUID = -9012623322715370072L;

	private Integer id;  //节点ID
	
	private Integer parentId; //父节点
	
	private String name; //名称
	
	private Boolean open; //"open"表示展开，"close"表示闭合
	
	private String iconSkin;//自定义图标的样式
	
	private NodeAttribute attributes; //节点的属性
	
	private List<Node> children=new ArrayList<Node>();
	
	private Integer orders;//排序
   


	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public Integer getParentId() {
		return parentId;
	}



	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public Boolean getOpen() {
		return open;
	}



	public void setOpen(Boolean open) {
		this.open = open;
	}



	public NodeAttribute getAttributes() {
		return attributes;
	}



	public void setAttributes(NodeAttribute attributes) {
		this.attributes = attributes;
	}



	public List<Node> getChildren() {
		return children;
	}



	public void setChildren(List<Node> children) {
		this.children = children;
	}



	public Integer getOrders() {
		return orders;
	}



	public void setOrders(Integer orders) {
		this.orders = orders;
	}



	public String getIconSkin() {
		return iconSkin;
	}



	public void setIconSkin(String iconSkin) {
		this.iconSkin = iconSkin;
	}



	@Override
	public int compareTo(Node o) {
		return 0;
	}

	 
	
	
}
