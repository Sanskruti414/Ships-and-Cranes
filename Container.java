public abstract class Container
{
public int id;
public int typeId;

public abstract void setProperty(int id, int typeId, int property);
public abstract int getProperty();
}