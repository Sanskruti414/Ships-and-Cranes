
public class ContainerFactory {
    public Container getContainer(int typeID)
    {
        if(typeID==1) return new LiquidContainer();
        if(typeID==2) return new RefrigeratedContainer();
        if(typeID==3) return new HeavyContainer();
        if(typeID==4) return new ToxicContainer();
        else return new WeakContainer();
    }
}