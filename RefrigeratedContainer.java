public class RefrigeratedContainer extends Container {

	private int power;

	public void setProperty(int id, int typeId, int property)
	{
		this.id = id;
		this.typeId = typeId;
		this.power = property;
	}
	public int getProperty()
	{
		return power;
	}

}