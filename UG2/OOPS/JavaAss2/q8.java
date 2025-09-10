    public class q8{
        public static char charAt(String s,int index){
            char ch[]=s.toCharArray();
            return ch[index];
        }
        public static int length(String s){
            String t = s + "?";
            
            int i = 0;
            
            while (t.charAt(i) != '?')
                i++;

            return i;
        }
        public static String toString(String s){
            StringBuilder sb=new StringBuilder(s);
            return sb.reverse().toString();
        }

        public static String subSequence(String s, int i, int j) {
            
            StringBuilder sb=new StringBuilder();
            for (int start = i; start <= j; start++)
                sb.append(s.charAt(start));

            return sb.toString();
        }
        public static void main(String[] args) {
            String s = "Hello World";
            
            System.out.println(charAt(s,0));
            System.out.println(length(s));
            System.out.println(toString(s));
            System.out.println(subSequence(s,0,4));

        }
    }
