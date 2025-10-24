package com.mybatis.board.repository;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.mybatis.board.dto.Board;
import com.mybatis.board.dto.Reply;
import com.mybatis.common.dto.PageInfo;

public class BoardRepository {

	public int totalRecord(SqlSession sqlSession) {
		return sqlSession.selectOne("boardMapper.totalRecord");
	}

	public ArrayList<Board> selectList(SqlSession sqlSession, PageInfo pi) {
		// mybatis 에서 페이징 처리를 위한 RowBounds 라는 클래스 제공 
		/*
		 * offset : 몇개의 게시글(레코드의 개수) 를 건너뛰고 조회할건지에 대한 값
		 
		 * 						offset(건너뛸 숫자) 		limit(조회할 숫자)
		 * nowPage : 1 1~5			0						5
		 * nowPage : 2 6~10			5						5
		 * nowPage : 3 11~15		10						5
		 * nowPage : 4 16~20		15						5
		 * */
		int limit = pi.getNumPerPage();		// 5
		int offset = pi.getStartPage()-1;	// 
		RowBounds rowBounds = new RowBounds(offset, limit); // 이거 넘겨줄때는 반드시 3개 넘겨줘야함
		return (ArrayList)sqlSession.selectList("boardMapper.selectList",null,rowBounds); // List 는 Object로 받기에 형변환 필요
	}

	public int selectSearchCount(SqlSession sqlSession, HashMap<String, String> map) {
		return sqlSession.selectOne("boardMapper.searchCount", map);
	}

	public ArrayList<Board> selectSearchList(SqlSession sqlSession, HashMap<String, String> map, PageInfo pi) {
		int limit = pi.getNumPerPage();		// 5
		int offset = pi.getStartPage()-1;	// 
		RowBounds rowBounds = new RowBounds(offset, limit); // 이거 넘겨줄때는 반드시 3개 넘겨줘야함
		return (ArrayList)sqlSession.selectList("boardMapper.selectSearchList",map,rowBounds); // List 는 Object로 받기에 형변환 필요
	}

	public int increaseCount(SqlSession sqlSession, int boardNo) {
		return sqlSession.update("boardMapper.increaseCount", boardNo);
	}

	public Board selectBoard(SqlSession sqlSession, int boardNo) {
		return sqlSession.selectOne("boardMapper.selectBoard", boardNo);	
	}

	public ArrayList<Reply> selectReplyList(SqlSession sqlSession, int boardNo) {
		return (ArrayList)sqlSession.selectList("boardMapper.selectReplyList",boardNo); // List 는 Object로 받기에 형변환 필요
	}
	
	public ArrayList<Reply> selectReplyList(SqlSession sqlSession, int boardNo, PageInfo pi) {
		int limit = pi.getNumPerPage();		// 5
		int offset = pi.getStartPage()-1;	// 
		RowBounds rowBounds = new RowBounds(offset, limit); // 이거 넘겨줄때는 반드시 3개 넘겨줘야함
		return (ArrayList)sqlSession.selectList("boardMapper.selectReplyList",boardNo, rowBounds); // List 는 Object로 받기에 형변환 필요
	}

	public int replyRecord(SqlSession sqlSession, int boardNo) {
		return sqlSession.selectOne("boardMapper.replyRecord", boardNo);	
	}

	public int insertReply(SqlSession sqlSession, Reply r) {
		return sqlSession.insert("boardMapper.insertReply",r);
	}

	public int insertBoard(SqlSession sqlSession, Board b) {
		return sqlSession.insert("boardMapper.insertBoard",b);
	}


}
