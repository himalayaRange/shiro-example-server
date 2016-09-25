/**  
 * @author wangyi
 * @date 2016-5-26 下午3:47:30 
 * @version V1.0   
 */ 
package cn.com.zygx.backFramework.dto;

/**
 * 所有的ajax请求，封装json的结果信息
 * @author wangyi
 * @date 2016-5-26 下午3:47:30 
 */
public class SeckillResult<T> {

	private boolean success;
	
	private T data;
	
	private String error;

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public SeckillResult(boolean success, T data) {
		super();
		this.success = success;
		this.data = data;
	}

	public SeckillResult(boolean success, String error) {
		super();
		this.success = success;
		this.error = error;
	}
	
	
}