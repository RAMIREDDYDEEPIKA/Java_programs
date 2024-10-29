class BasicCalculator {
    public static void main(String args[]) {
        int a = 4;
        int b = 3;
        char op = '%';
        switch (op) {
            case '+':
                System.out.println(a + " + " + b + " = " + (a + b));
                break;
            case '-':
                System.out.println(a + " - " + b + " = " + (a - b));
                break;
            case '*':
                System.out.println(a + " * " + b + " = " + (a * b));
                break;
            case '/':
                System.out.println(a + " / " + b + " = " + (a / b));
                break;
            case '%':
                System.out.println(a + " % " + b + " = " + (a % b));
                break;
            default:
                System.out.println("Enter valid operator");
                break;
        }
    }
}