package cn.com.zygx.backFramework.common.tree;

import cn.com.zygx.backFramework.common.context.BaseEntity;

/**
 * 节点的拓展
 * @author wangyi
 * @date 2016-7-15 下午2:52:25 
 */
public class NodeAttribute extends BaseEntity {

	private static final long serialVersionUID = 6541425553345481860L;

	private Boolean isParent; //是否为父节点
	
	private String url;  //点击该url需要加载的请求
	
	private String target;//[treeNode.url 存在时有效] target 属性: "_blank", "_self" 或 其他指定窗口名称
	
	private Boolean isHidden ;//是否隐藏，当设置为隐藏过后该菜单不会被显示出来
	
	
	
	public Boolean getIsParent() {
		return isParent;
	}

	public void setIsParent(Boolean isParent) {
		this.isParent = isParent;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public Boolean getIsHidden() {
		return isHidden;
	}

	public void setIsHidden(Boolean isHidden) {
		this.isHidden = isHidden;
	}

	
	
}
