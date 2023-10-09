package ch1;

public class study {
    public static void main(String[] args) {

        for(int j=1; j<6; j++){
            for(int i=2; i<10; i++){
                if(i%2==0){
                    System.out.print(i+"x"+j+"="+j*i+"\t");
                }
                else{
                    if(j+5 == 10){
                        System.out.print("\t"+"\t");
                    }
                    else{
                        System.out.print(i+"x"+(j+5)+"="+(j+5)*i+"\t");
                    }
                }
            }
            System.out.println();
        }

//        for(int j=1; j<10; j++){
//            if(j<6) {
//                for (int i = 2; i < 10; i = i + 2) {
//                    System.out.print(i + "x" + j + "=" + j * i + "\t");
//                }
//            }else{
//                for(int i=3; i<10; i=i+2){
//                    System.out.print(i + "x" + j + "=" + j * i + "\t");
//                }
//            }
//            System.out.println();
//        }
    }
}
