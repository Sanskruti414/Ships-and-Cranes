public class Ship {

	private int riskTolerance;
	private int powerInput;
	private int maxWeight;
	private int swayTolerance;
	private int maxStackHeight;
	private int stackLimit;

	Ship (int riskTolerance, int powerInput, int maxWeight, int swayTolerance, int maxStackHeight, int stackLimit)
	{
		this.riskTolerance = riskTolerance;
		this.powerInput = powerInput;
		this.maxWeight = maxWeight;
		this.swayTolerance = swayTolerance;
		this.maxStackHeight = maxStackHeight;
		this.stackLimit = stackLimit;
	}
	public int getRiskTolerance()
	{
		return this.riskTolerance;
	}
	public int getPowerInput()
	{
		return this.powerInput;
	}
	public int getMaximumWeight()
	{
		return this.maxWeight;
	}
	public int getSwayTolerance()
	{
		return this.swayTolerance;
	}
	public int getMaxStackHeight()
	{
		return this.maxStackHeight;
	}
	public int getStackLimit()
	{
		return this.stackLimit;
	}




}