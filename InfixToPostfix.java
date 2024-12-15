import java.util.Scanner;

class MyStack1 {
    int maxSize;
    int top;
    char [] stackArray;

    public MyStack1(int size) {
        maxSize = size;
        stackArray = new char[maxSize];
        top = -1;
    }

    // PUSH
    public void push(char value) {
        if (isFull()) {
            System.out.println("Stack is Full! Cannot push element!");
        } else {
            stackArray[++top] = value;
        }
    }

    // POP
    public char pop() {
        if (isEmpty()) {
            System.out.println("Stack is Empty! Cannot pop element!!");
            return 'E';
        } else {
            return stackArray[top--];
        }
    }

    // PEEK
    public char peek() {
        if (isEmpty()) {
            System.out.println("Stack is Empty! Cannot peek element.");
            return 'E';
        } else {
            return stackArray[top];
        }
    }

    public boolean isFull() {
        return (top == maxSize - 1);
    }

    public boolean isEmpty() {
        return top == -1;
    }

    void displayAll() {
        if (isEmpty()) {
            System.out.println("\nStack is Empty! No elements to display!!");
        } else {
            System.out.println("Elements in the stack are: ");
            for (int i = top; i >= 0; i--) // Changed to i >= 0
                System.out.println(stackArray[i]);
            System.out.println("");
        }
    }
}
public class InfixToPostfix {
	int prec(char c) {
        if (c == '^')
            return 3;
        else if (c == '/' || c == '*')
            return 2;
        else if (c == '+' || c == '-')
            return 1;
        else
            return -1;
    }
	 void infixToPostfix(String s,MyStack1 st) {
	       StringBuilder result= new StringBuilder();
	       
	       for(int i=0;i<s.length();i++) 
	       {
	    	   char c=s.charAt(i);
	    	   if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9'))
	                result.append(c);
	    	   else if(c=='(')
	    		   st.push('(');
	    	   else if (c == ')') {
	                while (st.peek() != '(') {
	                    result.append(st.pop());
	                }
	                st.pop(); 
	            }
	    	   else {
	                while (!st.isEmpty() && (prec(c) < prec(st.peek()) ||
	                                         prec(c) == prec(st.peek()))) {
	                    result.append(st.pop());
	                }
	                st.push(c);
	            }	   
	       }
	       while (!st.isEmpty()) {
	            result.append(st.pop());
	        }

	        System.out.println(result.toString());
	 }

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		MyStack1 stack1=new MyStack1(15);
		System.out.println("Please Enter infix Expression");
		String exp=sc.nextLine();
		InfixToPostfix ip =new InfixToPostfix();
		ip.infixToPostfix(exp, stack1);
		sc.close();
	}

}
