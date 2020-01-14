package com.kh.sts07.entity;

public class BoardDto {
	private int rn;
	private int no;
	private String head;
	private String title;
	private String writer;
	private String wdate;
	private int readcount;
	private int replycount;
	private String content ;
	private String rwriter;
	private String rwdate;
	private int rgroupno;
	private int rsuperno;
	private int rdepth;
	private String rcontent;
	
	public String getRcontent() {
		return rcontent;
	}
	public void setRcontent(String rcontent) {
		this.rcontent = rcontent;
	}
	public int getRn() {
		return rn;
	}
	public void setRn(int rn) {
		this.rn = rn;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getHead() {
		return head;
	}
	public void setHead(String head) {
		this.head = head;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getWdate() {
		return wdate;
	}
	public void setWdate(String wdate) {
		this.wdate = wdate;
	}
	public int getReadcount() {
		return readcount;
	}
	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}
	public int getReplycount() {
		return replycount;
	}
	public void setReplycount(int replycount) {
		this.replycount = replycount;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public BoardDto(int no, String head, String title, String writer, String wdate, int readcount, int replycount,
			String content) {
		super();
		this.no = no;
		this.head = head;
		this.title = title;
		this.writer = writer;
		this.wdate = wdate;
		this.readcount = readcount;
		this.replycount = replycount;
		this.content = content;
	}
	public BoardDto() {
		super();
	}
	public BoardDto(int rn, int no, String head, String title, String writer, String wdate, int readcount,
			int replycount, String content) {
		super();
		this.rn = rn;
		this.no = no;
		this.head = head;
		this.title = title;
		this.writer = writer;
		this.wdate = wdate;
		this.readcount = readcount;
		this.replycount = replycount;
		this.content = content;
	}
	
	public BoardDto(int rn, int no, String head, String title, String writer, String wdate, int readcount,
			int replycount, String content, String rwriter, String rwdate, int rgroupno, int rsuperno, int rdepth,
			int groupno, int superno, int depth) {
		super();
		this.rn = rn;
		this.no = no;
		this.head = head;
		this.title = title;
		this.writer = writer;
		this.wdate = wdate;
		this.readcount = readcount;
		this.replycount = replycount;
		this.content = content;
		this.rwriter = rwriter;
		this.rwdate = rwdate;
		this.rgroupno = rgroupno;
		this.rsuperno = rsuperno;
		this.rdepth = rdepth;
		this.groupno = groupno;
		this.superno = superno;
		this.depth = depth;
	}
	public String getRwriter() {
		return rwriter;
	}
	public void setRwriter(String rwriter) {
		this.rwriter = rwriter;
	}
	public String getRwdate() {
		return rwdate;
	}
	public void setRwdate(String rwdate) {
		this.rwdate = rwdate;
	}
	public int getRgroupno() {
		return rgroupno;
	}
	public void setRgroupno(int rgroupno) {
		this.rgroupno = rgroupno;
	}
	public int getRsuperno() {
		return rsuperno;
	}
	public void setRsuperno(int rsuperno) {
		this.rsuperno = rsuperno;
	}
	public int getRdepth() {
		return rdepth;
	}
	public void setRdepth(int rdepth) {
		this.rdepth = rdepth;
	}

	//계층형 게시판 관련 값  추가
	private int groupno, superno, depth;
	public int getGroupno() {
		return groupno;
	}
	public void setGroupno(int groupno) {
		this.groupno = groupno;
	}
	public int getSuperno() {
		return superno;
	}
	public void setSuperno(int superno) {
		this.superno = superno;
	}
	public int getDepth() {
		return depth;
	}
	public void setDepth(int depth) {
		this.depth = depth;
	}
	public BoardDto(int rn, int no, String head, String title, String writer, String wdate, int readcount,
			int replycount, String content, int groupno, int superno, int depth) {
		super();
		this.rn = rn;
		this.no = no;
		this.head = head;
		this.title = title;
		this.writer = writer;
		this.wdate = wdate;
		this.readcount = readcount;
		this.replycount = replycount;
		this.content = content;
		this.groupno = groupno;
		this.superno = superno;
		this.depth = depth;
	}
	public BoardDto(int rn, int no, String head, String title, String writer, String wdate, int readcount,
			int replycount, String content, String rwriter, String rwdate, int rgroupno, int rsuperno, int rdepth,
			String rcontent, int groupno, int superno, int depth) {
		super();
		this.rn = rn;
		this.no = no;
		this.head = head;
		this.title = title;
		this.writer = writer;
		this.wdate = wdate;
		this.readcount = readcount;
		this.replycount = replycount;
		this.content = content;
		this.rwriter = rwriter;
		this.rwdate = rwdate;
		this.rgroupno = rgroupno;
		this.rsuperno = rsuperno;
		this.rdepth = rdepth;
		this.rcontent = rcontent;
		this.groupno = groupno;
		this.superno = superno;
		this.depth = depth;
	}
	
	
	
	
	}
	

