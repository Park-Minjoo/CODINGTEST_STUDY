import java.util.*;

class Solution {

    public String[] solution(String[] expressions) {
        List<String> correctExpressions = new ArrayList<>();
        List<String> incorrectExpressions = new ArrayList<>();

        for (String expression : expressions) {
            if (expression.contains("X")) {
                incorrectExpressions.add(expression);
                continue;
            }
            correctExpressions.add(expression);
        }

        int maxNumber = getMaxNumber(expressions);
        List<Integer> possibleNumbers = new ArrayList<>();

        first: for (int base = maxNumber + 1; base < 10; base++) {
            for (String correctExpression : correctExpressions) {
                String[] elements = correctExpression.split(" ");

                int firstNumber = Integer.parseInt(elements[0], base);
                int secondNumber = Integer.parseInt(elements[2], base);
                int resultNumber = Integer.parseInt(elements[4], base);

                if ("+".equals(elements[1]) && !(firstNumber + secondNumber == resultNumber)) {
                    continue first;
                }
                if ("-".equals(elements[1]) && !(firstNumber - secondNumber == resultNumber)) {
                    continue first;
                }
            }
            
            possibleNumbers.add(base);
        }

        String[] answer = new String[incorrectExpressions.size()];

        for (int i=0; i < incorrectExpressions.size(); i++) {
            String incorrectExpression = incorrectExpressions.get(i);
            String[] elements = incorrectExpression.split(" ");
            List<String> results = new ArrayList<>();

            for (Integer base : possibleNumbers) {
                int firstNumber = Integer.parseInt(elements[0], base);
                int secondNumber = Integer.parseInt(elements[2], base);

                String result;
                if ("+".equals(elements[1])) {
                    result = Integer.toString(firstNumber + secondNumber, base);
                }else {
                    result = Integer.toString(firstNumber - secondNumber, base);
                }

                if (results.contains(result)) {
                    continue;
                }

                results.add(result);
                
                if (results.size() > 1) {
                    break;
                }
            }

            if (results.size() == 1) {
                elements[4] = results.get(0);
            } else {
                elements[4] = "?";
            }

            answer[i] = String.join(" ", elements);
        }
        return answer;
    }

    private int getMaxNumber(String[] expressions) {
        int maxNumber = 0;
        for (String expression : expressions) {
            for (char element : expression.toCharArray()) {
                if (Character.isDigit(element)) {
                    maxNumber = Math.max(maxNumber, Character.getNumericValue(element));
                }
            }
        }
        return maxNumber;
    }
}
