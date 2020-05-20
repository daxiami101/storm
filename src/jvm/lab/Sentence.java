package lab;

public class Sentence {
	private Volume volume;
	private String sentence;//": "The direct quotes seemed ambiguous, honestly, as to whether Trump was directly connecting the Chinese government's virus response to its views of him personally.",
	private String corpusId;//": "SLN",
	private String volumeOffset;//": 14,
	private String[] offsets;//": [
	private String volumeId;//": 5333223
	public Volume getVolume() {
		return volume;
	}
	public void setVolume(Volume volume) {
		this.volume = volume;
	}
	public String getSentence() {
		return sentence;
	}
	public void setSentence(String sentence) {
		this.sentence = sentence;
	}
	public String getCorpusId() {
		return corpusId;
	}
	public void setCorpusId(String corpusId) {
		this.corpusId = corpusId;
	}
	public String getVolumeOffset() {
		return volumeOffset;
	}
	public void setVolumeOffset(String volumeOffset) {
		this.volumeOffset = volumeOffset;
	}
	public String[] getOffsets() {
		return offsets;
	}
	public void setOffsets(String[] offsets) {
		this.offsets = offsets;
	}
	public String getVolumeId() {
		return volumeId;
	}
	public void setVolumeId(String volumeId) {
		this.volumeId = volumeId;
	}
}
