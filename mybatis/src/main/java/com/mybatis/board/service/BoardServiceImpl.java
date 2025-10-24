package com.mybatis.board.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.board.dto.Board;
import com.mybatis.board.dto.Reply;
import com.mybatis.board.repository.BoardRepository;
import com.mybatis.common.dto.PageInfo;
import static com.mybatis.common.template.Template.*;


public class BoardServiceImpl implements BoardService{
	private BoardRepository bDao = new BoardRepository();
		
	@Override
	public int totalRecord() {
		SqlSession sqlSession = getSqlsession();
		int totalRecord = bDao.totalRecord(sqlSession);
		sqlSession.close();
		return totalRecord;
	}

	@Override
	public ArrayList<Board> selectList(PageInfo pi) {
		SqlSession sqlSession = getSqlsession();
		ArrayList<Board> list = bDao.selectList(sqlSession, pi);
		sqlSession.close();
		return list;
	}

	@Override
	public int increaseCount(int boardNo) {
		SqlSession sqlSession = getSqlsession();
		int result = bDao.increaseCount(sqlSession, boardNo);
		if(result >0) {
			sqlSession.commit();
		}
		sqlSession.close();
		return result;
	}


	@Override
	public int selectSearchCount(HashMap<String, String> map) {
		SqlSession sqlSession = getSqlsession();
		int totalRecord = bDao.selectSearchCount(sqlSession, map);
		sqlSession.close();
		return totalRecord;
	}

	@Override
	public ArrayList<Board> selectSearchList(HashMap<String, String> map, PageInfo pi) {
		SqlSession sqlSession = getSqlsession();
		ArrayList<Board> list = bDao.selectSearchList(sqlSession, map, pi);
		sqlSession.close();
		return list;
	
	}

	@Override
	public Board selectBoard(int boardNo) {
		SqlSession sqlSession = getSqlsession();
		Board result = bDao.selectBoard(sqlSession, boardNo);
		sqlSession.close();
		return result;
	}
	
	@Override
	public ArrayList<Reply> selectReplyList(int boardNo) {
		SqlSession sqlSession = getSqlsession();
		ArrayList<Reply> list = bDao.selectReplyList(sqlSession, boardNo);
		sqlSession.close();
		return list;
	}
	
	@Override
	public ArrayList<Reply> selectReplyList(int boardNo, PageInfo pi) {
		SqlSession sqlSession = getSqlsession();
		ArrayList<Reply> list = bDao.selectReplyList(sqlSession, boardNo, pi);
		sqlSession.close();
		return list;
	}
	
	
	@Override
	public int replyRecord(int boardNo) {
		SqlSession sqlSession = getSqlsession();
		int totalRecord = bDao.replyRecord(sqlSession, boardNo);
		sqlSession.close();
		return totalRecord;
	}

	@Override
	public int insertReply(Reply r) {
		SqlSession sqlSession = getSqlsession();
		int result = bDao.insertReply(sqlSession, r);
		if(result > 0) {
			sqlSession.commit();
		}
		sqlSession.close();
		return result;
	}

	@Override
	public int insertBoard(Board b) {
		SqlSession sqlSession = getSqlsession();
		int result = bDao.insertBoard(sqlSession, b);
		if(result > 0) {
			sqlSession.commit();
		}
		sqlSession.close();
		return result;
	}




}
