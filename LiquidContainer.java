public class LiquidContainer extends Container {

	private int sway;

	public void setProperty(int id, int typeId, int property)
	{
		this.id = id;
		this.typeId = typeId;
		this.sway = property;
	}
	public int getProperty()
	{
		return sway;
	}

}