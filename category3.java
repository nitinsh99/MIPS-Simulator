import java.io.FileWriter;
import java.io.IOException;

public class category3 {
	
	public static void addi(String inst,String rs,String rt,String imd) throws IOException
	{
		int number1 = Integer.parseInt(rs, 2);
		int number2 = Integer.parseInt(rt, 2);
		int number3 = Integer.parseInt(imd, 2);

		FileWriter writer = new FileWriter("disassembly.txt",true);
		writer.append(inst+"\t"+MIPSsim.counter+"\t"+"ADDI R"+number2+", R"+number1+", #"+number3+"\n");
		writer.close();
		simulator.inst_map.put(MIPSsim.counter,inst);

	}
	
	public static void andi(String inst,String rs,String rt,String imd) throws IOException
	{
		int number1 = Integer.parseInt(rs, 2);
		int number2 = Integer.parseInt(rt, 2);
		int number3 = Integer.parseInt(imd, 2);

		FileWriter writer = new FileWriter("disassembly.txt",true);
		writer.append(inst+"\t"+MIPSsim.counter+"\t"+"ANDI R"+number2+", R"+number1+", #"+number3+"\n");
		writer.close();
		simulator.inst_map.put(MIPSsim.counter,inst);

	}
	
	public static void ori(String inst,String rs,String rt,String imd) throws IOException
	{
		int number1 = Integer.parseInt(rs, 2);
		int number2 = Integer.parseInt(rt, 2);
		int number3 = Integer.parseInt(imd, 2);

		FileWriter writer = new FileWriter("disassembly.txt",true);
		writer.append(inst+"\t"+MIPSsim.counter+"\t"+"ORI R"+number2+", R"+number1+", #"+number3+"\n");
		writer.close();
		simulator.inst_map.put(MIPSsim.counter,inst);

	}
	
	public static void xori(String inst,String rs,String rt,String imd) throws IOException
	{
		int number1 = Integer.parseInt(rs, 2);
		int number2 = Integer.parseInt(rt, 2);
		int number3 = Integer.parseInt(imd, 2);

		FileWriter writer = new FileWriter("disassembly.txt",true);
		writer.append(inst+"\t"+MIPSsim.counter+"\t"+"XORI R"+number2+", R"+number1+", #"+number3+"\n");
		writer.close();
		simulator.inst_map.put(MIPSsim.counter,inst);

	}
	
	public static void error() throws IOException
	{
		
		FileWriter writer = new FileWriter("disassembly.txt",true);
		writer.append("error");
		writer.close();
	}

}
