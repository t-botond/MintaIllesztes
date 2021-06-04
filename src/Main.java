import java.util.Scanner;

public class Main {
    private static String text;
    private static String minta;
    private static Integer osszes_osszehasonlitas=0;
    static int i=0;
    public static void main(String[] args){
        System.out.println("Add meg a szöveget!");
        Scanner s= new Scanner(System.in);
        text = s.nextLine();
        System.out.println("Add meg a mintát!");
        minta = s.nextLine();
        s.close();
        boolean illeszkedi = false;
        System.out.println("===========================");
        int ugrasok_szama=0;
        while(i<=text.length()-minta.length()){
            illeszkedi=passzol() || illeszkedi;
            //if(illeszkedi) break;
            ++ugrasok_szama;
        }
        System.out.println("Összes összehasonlítás: "+(osszes_osszehasonlitas));
        System.out.println("Ennyiszer végeztünk eltolást: "+ugrasok_szama);
        System.out.println("Illeszkedik-e: "+((illeszkedi)?"igen":"nem"));

    }
    static boolean passzol(){
        for(int j=0;j<minta.length();++j){
            ++osszes_osszehasonlitas;
            if(text.charAt(i+j)!=minta.charAt(j)) {
                printInfo();
                i+=ugro();
                return false;
            }
        }
        System.out.println(">>>TALÁLAT<<<");
        printInfo();
        i+=ugro();
        return true;
    }
    public static void printInfo(){
        System.out.println("Ugrás értéke: "+ugro());
        System.out.println(text.substring(i));
        System.out.println(minta);
        System.out.println("===========================");
    }

    public static int ugro(){
        if(minta.length()+i < text.length()) {
            for (int j = minta.length() - 1; j >= 0; --j) {
                if (minta.charAt(j) == text.charAt(minta.length()+i)) return minta.length() - j;
            }
        }
        return minta.length()+1;
    }
}
