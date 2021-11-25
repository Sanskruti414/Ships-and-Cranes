import java.util.Comparator;

public class ContainerComparator implements Comparator<Container>{

	@Override
	public int compare(Container o1, Container o2) {

		return o1.typeId-o2.typeId;
	}

}