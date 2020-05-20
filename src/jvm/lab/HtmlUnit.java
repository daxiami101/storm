package lab;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.DomNodeList;
import com.gargoylesoftware.htmlunit.html.HtmlDivision;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlSpan;
import com.gargoylesoftware.htmlunit.html.HtmlSubmitInput;
import com.gargoylesoftware.htmlunit.html.HtmlTextInput;
 
public class HtmlUnit {
 
	public static void main(String[] args) throws InterruptedException {
		WebClient webClient=new WebClient(BrowserVersion.CHROME); // 实例化Web客户端端
		webClient.getOptions().setCssEnabled(false); // 取消css支持
		webClient.getOptions().setJavaScriptEnabled(false); // 取消javascript支持
		try {
			HtmlPage page=webClient.getPage("https://www.vocabulary.com/dictionary/ambiguous"); // 解析获取页面
                        Thread.sleep(10000); // 休息10秒 等待htmlunit执行Js
//			HtmlDivision div=page.getHtmlElementById("navMenu"); // 查找指定id的html dom元素
			HtmlElement body = page.getBody();
			String textContent = body.getTextContent();
			System.out.println(textContent);
			System.out.println("==============");
//                 HtmlForm form=page.getFormByName("myform"); // 获取搜索Form
//			HtmlTextInput textField=form.getInputByName("q"); // 获取查询文本框
//			HtmlSubmitInput button=form.getInputByName("submitButton"); // 获取提交按钮
//			textField.setValueAttribute("java"); // 文本框“填入”数据
//			HtmlPage resultPage=button.click(); // 模拟点击 获取查询结果页面
//			System.out.println(resultPage.asXml());
//                  System.out.println("==============");
//			DomNodeList<DomElement>  aList=page.getElementsByTagName("a"); // 根据tag名称查询所有tag
//			for(int i=0;i<aList.getLength();i++){
//				DomElement a=aList.get(i);
//				System.out.println(a.asXml());
//			}
//			System.out.println("==============");
//			List<HtmlSpan> spanList=page.getByXPath("//div[@id='navMenu']/ul/li[2]/a/span");
//			System.out.println(spanList.get(0).asText());
		} catch (FailingHttpStatusCodeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			webClient.close(); // 关闭客户端，释放内存
		}
	}
}
