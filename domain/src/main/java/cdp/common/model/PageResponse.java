package cdp.common.model;

import java.util.ArrayList;
import java.util.List;

import com.github.pagehelper.Page;

import lombok.Getter;
import lombok.Setter;


/**
 * 페이지 포함 조회
 */
@Getter
@Setter
public class PageResponse<T> extends SearchCriteria {

	private long total = 0;
	
	private List<T> contents = new ArrayList<T>();
	
	
	public PageResponse(List<T> contents, SearchCriteria searchCriteria) {
		
		Page<T> page = (Page<T>) contents;
		
		this.contents = contents;
		this.setPage(page.getPageNum());
		this.setTotal(page.getTotal());
		this.setSize(page.getPageSize());
	}

}