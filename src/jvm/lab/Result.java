package lab;

import java.util.ArrayList;
import java.util.List;

public class Result {
	private String totalHits;
	private List<Sentence> sentences = new ArrayList<>();
	public String getTotalHits() {
		return totalHits;
	}
	public void setTotalHits(String totalHits) {
		this.totalHits = totalHits;
	}
	public List<Sentence> getSentences() {
		return sentences;
	}
	public void setSentences(List<Sentence> sentences) {
		this.sentences = sentences;
	}
	
}
