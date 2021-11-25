import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Driver {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner sc=new Scanner(new FileReader("test.txt"));
		int noOfTestCases=sc.nextInt();
		while(noOfTestCases>0)
		{
			int riskTolerance,powerInput,maxWeight,swayTolerance,maxStackHeight,stackLimit;
			riskTolerance=sc.nextInt();
			powerInput=sc.nextInt();
			maxWeight=sc.nextInt();
			swayTolerance=sc.nextInt();
			maxStackHeight=sc.nextInt();
			stackLimit=sc.nextInt();
			
			if(stackLimit<=0) 
			{
				System.out.println("Stack size 0, enter Again :(");
				System.out.println();
				noOfTestCases--;
				continue;
			}

			Ship ship =new Ship(riskTolerance,powerInput,maxWeight,swayTolerance,maxStackHeight,stackLimit);
			List<Container> containerList=new ArrayList<Container>();
			ContainerFactory factory=new ContainerFactory();
			Container container;
			int id,typeId,property;

			int n=sc.nextInt();
			for(int i=0;i<n;i++)
			{
				id=sc.nextInt();
				typeId=sc.nextInt();
				property=sc.nextInt();
				container=factory.getContainer(typeId);
				container.setProperty(id, typeId, property);
				containerList.add(container);
			}

			Crane crane=new Crane(ship);
			crane.stack(ship, containerList);
			noOfTestCases--;
			System.out.println();
		}
	}

}
