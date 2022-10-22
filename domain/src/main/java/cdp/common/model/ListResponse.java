package cdp.common.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * 페이지가 미포함 조회
 */
@Getter
@Setter
public class ListResponse<T> {
	
	private long total = 0;

	private List<T> contents = new ArrayList<>();
	
	
	public ListResponse(List<T> list) {
		this.total = list.size();
		this.contents = list;
	}
}