package tutorial;

public class WriteNumber {
    public static void main(String[] args){
        char c;
        for (int i = 0; i<args[0].length();i++) {
            c = args[0].charAt(i);
            int nr = Integer.parseInt(Character.toString(c));
            writeNumber(nr);
        }
    }
    static void writeNumber(int a){
        switch (a){
            case 0: System.out.println("noll"); break;
            case 1: System.out.println("ett"); break;
            case 2: System.out.println("två"); break;
            case 3: System.out.println("tre"); break;
            case 4: System.out.println("fyra"); break;
            case 5: System.out.println("fem"); break;
            case 6: System.out.println("sex"); break;
            case 7: System.out.println("sju"); break;
            case 8: System.out.println("åtta"); break;
            case 9: System.out.println("nio"); break;
            default: System.out.println("Invalid number!"); break;
        }
    }
}
