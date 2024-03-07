package com.mysite.board;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@AllArgsConstructor
@Getter
@Setter
public class BoardVO {
	private int number; //index
	private String title;
	private String writer;
	private String content;
	private Date regDate;
	private int viewCnt;
	
	
	@Override
	public String toString() {
		return "BoardVO || num = "+ number + "\ntitle = "+ title + "\nwriter = "+ writer + 
							"\ncontent = "+ content + "\nregDate = " + regDate + "\nviewCount = "+ viewCnt +"\n";	
	}
}
