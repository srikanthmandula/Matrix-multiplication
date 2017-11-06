import java.util.Scanner;
import java.io.*;

public class MM
{

public static void main(String []args)
{
	
	int mat_a_elements[][]=null,mat_b_elements[][]=null;
	
	try
	{
	BufferedReader br,br1;
	Scanner sc,sc_pre;
	
	br=new BufferedReader(new FileReader("matrixA.txt"));
	br1=new BufferedReader(new FileReader("matrixA.txt"));
	sc=new Scanner(br1);
	sc_pre=new Scanner(br);
	
	int a_rows=0,a_cols=0;
	String str=null;
	
	while(sc_pre.hasNextLine())
	{	
	a_rows++;	
	String[] a_cols_temp=sc_pre.nextLine().split(" ");	
	a_cols=a_cols_temp.length;
	
	}
	
	int row_pos=0;
	String a_ele[]=null;
	
	mat_a_elements=new int[a_rows][a_cols];
	
	while(sc.hasNextLine())
	{			
		String a_cols_temp=sc.nextLine();
		a_ele=a_cols_temp.split(" ");
		
		for(int col_pos=0;col_pos<a_ele.length;col_pos++)
		{
			mat_a_elements[row_pos][col_pos]=Integer.parseInt(a_ele[col_pos]);
		}
		row_pos++;
	}
	
	BufferedReader br2,br3;
	Scanner sc1,sc_pre_b;
	
	br2=new BufferedReader(new FileReader("matrixB.txt"));
	br3=new BufferedReader(new FileReader("matrixB.txt"));
	sc1=new Scanner(br3);
	sc_pre_b=new Scanner(br2);
	
	
	int b_rows=0,b_cols=0;
	
	while(sc_pre_b.hasNextLine())
	{
		b_rows++;		
		String[] b_cols_temp=sc_pre_b.nextLine().split(" ");
		b_cols=b_cols_temp.length;		
	}
				
	int row_pos_b=0;
	String[] b_ele=null;
	
	mat_b_elements=new int[b_rows][b_cols];
	while(sc1.hasNextLine())
	{
		String b_cols_temp=sc1.nextLine();
		b_ele=b_cols_temp.split(" ");
	
		for(int col_pos=0;col_pos<b_ele.length;col_pos++)
		{
			mat_b_elements[row_pos_b][col_pos]=Integer.parseInt(b_ele[col_pos]);
		}
		row_pos_b++;
	}
	
	if(a_cols!=b_rows)
	{
		System.out.println("Matrix multiplication is not possible.Pls change the input matrices.");
		System.exit(1);
	}
	
	int mat_mul_res[][]=new int[a_rows][b_ele.length];
	
	int res=0;
	for(int i=0;i<a_rows;i++)
	{	
		for(int k=0;k<b_ele.length;k++)
		{
			for(int j=0;j<b_rows;j++)
			{
			mat_mul_res[i][k]=mat_mul_res[i][k]+(mat_a_elements[i][j]*mat_b_elements[j][k]);
		
			}
		}
	}
		
File f=new File("matrixAnswer.txt");
f.createNewFile();
FileWriter fw=new FileWriter(f,false);

	
	for(int i=0;i<a_rows;i++)
	{
		for(int j=0;j<b_ele.length;j++)
		{
		fw.write(mat_mul_res[i][j]+" ");
		}
		fw.write(System.getProperty( "line.separator" ));
		
	}

fw.flush();
fw.close();
	
	}//try
	
	catch(Exception e)
	{
		System.out.println("Exception"+e);
	}
	
}

}