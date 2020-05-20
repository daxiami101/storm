package lab;

import java.net.URL;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.google.gson.Gson;

public class MySelfDictionary {
	public static void main(String[] args) throws Exception {
		String word = "ambiguous";
		getWebInfo(word);
		demoGetRESTAPI(word);
	}

	public static void getWebInfo(String word) throws Exception {
		// 解析url地址
		Document document = Jsoup.parse(new URL("https://www.vocabulary.com/dictionary/" + word), 5000);
		// 获取title的内容
		Element title = document.getElementsByTag("title").first();
		Elements contentShort = document.getElementsByClass("short");
		Elements contentLong = document.getElementsByClass("long");
		System.out.println(contentShort.text());
		System.out.println(contentLong.text());
		System.out.println("=================================");
	}

	public static void demoGetRESTAPI(String word) throws Exception {
		HttpClient httpClient = new DefaultHttpClient();
		System.out.println("===============start===================");
		try {
			// Define a HttpGet request; You can choose between HttpPost,
			// HttpDelete or HttpPut also.
			// Choice depends on type of method you will be invoking.
			HttpGet getRequest = new HttpGet(
					"https://corpus.vocabulary.com/api/1.0/examples.json?jsonp=jQuery1124021889014710868715_1588389051586&query="
							+ word + "&maxResults=24&startOffset=0&filter=0&_=1588389051599");

			// Set the API media type in http accept header
			getRequest.addHeader("accept", "application/xml");

			// Send the request; It will immediately return the response in
			// HttpResponse object
			HttpResponse response = httpClient.execute(getRequest);
			System.out.println("===============get response===================");
			// verify the valid error code first
			int statusCode = response.getStatusLine().getStatusCode();
			if (statusCode != 200) {
				throw new RuntimeException("Failed with HTTP error code : " + statusCode);
			}

			System.out.println("===============convert entity===================");
			// Now pull back the response object
			HttpEntity httpEntity = response.getEntity();
			String apiOutput = EntityUtils.toString(httpEntity);

			// Lets see what we got from API
			// System.out.println(apiOutput); //<user
			// id="10"><firstName>demo</firstName><lastName>user</lastName></user>
			System.out.println("===============convert Json===================");
			String jsonStr = apiOutput.substring(apiOutput.indexOf("(") + 1, apiOutput.indexOf(")"));
			Gson json = new Gson();
			SearchReponseModel model = json.fromJson(jsonStr, SearchReponseModel.class);
			System.out.println(model.getStatus());
			List<Sentence> sentences = model.getResult().getSentences();

			for (Sentence sentence : sentences) {
				System.out.println(sentence.getSentence());
			}
		} finally {
			// Important: Close the connect
			httpClient.getConnectionManager().shutdown();
		}
	}
}
