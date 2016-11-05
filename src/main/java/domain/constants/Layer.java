package domain.constants;

public enum Layer {

	INSTRUCTIONS(1),
	GUARDS(2);

	private final int layer;
	
	Layer(int layer) {
		this.layer = layer;
	}
	
	public int getLayer() {
		return layer;
	}
	
	@Override
	public String toString() {
		return Integer.toString(layer);
	}
}
