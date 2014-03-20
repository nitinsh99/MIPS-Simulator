import java.io.FileWriter;
import java.io.IOException;



public class category1 {
	
	public static void j(String inst,String off) throws IOException
	{
		int number1 = Integer.parseInt(off, 2);
	

		FileWriter writer = new FileWriter("disassembly.txt",true);
		writer.append(inst+"\t"+MIPSsim.counter+"\t"+"J #"+number1+"\n");
		writer.close();
		simulator.inst_map.put(MIPSsim.counter,inst);
	}
	
	public static void beq(String inst,String rs,String rt,String off) throws IOException
	{
		int number1 = Integer.parseInt(rs, 2);
		int number2 = Integer.parseInt(rt, 2);
		int number3 = Integer.parseInt(off, 2);

		FileWriter writer = new FileWriter("disassembly.txt",true);
		writer.append(inst+"\t"+MIPSsim.counter+"\t"+"BEQ R"+number1+", R"+number2+", #"+number3+"\n");
		writer.close();
		simulator.inst_map.put(MIPSsim.counter,inst);

	}
	
	public static void bgtz(String inst,String rs,String off) throws IOException
	{
		int number1 = Integer.parseInt(rs, 2);
		int number2 = Integer.parseInt(off, 2);
	

		FileWriter writer = new FileWriter("disassembly.txt",true);
		writer.append(inst+"\t"+MIPSsim.counter+"\t"+"BGTZ R"+number1+", #"+number2+"\n");
		writer.close();
		simulator.inst_map.put(MIPSsim.counter,inst);

	}
	
	
	public static void breakfunc(String inst) throws IOException
	{
		

		FileWriter writer = new FileWriter("disassembly.txt",true);
		writer.append(inst+"\t"+MIPSsim.counter+"\t"+"BREAK"+"\n");
		writer.close();
		simulator.inst_map.put(MIPSsim.counter,inst);

	}
	public static void sw(String inst,String base,String rt,String off) throws IOException
	{
		int number1 = Integer.parseInt(base, 2);
		int number2 = Integer.parseInt(rt, 2);
		int number3 = Integer.parseInt(off, 2);

		FileWriter writer = new FileWriter("disassembly.txt",true);
		writer.append(inst+"\t"+MIPSsim.counter+"\t"+"SW R"+number2+", "+number3+"(R"+number1+")"+"\n");
		writer.close();
		simulator.inst_map.put(MIPSsim.counter,inst);

	}
	public static void lw(String inst,String base,String rt,String off) throws IOException
	{
		int number1 = Integer.parseInt(base, 2);
		int number2 = Integer.parseInt(rt, 2);
		int number3 = Integer.parseInt(off, 2);

		FileWriter writer = new FileWriter("disassembly.txt",true);
		writer.append(inst+"\t"+MIPSsim.counter+"\t"+"LW R"+number2+", "+number3+"(R"+number1+")"+"\n");
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
