import java.io.FileWriter;
import java.io.IOException;


public class category2 {
	
	public static void add(String inst,String rs,String rt,String rd) throws IOException
	{
		int number1 = Integer.parseInt(rs, 2);
		int number2 = Integer.parseInt(rt, 2);
		int number3 = Integer.parseInt(rd, 2);

		FileWriter writer = new FileWriter("disassembly.txt",true);
		writer.append(inst+"\t"+MIPSsim.counter+"\t"+"ADD R"+number3+", R"+number1+", R"+number2+"\n");
		writer.close();
		simulator.inst_map.put(MIPSsim.counter,inst);

	}
	
	public static void sub(String inst,String rs,String rt,String rd) throws IOException
	{
		int number1 = Integer.parseInt(rs, 2);
		int number2 = Integer.parseInt(rt, 2);
		int number3 = Integer.parseInt(rd, 2);

		FileWriter writer = new FileWriter("disassembly.txt",true);
		writer.append(inst+"\t"+MIPSsim.counter+"\t"+"SUB R"+number3+", R"+number1+", R"+number2+"\n");
		writer.close();
		simulator.inst_map.put(MIPSsim.counter,inst);

	}
	
	public static void mul(String inst,String rs,String rt,String rd) throws IOException
	{
		int number1 = Integer.parseInt(rs, 2);
		int number2 = Integer.parseInt(rt, 2);
		int number3 = Integer.parseInt(rd, 2);

		FileWriter writer = new FileWriter("disassembly.txt",true);
		writer.append(inst+"\t"+MIPSsim.counter+"\t"+"MUL R"+number3+", R"+number1+", R"+number2+"\n");
		writer.close();
		simulator.inst_map.put(MIPSsim.counter,inst);

	}
	
	public static void and(String inst,String rs,String rt,String rd) throws IOException
	{
		int number1 = Integer.parseInt(rs, 2);
		int number2 = Integer.parseInt(rt, 2);
		int number3 = Integer.parseInt(rd, 2);

		FileWriter writer = new FileWriter("disassembly.txt",true);
		writer.append(inst+"\t"+MIPSsim.counter+"\t"+"AND R"+number3+", R"+number1+", R"+number2+"\n");
		writer.close();
		simulator.inst_map.put(MIPSsim.counter,inst);

	}
	
	public static void or(String inst,String rs,String rt,String rd) throws IOException
	{
		int number1 = Integer.parseInt(rs, 2);
		int number2 = Integer.parseInt(rt, 2);
		int number3 = Integer.parseInt(rd, 2);

		FileWriter writer = new FileWriter("disassembly.txt",true);
		writer.append(inst+"\t"+MIPSsim.counter+"\t"+"OR R"+number3+", R"+number1+", R"+number2+"\n");
		writer.close();
		simulator.inst_map.put(MIPSsim.counter,inst);

	}
	
	public static void xor(String inst,String rs,String rt,String rd) throws IOException
	{
		int number1 = Integer.parseInt(rs, 2);
		int number2 = Integer.parseInt(rt, 2);
		int number3 = Integer.parseInt(rd, 2);

		FileWriter writer = new FileWriter("disassembly.txt",true);
		writer.append(inst+"\t"+MIPSsim.counter+"\t"+"XOR R"+number3+", R"+number1+", R"+number2+"\n");
		writer.close();
		simulator.inst_map.put(MIPSsim.counter,inst);

	}
	
	public static void nor(String inst,String rs,String rt,String rd) throws IOException
	{
		int number1 = Integer.parseInt(rs, 2);
		int number2 = Integer.parseInt(rt, 2);
		int number3 = Integer.parseInt(rd, 2);
		
		
		FileWriter writer = new FileWriter("disassembly.txt",true);
		writer.append(inst+"\t"+MIPSsim.counter+"\t"+"NOR R"+number3+", R"+number1+", R"+number2+"\n");
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
