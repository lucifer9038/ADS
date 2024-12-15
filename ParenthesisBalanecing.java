import java.util.Scanner;

class MyStack3 {
    int maxSize;
    int top;
    char[] stackArray;

    public MyStack3(int size) {
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
            for (int i = top; i >= 0; i--) 
                System.out.println(stackArray[i]);
            System.out.println("");
        }
    }
}
public class ParenthesisBalanecing {
		public static void main (String [] args) {
			Scanner sc =new Scanner(System.in);
			MyStack3 st= new MyStack3(10);
			System.out.println("Please Enter a postfix ecpression");
			String exp=sc.nextLine();
			int isValid=1;
			char c;
			for( int i=0;i<exp.length();i++)
			{
				c=exp.charAt(i);
				char stChar;
				
				if(c=='{' || c=='[' || c=='(')
				{
					st.push(c);
				}
				else 
				{
					if (st.isEmpty())
					{
						isValid=0;
						break;
					}
					else 
					{
						stChar =st.pop();
						if((stChar!='(' && c==')') ||(stChar!='{' && c=='}')||(stChar!='[' && c==']'))
						{
							isValid=0;
							break;
						}
					}
				}			
				
			}
			if(isValid==1 && st.isEmpty())
				System.out.println("\nParemthesis are Balanced");
			else {
				System.out.println("\nParenthisis are not balanced!");
				sc.close();
			}
			
		}
}
