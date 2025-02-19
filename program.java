
public class program {
    public int top = -1;
    public int N = 10;
    public void push(String[] data,String x) {
        if(this.top == this.N-1) {
            System.out.println("Stack Overflow");
        
        }else{
            this.top++;
            data[this.top] = x;
        }
    }
    public String pop(String[] data) {
        if(this.top == -1) {
            System.out.println("Stack Underflow");
            return "-1";
        }else{
            String x = data[this.top];
            this.top--;
            return x;
        }
    }
    public int check_precedence(String x) {
        if(x.equals("+") || x.equals("-")) {
            return 1;
        }else if(x.equals("*") || x.equals("/")) {
            return 2;
        }else if(x.equals("^")) {
            return 3;
        }else{
            return 0;
        }
    }
    public static void main(String[] args) {
        String greeting = "A*C+E";
        String ans = "";
        program obj = new program();
        String[] data = new String[obj.N];
        for(int i=0;i<greeting.length();i++){
            char text = greeting.charAt(i);
            if(Character.isLetter(text)){
                ans += text;
            }else if(text == '('){
                obj.push(data, Character.toString(text));
            }else if(text == ')'){
                while(obj.top > -1 && !data[obj.top].equals("(")){
                    ans += obj.pop(data);
                }
                obj.pop(data);
            }else{
                while(obj.top>-1 && obj.check_precedence(Character.toString(text)) <= obj.check_precedence(data[obj.top])) {
                    ans += obj.pop(data);
                }
                obj.push(data,Character.toString(text));
            }
        }
        while (obj.top>-1) {
            ans += obj.pop(data);
        }
        System.out.println(ans);

    }
}