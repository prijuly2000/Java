package sun.krd.hitcounter;

public class HitCounterApp {

	private int hits=0;

	public HitCounterApp() {
		super();
	}

	public HitCounterApp(int hits) {
		super();
		this.hits = hits;
	}

	public int getHits() {
		return hits;
	}

	public void setHits(int hits) {
		this.hits = hits;
	}
	
	public int getHitCount() {
		++hits;
		return hits;
	}

}
