
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class MIPSsim {

	/**
	 * @param args
	 * @throws IOException 
	 */
	
	public static int counter=128;
	public static boolean breakCheck=false;
	public static File file;
	public static int break_record;
	public static void main(String[] args) throws IOException {
		
		
		
		// TODO Auto-generated method stub
 
		String filename=args[0];
		String string;
		 file = new File(filename);
		 File file1 = new File("simulation.txt");
		 file1.delete();
		 File file2  = new File("disassembly.txt");
		 file2.delete();
		 
		FileReader fr = new FileReader(file.getAbsolutePath());
		BufferedReader br = new BufferedReader(fr);
		//string = br.readLine();
		
		
		
		while((string = br.readLine()) != null)
		{
			//string = br.readLine();
			//System.out.println(string);
			if(string.substring(0,3).equalsIgnoreCase("110") && breakCheck == false)
					{
					if(string.substring(13,16).equalsIgnoreCase("000"))
					{
						category2.add(string, string.substring(3,8),string.substring(8,13), string.substring(16,21));
						counter += 4;
						
					}
					else if(string.substring(13,16).equalsIgnoreCase("001"))
					{
						category2.sub(string, string.substring(3,8),string.substring(8,13), string.substring(16,21));
						counter += 4;
						
					}
					
					else if(string.substring(13,16).equalsIgnoreCase("010"))
					{
						category2.mul(string, string.substring(3,8),string.substring(8,13), string.substring(16,21));
						counter += 4;

						
					}
					else if(string.substring(13,16).equalsIgnoreCase("011"))
					{
						category2.and(string, string.substring(3,8),string.substring(8,13), string.substring(16,21));
						counter += 4;

						
					}
					else if(string.substring(13,16).equalsIgnoreCase("100"))
					{
						category2.or(string, string.substring(3,8),string.substring(8,13), string.substring(16,21));
						counter += 4;

						
					}
					else if(string.substring(13,16).equalsIgnoreCase("101"))
					{
						category2.xor(string, string.substring(3,8),string.substring(8,13), string.substring(16,21));
						counter += 4;

						
					}
					else if(string.substring(13,16).equalsIgnoreCase("110"))
					{
						category2.nor(string, string.substring(3,8),string.substring(8,13), string.substring(16,21));
						counter += 4;

						
					}
					else
					{
						category2.error();
						counter += 4;

					}
					
				
					}
			
			else if(string.substring(0,3).equalsIgnoreCase("111") && breakCheck == false)
			{
				if(string.substring(13,16).equalsIgnoreCase("000"))
				{
					category3.addi(string, string.substring(3,8),string.substring(8,13), string.substring(16,32));
					counter += 4;
					
				}
				else if(string.substring(13,16).equalsIgnoreCase("001"))
				{
					category3.andi(string, string.substring(3,8),string.substring(8,13), string.substring(16,32));
					counter += 4;
					
				}
				else if(string.substring(13,16).equalsIgnoreCase("010"))
				{
					category3.ori(string, string.substring(3,8),string.substring(8,13), string.substring(16,32));
					counter += 4;
					
				}
				else if(string.substring(13,16).equalsIgnoreCase("001"))
				{
					category3.xori(string, string.substring(3,8),string.substring(8,13), string.substring(16,32));
					counter += 4;
					
				}
				else
				{
					category3.error();
					counter += 4;

				}
				
				
				
			}
			
			else if(string.substring(0,3).equalsIgnoreCase("000") && breakCheck == false)
			{
				if(string.substring(3,6).equalsIgnoreCase("000"))
				{
					category1.j(string, string.substring(6,32)+"00");
					counter += 4;
					
				}
				else if(string.substring(3,6).equalsIgnoreCase("010"))
				{
					category1.beq(string, string.substring(6,11),string.substring(11,16), string.substring(16,32)+"00");
					counter += 4;
					
				}
				else if(string.substring(3,6).equalsIgnoreCase("100"))
				{
					category1.bgtz(string, string.substring(6,11), string.substring(16,32)+"00");
					counter += 4;
					
				}
				else if(string.substring(3,6).equalsIgnoreCase("101"))
				{
					breakCheck = true;
					category1.breakfunc(string);
					break_record=counter;
					counter += 4;
					
				}
				else if(string.substring(3,6).equalsIgnoreCase("110"))
				{
					category1.sw(string, string.substring(6,11),string.substring(11,16),string.substring(16,32));
					counter += 4;
					
				}
				else if(string.substring(3,6).equalsIgnoreCase("111"))
				{
					category1.lw(string, string.substring(6,11),string.substring(11,16),string.substring(16,32));
					counter += 4;
					
				}
				else
				{
					category1.error();
					counter += 4;

				}
				
				
				
				
			}
			else
			{
				complement.printData(string);
				counter += 4;
			}
			
		}
		
		br.close();
		//System.out.println(simulator.memory.get(184));

		simulator.simulate();
		
		//System.out.println("Please check");

	}

}
