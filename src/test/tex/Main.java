package test.tex;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Main {

	public static void main(String[] args) {
		String html = "<p>已知仓库有苹果15吨，梨子20吨，现制造饮料A，每吨需要苹果0.5吨，梨子0.8吨。</p>\n"
				+ "<p>请计算，制作饮料A5吨，需要消耗苹果<span class=\"bfjy-answer bfjy-completion\">2.5</span>&nbsp;吨，梨子<span class=\"bfjy-answer bfjy-completion\">4</span>&nbsp;吨</p>\n"
				+ "<p>已知计算公式<img title=\"2H_2 + O_2 \\xrightarrow{n,m}2H_2O\" src=\"http://latex.codecogs.com/gif.latex?\\fn_jvn&amp;space;2H_2&amp;space;+&amp;space;O_2&amp;space;\\xrightarrow{n,m}2H_2O\" />已知计算公式已知计算公式已知计算公式已知计算公式已知计算公式</p>\n"
				+ "<p>&nbsp;</p>\n"
				+ "<p><img src=\"http://uat2.itit.io:8899/proxy/download_file/4d6ac8663a034a74b28e601120909f56.jpg\" alt=\"\" width=\"500\" height=\"791\" />已知计算公式已知计算公式已知计算公式已知计算公式已知计算公式已知计算公式</p>\n"
				+ "<p>已知计算公式已知计算公式已知计算公式已知计算公式已知计算公式已知计算公式</p>\n" + "<p>&nbsp;</p>\n" + "<p>已知计算公式</p>\n"
				+ "<p>&nbsp;</p>";
		Document document = Jsoup.parse(html);
		Elements elements = document.getElementsByClass("bfjy-answer bfjy-completion");
		elements.forEach(item -> {
			System.err.println(item.html());
		});
	}
}