public class Pipeline<I,O> {
    private Step<I,O> currentStep;

    public Pipeline(Step<I,O> step){
        this.currentStep = step;
    }

    public<NewO> Pipeline<I,NewO> pipe(Step<O,NewO> nextStep){
        return new Pipeline<>(input -> nextStep.process(currentStep.process(input)));
    }

    public O process(I input) throws Step.StepException {
        return currentStep.process(input);
    }
}
