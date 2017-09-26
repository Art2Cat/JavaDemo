package com.art2cat.dev.corejava.iostream;

import java.io.*;


public class BrAndBwOrPwDemo {
    public static void main(String[] args) throws IOException {
        String current = System.getProperty("user.dir");
        String inputPath;
        String outputPath;
        if (FileUtils.getInstance().isWindows()) {
            inputPath = current + "\\text.txt";
            outputPath = current + "\\outtext.txt";
        } else {
            inputPath = current + "/text.txt";
            outputPath = current + "/outtext.txt";
        }

        writeToFile(inputPath, outputPath);
    }

    public static void writeToFile(String inputFilePath, String outputFilePath) throws IOException {
        //对文件进行读写操作
        BufferedReader br = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(inputFilePath)));
        /*BufferedWriter bw = new BufferedWriter(
                new OutputStreamWriter(
						new FileOutputStream("outputFilePath")));*/
        File output = new File(outputFilePath);
        if (!output.exists()) {
            output.createNewFile();
        }
        PrintWriter pw = new PrintWriter(outputFilePath);
        //PrintWriter pw1 = new PrintWriter(outputStream,boolean autoFlush);
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);//一次读一行，并不能识别换行
            /*bw.write(line);
			//单独写出换行操作
			bw.newLine();//换行操作
			bw.flush();*/
            pw.println(line);
            pw.flush();
        }
        br.close();
        //bw.close();
        pw.close();
    }
}
