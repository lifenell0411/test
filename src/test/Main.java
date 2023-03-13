package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	static List<Article> articles = new ArrayList<>();

	public static void main(String[] args) {
		;
		System.out.println("==프로그램 시작==");
		makeTestdata();
		int lastId = 3;
		Scanner sc = new Scanner(System.in);

		while (true) {

			System.out.print("명령어 ) ");
			String command = sc.nextLine();
			if (command.equals("post write")) {

				int id = lastId + 1;
				String regDate = "2023-02-24 11:25:01";
				String updateDate = "2023-02-24 11:25:01";
				System.out.print("제목 : ");
				String title = sc.nextLine();
				System.out.print("내용 : ");
				String body = sc.nextLine();

				Article article = new Article(id, title, body, regDate, updateDate);
				articles.add(article);
				System.out.println(id + "번 글이 생성되었습니다");
				lastId++;
			}

			else if (command.equals("post list")) {
				Article foundArticle = null;
				System.out.println("번호 |   제목");
				for (int i = articles.size() - 1; i >= 0; i--) {
					Article article = articles.get(i);
					foundArticle = article;
					System.out.println(foundArticle.id + "   |   " + foundArticle.title);
				}

			}

			else if (command.startsWith("post modify ")) {
				String[] cmdDiv = command.split(" ");
				int id = Integer.parseInt(cmdDiv[2]);

				Article foundArticle = null;

				for (int i = 0; i < articles.size(); i++) {
					foundArticle = articles.get(i);

				}
				if (id == foundArticle.id) {
					System.out.print("제목 : ");
					String newTitle = sc.nextLine();
					System.out.print("내용 : ");
					String newBody = sc.nextLine();

					foundArticle.title = newTitle;
					foundArticle.body = newBody;
					System.out.println(id + "번 게시물을 수정했습니다");

				}

			}

			else if (command.startsWith("post delete ")) {
				String[] cmdDiv = command.split(" ");

				int id = Integer.parseInt(cmdDiv[2]);
				int foundIndex = -1;
				for (int i = 0; i < articles.size(); i++) {
					foundIndex = i;

				}

				if (foundIndex == -1) {
					System.out.println(id + "번 게시물은 존재하지 않습니다.");
					continue;
				}
				articles.remove(foundIndex);
				System.out.println(id + "번 게시물을 삭제했습니다.");
			}

			else if (command.startsWith("post detail ")) {
				String[] cmdDiv = command.split(" ");
				int id = Integer.parseInt(cmdDiv[2]);

				Article foundArticle = null;

				for (int i = 0; i < articles.size(); i++) {
					foundArticle = articles.get(i);

				}
				if (id == foundArticle.id) {
					System.out.println("번호 : " + foundArticle.id);
					System.out.println("날짜 : " + foundArticle.regDate);
					System.out.println("제목 : " + foundArticle.title);
					System.out.println("내용 : " + foundArticle.body);
				}
			} else if (command.equals("exit")) {
				break;
			}

			else {
				System.out.println("명령어를 확인해주세요");
				continue;
			}
		}

		sc.close();
	}

	private static void makeTestdata() {

		System.out.println("테스트를 위한 게시물 데이터를 생성합니다.");
		articles.add(new Article(1, "제목1"));
		articles.add(new Article(2, "제목2"));
		articles.add(new Article(3, "제목3"));
	}
}

class Article {

	int id;
	String body;
	String title;
	String regDate;
	String updateDate;

	public Article(int id, String title, String body, String regDate, String updateDate) {
		this.id = id;
		this.title = title;
		this.body = body;
		this.regDate = regDate;
		this.updateDate = updateDate;
	}

	Article(int id, String title) {
		this.id = id;
		this.title = title;
	}

}