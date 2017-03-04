package com.template.commons.domain;

import java.io.Serializable;
import java.util.List;

/**
 * 分页查询时的辅助工具类
 */
public class Page implements Serializable {
	private static final long serialVersionUID = -2691693559165410222L;
	protected int limit = 20; // 每页显示条数
	protected int no = 1; // 第几页
	protected int start = 0; // 起始行号
	protected long total = -1; // 总记录数
	protected List<?> result; // 结果集
	protected int pages = 0; // 总页数

	// -- 访问查询结果函数 --//

	public Page(){
		
	}
	
	public Page(Integer no, Integer limit ){
		this.no = no;
		this.limit = limit;
		this.start = (no - 1) * limit;
	}
	
	public Page(Integer no, Integer limit ,Integer start){
		this.no = no;
		this.limit = limit;
		this.start = (no - 1) * limit + start;
	}
	
	/**
	 * 获得页内的记录列表.
	 */
	public List<?> getResult() {
		return result;
	}

	/**
	 * 设置页内的记录列表.
	 */
	public void setResult(final List<?> result) {
		this.result = result;
	}

	/**
	 * 获取每页显示条数
	 * 
	 * @return
	 */
	public int getLimit() {
		return limit;
	}

	/**
	 * 设置每页显示条数
	 * 
	 * @param limit
	 */
	public void setLimit(int limit) {
		this.limit = limit;
	}

	/**
	 * 获取起始行号
	 * 
	 * @return
	 */
	public int getStart() {
		return start;
	}

	/**
	 * 设置起始行号
	 * 
	 * @param start
	 */
	public void setStart(int start) {
		this.start = start;
	}

	/**
	 * 获取总记录数
	 * 
	 * @return
	 */
	public long getTotal() {
		return total;
	}

	/**
	 * 设置总记录数
	 * 
	 * @param total
	 */
	public void setTotal(long total) {
		this.total = total;
	}

	/**
	 * 获取第几页
	 * 
	 * @return
	 */
	public int getNo() {
		return no;
	}

	/**
	 * 设置第几页
	 * 
	 * @param no
	 */
	public void setNo(int no) {
		this.no = no;
		this.start = (no - 1) * limit;
	}

	/**
	 * 获取总页数
	 * 
	 * @return
	 */
	public int getPages() {
		pages = (int) ((total / limit) + (total % limit > 0 ? 1 : 0));
		return pages;
	}
}
