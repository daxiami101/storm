package lab;

import java.time.LocalDateTime;

public class Volume {
	private String wordCount;
	private String author;
	private Corpus corpus;
	private Integer sentenceCount;// ": 114,
	private String title;// ": "Trump's newfound fury against China is an evil
							// stunt: Don't let him get away with it",
	private String dateAdded;// ": "2020-05-01T10:57:36.888Z",
	private String datePublished;// ": "2020-05-01T04:00:00Z",
	private String id;// "id": 5333223,
	private String locator;// ": "https://www.salon.com/202

	public String getWordCount() {
		return wordCount;
	}

	public void setWordCount(String wordCount) {
		this.wordCount = wordCount;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Corpus getCorpus() {
		return corpus;
	}

	public void setCorpus(Corpus corpus) {
		this.corpus = corpus;
	}

	public Integer getSentenceCount() {
		return sentenceCount;
	}

	public void setSentenceCount(Integer sentenceCount) {
		this.sentenceCount = sentenceCount;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	

	public String getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(String dateAdded) {
		this.dateAdded = dateAdded;
	}

	public String getDatePublished() {
		return datePublished;
	}

	public void setDatePublished(String datePublished) {
		this.datePublished = datePublished;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLocator() {
		return locator;
	}

	public void setLocator(String locator) {
		this.locator = locator;
	}

}
