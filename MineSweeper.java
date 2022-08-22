import java.util.Arrays;
import java.util.Scanner;

public class MineSweeper {

    String[][] arr;
    String[][] nullBoard;
    int row;
    int column;
    int elemanSayisi;
    int mayınSayisi;
    int a;
    int b;
    int c;

    MineSweeper(int row , int column){

        this.row=row;
        this.column=column;
        this.elemanSayisi = this.row * this.column;
        this.mayınSayisi = this.elemanSayisi / 4;
        this.arr= new String[this.row][this.column];
        this.nullBoard= new String[this.row][this.column];
    }

    void coordinate(){

        while(c<mayınSayisi){

            a = (int)(Math.random() * this.row);
            b = (int)(Math.random() * this.column);
            c++;

            //System.out.println("a : " + a + "b : " + b);

            if(arr[a][b] != " * "){

                arr[a][b]=" * ";
            }
        }
    }
    void map(){

        System.out.println("Mayınların Konumu");

        for(int i=0 ; i<arr.length ; i++){

            for(int j=0 ; j<arr[i].length ; j++) {

                if (arr[i][j] != " * ") {

                    arr[i][j]=" - ";
                    System.out.print(" - ");
                }
                else{

                    System.out.print(" * ");
                }
            }
            System.out.println();
        }
    }

    void nullBoard(){

        for (int i = 0; i < nullBoard.length; i++) {

            for (int j = 0; j < nullBoard[i].length; j++) {

                nullBoard[i][j] = " - ";
                System.out.print(nullBoard[i][j]);
            }
            System.out.println();
        }
    }

    void print(String[][] arr) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }

    void board(){

        Scanner input= new Scanner(System.in);

        int count= (elemanSayisi-mayınSayisi);
        boolean True=true;

        while(True) {

            System.out.print("Satır giriniz : ");
            int satir=input.nextInt();

            System.out.print("Sütun giriniz : ");
            int sutun=input.nextInt();

            count--;

            if(satir<0 || sutun<0 || satir>row || sutun>column){

                System.out.println("Geçersiz koordinat.");
                continue;
            }

            System.out.println("===========================");

            if(arr[satir][sutun].equals(" * ")){

                System.out.println("Mayına bastınız.\n GAME OVER!");
                True=false;
                break;
            }
            else if(arr[satir][sutun].equals(" - ")){

                int counter=0;

                for (int i = -1; i <= 1; i++) {

                    if (((satir + i) < 0) || (satir + i >= arr.length)) {
                        continue;
                    }
                    for (int j = -1; j <= 1; j++) {

                        if (((sutun + j) < 0) || (sutun + j >= arr.length)) {
                            continue;
                        }
                        if(arr[satir + i][sutun + j]==" * "){

                            counter++;
                        }
                    }
                }
                nullBoard[satir][sutun]=" " + counter + " ";
                print(nullBoard);
            }
            if(count==0){

                System.out.println("TEBRİKLER!\nOYUNU KAZANDINIZ.");
                True=false;
            }
        }
    }

    void run() {

        coordinate();
        map();
        System.out.println("===========================");
        System.out.println("MAYIN TARLASI OYUNUNA HOŞGELDİNİZ!");

        nullBoard();
        board();

    }
}
