package �����������;

import java.util.*;
import java.io.*;

public class ����������� {
	public static void main(String[] args) throws IOException {
		System.out.println("������Ŀ������");
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt(); //������Ŀ����
		Random r=new Random();
		BufferedWriter out=new BufferedWriter(new FileWriter("D:/eclipse-workspace/�����������/Exercises.txt"));
		BufferedWriter out2=new BufferedWriter(new FileWriter("D:/eclipse-workspace/�����������/Answers.txt"));
		String[] fuhao= {"+","-"};
		int a,b,c,result;
		String d,e;  //�������
		int[][] ku1=new int[n][2];	//�洢���ɵ���Ŀ���ж��Ƿ��ظ�	
		int[][] ku2=new int[n][3];
		boolean flag=true;
		int j=0,k=0; //�������ֱ�Ϊ1��2����Ŀ����
		for(int i=1;i<=n;i++) {	 //��������Ϊһ��
			a=r.nextInt(100)+1;
			b=r.nextInt(100)+1;
			d=fuhao[r.nextInt(2)];						
			if(r.nextInt()%2==0) { //��������Ϊһ��
				j++;
				ku1[j-1][0]=a;
				ku1[j-1][1]=b;
				Arrays.sort(ku1[j-1]);
				for(int x=0;x<j-1;x++) { //�ж��Ƿ��ظ�
					if(Arrays.equals(ku1[x],ku1[j-1])) {
						flag=false;
						break;
					}
				}
				if(flag) {  //���ظ�
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
				else {  //�ظ�
					j--;
					i--;
				}
			}
			else {  //������Ϊ2
				k++;
				c=r.nextInt(100)+1;
				e=fuhao[r.nextInt(2)];								
				ku2[k-1][0]=a;
				ku2[k-1][1]=b;
				ku2[k-1][2]=c;
				Arrays.sort(ku2[k-1]);
				for(int y=0;y<k-1;y++) {  //�ж��Ƿ��ظ�
					if(Arrays.equals(ku2[y],ku2[k-1])) {
						flag=false;
						break;
					}
				}
				if(flag) {  //���ظ�
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
				else {  //�ظ�
					k--;
					i--;
				}
			}		
		}
		out.close();
		out2.close();
	}
}
