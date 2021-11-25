

public class ToxicContainer extends Container {

	private int risk;
	
	public void setProperty(int id, int typeId, int property)
	{
		this.id = id;
		this.typeId = typeId;
		this.risk = property;
	}
	public int getProperty()
	{
		return risk;
	}

}



