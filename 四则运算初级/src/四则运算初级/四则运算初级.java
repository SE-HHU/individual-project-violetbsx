package 四则运算初级;

import java.util.*;
import java.io.*;

public class 四则运算初级 {
	public static void main(String[] args) throws IOException {
		System.out.println("生成题目个数：");
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt(); //生成题目个数
		Random r=new Random();
		BufferedWriter out=new BufferedWriter(new FileWriter("D:/eclipse-workspace/四则运算初级/Exercises.txt"));
		BufferedWriter out2=new BufferedWriter(new FileWriter("D:/eclipse-workspace/四则运算初级/Answers.txt"));
		String[] fuhao= {"+","-"};
		int a,b,c,result;
		String d,e;  //运算符号
		int[][] ku1=new int[n][2];	//存储生成的题目，判断是否重复	
		int[][] ku2=new int[n][3];
		boolean flag=true;
		int j=0,k=0; //符号数分别为1、2的题目个数
		for(int i=1;i<=n;i++) {	 //符号数暂为一个
			a=r.nextInt(100)+1;
			b=r.nextInt(100)+1;
			d=fuhao[r.nextInt(2)];						
			if(r.nextInt()%2==0) { //符号数仅为一个
				j++;
				ku1[j-1][0]=a;
				ku1[j-1][1]=b;
				Arrays.sort(ku1[j-1]);
				for(int x=0;x<j-1;x++) { //判断是否重复
					if(Arrays.equals(ku1[x],ku1[j-1])) {
						flag=false;
						break;
					}
				}
				if(flag) {  //不重复
					out.write(i+"."+a+d+b);
					if(d.equals("+")) {
						result=a+b;
					}
					else {	
						result=a-b;	
					}
					out.write("=");
					out2.write(i+"."+result);
					out.newLine();
					out2.newLine();
				}
				else {  //重复
					j--;
					i--;
				}
			}
			else {  //符号数为2
				k++;
				c=r.nextInt(100)+1;
				e=fuhao[r.nextInt(2)];								
				ku2[k-1][0]=a;
				ku2[k-1][1]=b;
				ku2[k-1][2]=c;
				Arrays.sort(ku2[k-1]);
				for(int y=0;y<k-1;y++) {  //判断是否重复
					if(Arrays.equals(ku2[y],ku2[k-1])) {
						flag=false;
						break;
					}
				}
				if(flag) {  //不重复
					out.write(i+"."+a+d+b+e+c);	
					if(d.equals("+")) {
						result=a+b;
					}
					else {	
						result=a-b;	
					}
					if(e.equals("+")) {
						result=result+c;
					}
					else {
						result=result-c;
					}
					out.write("=");
					out2.write(i+"."+result);
					out.newLine();
					out2.newLine();
				}
				else {  //重复
					k--;
					i--;
				}
			}		
		}
		out.close();
		out2.close();
	}
}
