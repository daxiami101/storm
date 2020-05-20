package lab;

import java.io.IOException;
import java.net.MalformedURLException;
import java.text.ParseException;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.DomNodeList;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

/**
 * @author 亦枫
 * @created_time 2016年1月12日
 * @file_user_todo Java测试类
 * @blog http://www.jianshu.com/users/1c40186e3248/latest_articles
 */
public class HtmlUnitDemo {

	/**
	 * 入口函数
	 * 
	 * @param args
	 * @throws ParseException
	 */
	public static void main(String[] args) throws ParseException {

		try {
			WebClient webClient = new WebClient(BrowserVersion.CHROME);
			HtmlPage htmlPage = (HtmlPage) webClient.getPage("https://www.vocabulary.com/dictionary/ambiguous");
			DomNodeList domNodeList = htmlPage.getElementsByTagName("sentence");
			for (int i = 0; i < domNodeList.size(); i++) {
				DomElement domElement = (DomElement) domNodeList.get(i);
				System.out.println(domElement.asText());
			}
			webClient.close();
		} catch (FailingHttpStatusCodeException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
