package hodilka.model;

public class GameObject {
	private Transform transform;
	private GameObjectRepresentation representation = new GameObjectRepresentation();
	private String discription;
	private FieldCell locationCell;
	
	public Transform getTransform() {
		return transform;
	}
	public void setTransform(Transform transform) {
		this.transform = transform;
	}
	public String getDiscription() {
		return discription;
	}
	public void setDiscription(String discription) {
		this.discription = discription;
	}
	public GameObjectRepresentation getRepresentation() {
		return representation;
	}
	public void setRepresentation(GameObjectRepresentation representation) {
		this.representation = representation;
	}
	public FieldCell getLocationCell() {
		return locationCell;
	}
	public void setLocationCell(FieldCell locationCell) {
		this.locationCell = locationCell;
	}
}
