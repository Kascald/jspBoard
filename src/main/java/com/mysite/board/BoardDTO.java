package com.mysite.board;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class BoardDTO {
	private int number; //index
	private String title;
	private String writer;
	private String content;
	private Date regDate;
	private int viewCnt;
}
