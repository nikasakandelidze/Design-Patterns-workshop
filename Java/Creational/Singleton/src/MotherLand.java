/*
Be aware that sometimes this kind of implementation is not thread safe,
So singleton pattern is sometimes called anti-pattern.
 */
public class MotherLand {
    //Instantiate object this way
    private static MotherLand singletonMotherLand = new MotherLand();

    private MotherLand(){}

    //Always give away one and a same object on every invocation
    public static MotherLand getMotherLand(){
        return singletonMotherLand;
    }
}
