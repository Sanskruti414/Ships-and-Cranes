public class HeavyContainer extends Container {

	private int weight;

	public void setProperty(int id, int typeId, int property)
	{
		this.id = id;
		this.typeId = typeId;
		this.weight = property;
	}
	public int getProperty()
	{
		return weight;
	}

}