package com.mybatis.board.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.board.dto.Board;
import com.mybatis.board.dto.Reply;
import com.mybatis.board.repository.BoardRepository;
import com.mybatis.common.dto.PageInfo;
import com.mybatis.common.template.Template;

public class BoardServiceImpl implements BoardService{
	private BoardRepository bDao = new BoardRepository();
	private SqlSession sqlSession = Template.getSqlsession();
		
	@Override
	public int totalRecord() {
		int totalRecord = bDao.totalRecord(sqlSession);
		sqlSession.close();
		return totalRecord;
	}

	@Override
	public ArrayList<Board> selectList(PageInfo pi) {
		ArrayList<Board> list = bDao.selectList(sqlSession, pi);
		sqlSession.close();
		return list;
	}

	@Override
	public int increaseCount(int boardNo) {
		int result = bDao.increaseCount(sqlSession, boardNo);
		if(result >0) {
			sqlSession.commit();
		}
		return result;
	}


	@Override
	public int selectSearchCount(HashMap<String, String> map) {
		int totalRecord = bDao.selectSearchCount(sqlSession, map);
		sqlSession.close();
		return totalRecord;
	}

	@Override
	public ArrayList<Board> selectSearchList(HashMap<String, String> map, PageInfo pi) {
		ArrayList<Board> list = bDao.selectSearchList(sqlSession, map, pi);
		sqlSession.close();
		return list;
	
	}

	@Override
	public Board selectBoard(int boardNo) {
		Board result = bDao.selectBoard(sqlSession, boardNo);
		return result;
	}
	
	@Override
	public ArrayList<Reply> selectReplyList(int boardNo) {
		ArrayList<Reply> list = bDao.selectReplyList(sqlSession, boardNo);
		sqlSession.close();
		return list;
	}

	@Override
	public int insertReply(Reply r) {
		return 0;
	}

}
