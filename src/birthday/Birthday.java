package birthday;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Birthday {

    private static final String INPUTFILENAME = "/Users/rks-user/git/20130801/src/birthday/Birthday.txt";
    private static final String OUTPUTFILENAME = "/Users/rks-user/git/20130801/src/birthday/outBirthday.txt";

    /**
     * ファイルを読み込み、データを判定し、ファイルに出力する
     * 問題ないデータをYYYY年MM月DD日に変換して出力する
     * @param args
     */
    public static void main(String[] args) {



        try {
            //ファイルを読み込む
            BufferedReader br = new BufferedReader(new FileReader(new File(INPUTFILENAME)));
            PrintWriter pw = new PrintWriter(new FileWriter(new File(OUTPUTFILENAME)));

            String line;
            while((line = br.readLine()) != null){

                //判定する
                //データを変換する
                String newday;
                if ((newday = checkDate(line)) != null) {
                    pw.println(newday);
                }
            }

            br.close();
            pw.close();

        } catch (IOException e) {
            // TODO 自動生成された catch ブロック
            e.printStackTrace();
        }

    }

    private static String checkDate(String day) {
        SimpleDateFormat check = new SimpleDateFormat("yyyyMMdd");
        check.setLenient(false);
        SimpleDateFormat view = new SimpleDateFormat("yyyy年MM月dd日");

        try {

             Date newdate = check.parse(day);
             Date now = new Date();

             if (!now.after(newdate)) {
                 return null;
             }

            return view.format(newdate);
        } catch (ParseException e) {
            return null;
        }


    }

}
