public interface Step<I,O> {
    public static class StepException extends Exception{
        public StepException(Throwable throwable){
            super(throwable);
        }
    }
    O process(I input) throws StepException;
}
