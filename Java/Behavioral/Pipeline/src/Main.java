import java.nio.channels.Pipe;

public class Main {
    public static class StringToIntStep implements Step<String,Integer>{

        @Override
        public Integer process(String input) throws StepException {
            return Integer.parseInt(input);
        }
    }

    public static class SquareIntegerStep implements Step<Integer,Integer>{

        @Override
        public Integer process(Integer input) throws StepException {
            return input*input;
        }
    }

    public static void main(String[] args) {
        try {
            //create pipeline which will at first pare string to int and then square it
            // step 1) parseInt , step 2) square int
            Integer process = new Pipeline<String, Integer>(new StringToIntStep())
                    .pipe(new SquareIntegerStep())
                    .process("2");
            System.out.println("process = " + process);

        } catch (Step.StepException e) {
            e.printStackTrace();
        }
    }
}
