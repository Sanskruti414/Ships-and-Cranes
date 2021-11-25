import java.util.*;

public class Crane {
	
	private int currentRisk;
	private int currentPower;
	private int currentWeight;
	private int currentSway;
	private int maximumStackHeight;
	private ArrayList<List<Container>> stacks;

	Crane(Ship ship)
	{
		stacks= new ArrayList<List<Container>>(); 
		for(int i=0;i<ship.getStackLimit();i++)
		{
			List<Container> stack=new ArrayList<Container>();
			stacks.add(stack);
		}
		maximumStackHeight=ship.getMaxStackHeight();
	}

	public void stack(Ship ship,List<Container> containerList)
	{
		Collections.sort(containerList,new ContainerComparator());

		boolean flag=true;
		for(int i=0;i<containerList.size();i++)
		{
			List<Container> viableStack=getMinimumHeightStack();

			Container currentContainer=containerList.get(i);
			if(viableStack.size()+1<=maximumStackHeight && updateProperty(ship,currentContainer) && currentWeight<=ship.getMaximumWeight()) 
			{
				viableStack.add(currentContainer);
			}
			else
			{
				flag=false;
				break;
			}

		}

		if(flag==false) System.out.println("No viable Stacking Possible");
		else
		{
			System.out.println("Viable Stacking is");
			printStacking();
		}
	}

	public boolean updateProperty(Ship ship, Container c)
	{
		int property = c.getProperty();
		if(c.typeId == 1)
		{
			if(setCurrentSway(property)>ship.getSwayTolerance()) {
				return false;
			}
			
			setCurrentWeight(1);
		}
		else if(c.typeId == 2)
		{
			if(setCurrentPower(property)>ship.getPowerInput()) { 
				return false;
			}
			setCurrentWeight(1);
		}
		else if(c.typeId == 3)
		{
			if(setCurrentWeight(property)>ship.getMaximumWeight()) 
			{
				return false;
			}
		}
		else if(c.typeId == 4)
		{
			if(setCurrentRisk(property)>ship.getRiskTolerance()) {
				return false;
			}
			setCurrentWeight(1);
		}
		return true;

	}

	public void printStacking()
	{
		for(int i=0;i<stacks.size();i++)
		{
			System.out.print("Stack "+i+": ");
			for(int j=0;j<stacks.get(i).size();j++)
			{
				System.out.print(stacks.get(i).get(j).id+" ");
			}

			System.out.println();
		}
	}

	public List<Container> getMinimumHeightStack()
	{
		int minHeight=Integer.MAX_VALUE;
		int index=0;

		for(int i=0;i<stacks.size();i++)
		{
			List<Container> current=stacks.get(i);
			int currentSize=current.size();
			if(currentSize<minHeight)
			{
				minHeight=currentSize;
				index=i;
			}
		}
		return stacks.get(index);
	}
	public int setCurrentRisk(int risk) {
		return currentRisk+=risk;
	}

	public int setCurrentPower(int power) {
		return currentPower+=power;
	}

	public int setCurrentWeight(int weight) {
		return currentWeight+=weight;
	}

	public int setCurrentSway(int sway) {
		return currentSway+=sway;
	}
}
