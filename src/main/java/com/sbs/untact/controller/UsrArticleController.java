package com.sbs.untact.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sbs.untact.dto.Article;

@Controller
public class UsrArticleController {
	private List<Article> articles;
	private int articlesLastId;

	public UsrArticleController() {
		articlesLastId = 0;
		articles = new ArrayList<>();

		articles.add(new Article(++articlesLastId, "2020-12-12 12:12:12", "제목1", "내용1"));
		articles.add(new Article(++articlesLastId, "2020-12-12 12:12:12", "제목2", "내용2"));
	}

	@RequestMapping("/usr/article/detail")
	@ResponseBody
	public Article showDetail(int id) {
		return articles.get(id - 1);
	}

	@RequestMapping("/usr/article/list")
	@ResponseBody
	public List<Article> showList() {
		return articles;
	}

	@RequestMapping("usr/article/doAdd")
	@ResponseBody
	public Map<String, Object> doAdd(String regDate, String title, String body) {
		articles.add(new Article(++articlesLastId, regDate, title, body));

		Map<String, Object> rs = new HashMap<>();
		rs.put("resultCode", "성공");
		return rs;
	}

	@RequestMapping("usr/article/doDelete")
	@ResponseBody
	public Map<String, Object> doDelete(int id) {
		
		articles.remove(id - 1);

		Map<String, Object> rs = new HashMap<>();
		rs.put("resultCode", "성공");
		return rs;
	}
}
